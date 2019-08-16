/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * InfixConverterService                                                                                |
 *                                                                                                      |
 * This is the infix converter service.                									     		  	|
 *                                                                                                      | 
 *         Postfix expression    	 Infix	expression                                                  | 
 *   ┌───────────────────────┐   ┌───────────────────────┐                                              |
 *   │     A B * C D / +     │   │ ( (A * B) + (C / D) ) │                                              |
 *   ├───────────────────────┤   ├───────────────────────┤                                              |
 *   │     A B C + * D /     │   │ ((A * (B + C) ) / D)  │                                              |
 *   ├───────────────────────┤   ├───────────────────────┤                                              |
 *   │     A B C D / + *     │   │ (A * (B + (C / D) ) ) │                                              |
 *   └───────────────────────┘   └───────────────────────┘                                              |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 * 	   Method		|	Input	|	Output	|	Description                                             |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * 	   converter  	|  String	|	String 	|	Converter a postfix expression to infix                 |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *                                                                                                      |
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-14                                                                           |
 * @modified       2019-08-16                                                                           |
 * @systemLayer    Service                                                                              |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-15      This is an initial version of the InfixConverterService                              |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson.services;

import java.util.logging.Logger;

import br.com.edson.services.interfaces.Converter;

public class InfixConverterService implements Converter {

	private static final Logger log = Logger.getLogger(InfixConverterService.class.getName());

	@Override
	public String converter(String value) {

		log.info("Started converter postfix expression " + value + " to infix.");

		log.info("Expression postfix " + value + " converted to " + value);
		return "not implemented";
	}

}
