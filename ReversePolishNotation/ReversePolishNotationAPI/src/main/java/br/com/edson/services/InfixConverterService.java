/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * InfixConverterService                                                                                |
 *                                                                                                      |
 * This is the infix converter service.                                                                 |
 *                                                                                                      | 
 *         Postfix expression         Infix expression                                                  | 
 *   ┌───────────────────────┐   ┌───────────────────────┐                                              |
 *   │     A B * C D / +     │   │ ( (A * B) + (C / D) ) │                                              |
 *   ├───────────────────────┤   ├───────────────────────┤                                              |
 *   │     A B C + * D /     │   │ ((A * (B + C) ) / D)  │                                              |
 *   ├───────────────────────┤   ├───────────────────────┤                                              |
 *   │     A B C D / + *     │   │ (A * (B + (C / D) ) ) │                                              |
 *   └───────────────────────┘   └───────────────────────┘                                              |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 *    Method      |   Input   |	Output	|	Description                                                 |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *    converter   |  String   |	String 	|	Converter a postfix expression to infix                     |
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.edson.helpers.Helpers;
import br.com.edson.services.interfaces.Converter;
import br.com.edson.services.interfaces.implementations.StackImpl;

@Service
public class InfixConverterService implements Converter {
	
	private StackImpl<String> stack;
	private Helpers helpers;

	private static final Logger log = Logger.getLogger(InfixConverterService.class.getName());
	
	@Autowired
	public InfixConverterService(Environment env, Helpers helpers) {
		stack = new StackImpl<>(Integer.parseInt(env.getProperty("stack.capacity")));
		this.helpers = helpers;
	}

	@Override
	public String converter(String expression) {

		String[] ch = expression.split(" ");
		log.info("Started converter postfix expression " + expression + " to infix.");
		for (int i = 0; i < ch.length; i++) {
			
			if (helpers.isOperand(ch[i])) {
				stack.push(ch[i]);
				continue;
			}
			else if (helpers.isOperator(ch[i])) { 
				String elem1 = stack.pop();
				String elem2 = stack.pop();
				stack.push("("+ elem2 + ch[i] + elem1 + ")");
				
			}
		}
		
		if (stack.getSize() == 1) {
			log.info("Expression postfix " + expression + " converted to " + stack.peek());
			return stack.pop();
		}
		return "Infix is not well-formed";
	}

}
