/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * PostfixConverterService                                                                              |
 *                                                                                                      |
 * This is the postfix converter service.                											  	|
 *                                                                                                      | 
 *         Infix expression    		Postfix expression                                                  | 
 *   ┌───────────────────────┐   ┌───────────────────────┐                                              |
 *   │ ( (A * B) + (C / D) ) │   │ 	   A B * C D / +     │                                              |
 *   ├───────────────────────┤   ├───────────────────────┤                                              |
 *   │ ((A * (B + C) ) / D)  │   │     A B C + * D /     │                                              |
 *   ├───────────────────────┤   ├───────────────────────┤                                              |
 *   │ (A * (B + (C / D) ) ) │   │     A B C D / + *     │                                              |
 *   └───────────────────────┘   └───────────────────────┘                                              |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 * 	   Method		|	Input	|	Output	|	Description                                             |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * 	   converter  	|  String	|	String 	|	Converter an infix expression to postfix                |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *                                                                                                      |
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-14                                                                           |
 * @modified       2019-08-15                                                                           |
 * @systemLayer    Service                                                                              |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-15      This is an initial version of the PostfixConverterService                            |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.edson.helpers.Helpers;
import br.com.edson.services.interfaces.Converter;
import br.com.edson.services.interfaces.implementations.StackImpl;

@Service
public class PostfixConverterService implements Converter {

	private StackImpl<Character> stack;
	private Helpers helpers;

	private static final Logger log = Logger.getLogger(PostfixConverterService.class.getName());

	@Autowired
	public PostfixConverterService(Environment env, Helpers helpers) {
		stack = new StackImpl<>(Integer.parseInt(env.getProperty("stack.capacity")));
		this.helpers = helpers;
	}

	@Override
	public String converter(String expression) {

		String postfix = "";
		log.info("Converting infix expression " + expression + " to postfix.");

		for (int i = 0; i < expression.length(); i++) {
			
			Character ch = expression.charAt(i);
			
			if (ch == '(' ) {
				stack.push(ch);
				continue;
			}
			
			if (ch == ')' ) {
				while (stack.peek() != '(') {
					postfix += stack.pop();
				}
				stack.pop();
				continue;
			}
			if (helpers.isOperand(ch)) {
				postfix += ch;
				continue;
			}
			
			if (helpers.isOperator(ch)) {
				if (stack.isEmpty()) {
					stack.push(ch);
				}
				else if (helpers.priority(ch) > helpers.priority(stack.peek())) {
					stack.push(ch);
				} else {
					while(!stack.isEmpty()) {
						postfix += stack.pop();
					}
					stack.push(ch);
				}
				continue;
			}
		}
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}	

		log.info("Expression infix " + expression + " converted to " + postfix);
		return postfix;
	}

}
