package chapter03;

import chapter02.LinkedList;

public class Stack<T> {
	private LinkedList<T> list;
	
	public Stack() {
		list = new LinkedList<T>();
	}
	
	public void push(T data) {
		list.add(data);
	}
	
	public T pop() {
		if (isEmpty()) return null;
		T retVal = list.getTail().getData();
		list.deleteAtTail();
		return retVal;
	}
	
	public T peek() {
		if (isEmpty()) return null;
		return list.getTail().getData();
		
	}
	
	public boolean isEmpty() {
		return list.getHead() == null;
	}
}
