/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * Message model                                                                                        |
 *                                                                                                      |
 * This is the Message class that will be transfered in the REST controller (request/response).         |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * Input message format:                                                                                |
 * {                                                                                                    |
 * 	 "expression": "<infix/postfix expression>"                                                         |
 * }                                                                                                    |
 *                                                                                                      |
 * Output message format:                                                                               |
 * {                                                                                                    |
 *   "expression": "<infix/postfix expression>"                                                         |
 * }                                                                                                    |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-15                                                                           |
 * @modified       2019-08-16                                                                           |
 * @systemLayer    Model                                                                                |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-15      This is an initial version of the Message class                                      |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson.models;

public class Message {
	
	private String expression;
	
	public String getExpression() {
		return expression;
	}

	public void setExpression(String message) {
		this.expression = message;
	}
}
