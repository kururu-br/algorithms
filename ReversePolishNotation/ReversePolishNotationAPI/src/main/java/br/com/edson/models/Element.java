/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * Element model                                                                                        |
 *                                                                                                      |
 * This is the Element class that will be stored in the Stack.                                          |
 *                                                                                                      | 
 *   Element 1       Element 2    ...    Element N                                                      | 
 * ┌──────────┐    ┌──────────┐        ┌──────────┐                                                     |
 * │          │    │          │        │          │                                                     |
 * │ D A T A  │    │ D A T A  │        │ D A T A  │                                                     |
 * │          │    │          │        │          │                                                     |
 * ├──────────┤    ├──────────┤        ├──────────┤                                                     |
 * │          │    │          │        │          │                                                     |
 * │ N E X T  │--->│ N E X T  │------->│ N E X T  │                                                     |
 * │          │    │          │        │          │                                                     |
 * └──────────┘    └──────────┘        └──────────┘                                                     |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *                                                                                                      |
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-14                                                                           |
 * @modified       2019-08-15                                                                           |
 * @systemLayer    Model                                                                                |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-14      This is an initial version of the Element model used in the Stack data structure     |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson.models;

public class Element<T> {
	
	private T data;
	private Element<?> next;
	
	public Element() {
	}
	
	public Element(T data) {
		this.data = data;
	}
	
	public Element(T data, Element<?> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Element<?> getNext() {
		return next;
	}

	public void setNext(Element<?> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}
}
