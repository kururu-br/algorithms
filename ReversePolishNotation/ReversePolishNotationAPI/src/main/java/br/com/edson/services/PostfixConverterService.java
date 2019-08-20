/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * PostfixConverterService                                                                              |
 *                                                                                                      |
 * This is the postfix converter service.                                                               |
 *                                                                                                      | 
 *         Infix expression    	     Postfix expression                                                 | 
 *   ┌───────────────────────┐   ┌───────────────────────┐                                              |
 *   │ ( (A * B) + (C / D) ) │   │     A B * C D / +     │                                              |
 *   ├───────────────────────┤   ├───────────────────────┤                                              |
 *   │ ((A * (B + C) ) / D)  │   │     A B C + * D /     │                                              |
 *   ├───────────────────────┤   ├───────────────────────┤                                              |
 *   │ (A * (B + (C / D) ) ) │   │     A B C D / + *     │                                              |
 *   └───────────────────────┘   └───────────────────────┘                                              |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 *       Method      |	Input	|	Output	|	Description                                             |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *    converter      |  String	|	String 	|	Converter an infix expression to postfix                |
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
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.edson.helpers.Helpers;
import br.com.edson.services.interfaces.Converter;
import br.com.edson.services.interfaces.implementations.StackImpl;

@Service
public class PostfixConverterService implements Converter {

	private StackImpl<String> stack;
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
		String[] ch = Pattern.compile("[a-zA-Z0-9{1,2}\\ˆ|\\+|-|\\*|\\|\\(|\\)/]")
                .matcher(expression)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);

		for (int i = 0; i < ch.length; i++) {
			
			if (ch[i].contains("(")) {
				stack.push(ch[i]);
				continue;
			}
			
			if (ch[i].contains(")")) {
				while (!String.valueOf(stack.peek()).contains("(")) {
					postfix += stack.pop();
				}
				stack.pop();
				continue;
			}
			if (helpers.isOperand(ch[i])) {
				postfix += ch[i];
				continue;
			}
			
			if (helpers.isOperator(ch[i])) {
				if (stack.isEmpty()) {
					stack.push(ch[i]);
				}
				else if (helpers.priority(ch[i]) > helpers.priority(String.valueOf(stack.peek()))) {
					stack.push(ch[i]);
				} else {
					while(!stack.isEmpty()) {
						postfix += stack.pop();
					}
					stack.push(ch[i]);
				}
				continue;
			}
		}
		if (stack.getSize() == 1) {
			postfix += stack.pop();
			log.info("Expression infix " + expression + " converted to " + postfix);
			return postfix;
		}
		return "Postfix is not well-formed";
	}

}
