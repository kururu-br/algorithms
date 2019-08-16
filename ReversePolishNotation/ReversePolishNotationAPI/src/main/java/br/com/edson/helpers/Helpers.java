/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * Helpers                                                                                              |
 *                                                                                                      |
 * This is the Helpers class implementing methods to help during the converter process                  |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 *    Method    |   Input    |	Output	|	Description                                             |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *  priority  	|  Character |	Integer	|	Return the priority number of an operator in a map      |
 *  isOperator	|  Character |	Boolean |	Check if the character is an operator or not            |
 *  isOperand	|  Character |	Boolean |	Check if the character is an operand or not             |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-15                                                                           |
 * @modified       2019-08-16                                                                           |
 * @systemLayer    Helpers                                                                              |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-15      Initial version of Helpers class                                                     |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Helpers {
	
	private static final Map<Character, Integer> operatorsPriority = new HashMap<>();
	
	public Helpers() {
		
		operatorsPriority.put('ˆ', 3);
		operatorsPriority.put('*', 2);
		operatorsPriority.put('/', 2);
		operatorsPriority.put('+', 1);
		operatorsPriority.put('-', 1);
		operatorsPriority.put('(', 0);
	}
	
	public Integer priority(Character operator) {
		return operatorsPriority.get(operator);
	}
	
	public Boolean isOperator(Character operator) {
		return operatorsPriority.containsKey(operator);
	}
	
	public Boolean isOperand(Character operator) {
		return !operatorsPriority.containsKey(operator);
	}

}
