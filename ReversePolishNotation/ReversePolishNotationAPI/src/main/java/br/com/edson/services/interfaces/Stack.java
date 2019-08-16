/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * Stack interface                                                                                      |
 *                                                                                                      |
 * This is the Stack interfacec.                                                                        |
 *                                                                                                      | 
 *    Stack                                                                                             | 
 * ┌──────────┐                                                                                         | 
 * │          │                                                                                         | 
 * ├──────────┤                                                                                         | 
 * │          │                                                                                         | 
 * ├──────────┤                                                                                         | 
 * │          │                                                                                         | 
 * ├──────────┤                                                                                         | 
 * │          │                                                                                         | 
 * └──────────┘                                                                                         | 
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *                                                                                                      |
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-14                                                                           |
 * @modified       2019-08-16                                                                           |
 * @systemLayer    Interface                                                                            |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-14      This is an initial version of the Stack interface                                    |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson.services.interfaces;

public interface Stack<T> {

	T pop();
	T peek();
	void push(T data);
	Boolean isEmpty();
}
