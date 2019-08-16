/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * Stack model                                                                                          |
 *                                                                                                      |
 * This is the Stack class to define the abstract data type from Stack data structure.                  |
 *                                                                                                      | 
 *   push element1    push element2    push element3          pop             peek                      | 
 *   ┌──────────┐     ┌──────────┐      ┌──────────┐     ┌──────────┐     ┌──────────┐                  |
 *   │          │     │          │      │          │     │          │     │          │                  |
 *   ├──────────┤     ├──────────┤      ├──────────┤     ├──────────┤     ├──────────┤                  |
 *   │          │     │          │      │ element3 │top  │          │     │          │                  |
 *   ├──────────┤     ├──────────┤      ├──────────┤     ├──────────┤     ├──────────┤                  |
 *   │          │     │ element2 │top   │ element2 │     │ element2 │top  │ element2 │top               |
 *   ├──────────┤     ├──────────┤      ├──────────┤     ├──────────┤     ├──────────┤                  |
 *   │ element1 │top  │ element1 │      │ element1 │     │ element1 │     │ element1 │                  |
 *   └──────────┘     └──────────┘      └──────────┘     └──────────┘     └──────────┘                  |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────| 
 * 	   Method		|	Input	|	Output	|	Description                                             |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * 	   push  		|  T data	|	N/A 	|	Push (stack up) an element on the stack data structure  |
 * 	   pop   		|  N/A  	|	T data 	|	Pop (remove) an element from the stack                  |
 * 	   peek   		|  N/A  	|	T data 	|	Peek (not remove) the element from the top of the stack |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 *                                                                                                      |
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-14                                                                           |
 * @modified       2019-08-14                                                                           |
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
package br.com.edson.services.interfaces.implementations;

import br.com.edson.models.Element;
import br.com.edson.services.interfaces.Stack;

public class StackImpl<T> implements Stack<Object> {

	private int capacity;
	private int size;
	private Element<T> top;

	public StackImpl(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.top = null;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Element<T> getTop() {
		return top;
	}

	public void setTop(Element<T> top) {
		this.top = top;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void push(Object data) {

		if (size == capacity) {
			throw new StackOverflowError("Stack is full");
		}

		Element<Object> elem = new Element<>(data, top);
		top = (Element<T>) elem;
		size++;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		if (size == 0) {
			throw new StackOverflowError("Stack is empty");
		}
		T data = top.getData();
		top = (Element<T>) top.getNext();
		size--;

		return data;
	}

	@Override
	public T peek() {
		if (top != null) {
			T data = top.getData();
			return data;
		}
		return null;
	}
	
	@Override
	public Boolean isEmpty() {
		return size == 0 ? true : false;
	}
}
