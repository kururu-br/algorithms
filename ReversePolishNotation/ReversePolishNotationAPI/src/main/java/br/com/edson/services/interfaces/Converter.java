/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * Converter                                                                                            |
 *                                                                                                      |
 * This is the Converter interface.                									        		  	|
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 * 	   Method		|	Input	|	Output	|	Description                                             |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * 	   convert  	|  String   |	String	|	Method to convert between infix to postfix or vice versa|
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *                                                                                                      |
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-15                                                                           |
 * @modified       2019-08-16                                                                           |
 * @systemLayer    Interface                                                                            |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-15      This is an initial version of the Converter interface.                               |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson.services.interfaces;

public interface Converter {
	String converter(String value);
}
