/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * InfixPostFixConverterController                                                                      |
 *                                                                                                      |
 * This is the controller with the entry points from Reverse Polish Notation algorithm.                 |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 *    Method   |	Input                   |   Output   |  Description                                 |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *    convert  |  - type ("infix"/"postfix")|   JSON     |  Entry point to convert between infix/postfix|
 *             |  - JSON                    |            |                                              |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * Input format:                                                                                        |
 * {                                                                                                    |
 *   "expression": "<infix/postfix expression>"                                                         |
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edson.models.Message;
import br.com.edson.services.InfixConverterService;
import br.com.edson.services.PostfixConverterService;

@RestController
@RequestMapping("/polish")
public class InfixPostfixConverterController {

	private static final Logger log = Logger.getLogger(InfixPostfixConverterController.class.getName());

	private PostfixConverterService postFixConverterService;
	private InfixConverterService infixConverterService;

	@Autowired
	public InfixPostfixConverterController(PostfixConverterService postFixConverterService, InfixConverterService infixConverterService) {
		this.postFixConverterService = postFixConverterService;
		this.infixConverterService = infixConverterService;
	}

	@GetMapping(value = "/convert/postfix", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			                                produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Message> postfix(@RequestBody Message model) {

		log.info("Convert the expression " + model.getExpression() + " to postfix type.");
		Message msg = new Message();
		msg.setExpression(postFixConverterService.converter(model.getExpression()));
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}

	@GetMapping(value = "/convert/infix", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
                                          produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Message> infix(@RequestBody Message model) {

		log.info("Convert the expression " + model.getExpression() + " to infixs type.");
		Message msg = new Message();
		msg.setExpression(infixConverterService.converter(model.getExpression()));
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}

}
