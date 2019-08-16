/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * InfixPostFixConverterController                                                                      |
 *                                                                                                      |
 * This is the controller with the entry points from Reverse Polish Notation algorithm.                 |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 * 	   Method		|	Input					 |	Output	|	Description                             |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * 	   convert  	|  - type ("infix"/"postfix")|	JSON 	|	Entry point to convert between          |
 *                  |  - JSON    				 |			|	infix/postfix							|
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * Input format:                                                                                        |
 * {                                                                                                    |
 * 	 "expression": "<infix/postfix expression>"                                                         |
 * }                                                                                                    |
 *                                                                                                      |
 * Output format:                                                                                       |
 * {                                                                                                    |
 *   "expression": "<infix/postfix expression>"                                                         |
 * }                                                                                                    |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-14                                                                           |
 * @modified       2019-08-14                                                                           |
 * @systemLayer    Controller                                                                           |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-14      This is an initial version of the InfixPostFixConverter controller based on a Stack  |
 *                 data structure implementation.                                                       |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edson.models.Message;
import br.com.edson.services.PostfixConverterService;

@RestController
@RequestMapping("/polish")
public class InfixPostfixConverterController {
	
	private static final Logger log = Logger.getLogger(InfixPostfixConverterController.class.getName());
	
	private PostfixConverterService postFixConverterService;
	
	@Autowired
	public InfixPostfixConverterController(PostfixConverterService postFixConverterService) {
		this.postFixConverterService = postFixConverterService;
	}

	@PostMapping(value="/convert/{type}", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
										, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Message> convert(@PathVariable("type") String type, @RequestBody Message model) {
		
		log.info("Request to convert to " + type + " type of the expression " + model.getExpression());
		Message msg = new Message();
		msg.setExpression(postFixConverterService.converter(model.getExpression()));
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}

}
