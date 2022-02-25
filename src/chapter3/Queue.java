package chapter3;

import chapter2.LinkedList;

public class Queue<T> {
	private LinkedList<T> list;
	
	public Queue() {
		list = new LinkedList<T>();
	}
	
	// Add element to back of queue
	public void add(T data) {
		list.insertAtTail(data);
	}
	
	// Remove element from front of queue
	public T remove() {
		if (isEmpty()) return null;
		T retVal = list.getHead().getData();
		list.deleteAtHead();
		return retVal;
	}
	
	// View item at front of queue
	public T peek() {
		if (isEmpty()) return null;
		return list.getHead().getData();
	}
	
	public boolean isEmpty() {
		return list.getHead() == null;
	}
}
