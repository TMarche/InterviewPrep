package chapter02;

import java.util.HashSet;

public class LinkedList<T> {
	private Node head;
	private Node tail;
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	// Cases:
	//   1. 0 nodes  (head == null; tail == null;)
	//   2. 1 node   (head == tail)
	//   3. 1+ nodes (head != tail)
	public Node detectLoop() {
		HashSet<Node> encountered = new HashSet<Node>();
		Node current = head;
		while (current != null) {
			if (encountered.contains(current)) return current;
			encountered.add(current);
			current = current.next;
		}
		return null;
	}
	
	public void removeDuplicates() {
		HashSet<T> encountered = new HashSet<T>();
		if (head == null) return;
		Node previous = head;
		encountered.add(previous.data);
		while (previous.next != null) {
			if (encountered.contains(previous.next.data)) {
				// remove from list
				previous.next = previous.next.next;
				if (previous.next == null ) {
					tail = previous;
					return;
				} else {
					previous.next.previous = previous;
				}
			} else {
				encountered.add(previous.next.data);
				previous = previous.next;
			}
		}
	}
	
	public void insertAtHead(T data) {
		Node newNode = new Node(data, null, head);
		if (head != null) {
			newNode.setNext(head);
			head.setPrevious(newNode);			
		}
		if (tail == null) {
			tail = newNode;
		}
		head = newNode;
	}
	
	public void add(T data) {
		insertAtTail(data);
	}
	
	public void insertAtTail(T data) {
		insertAtTail(data, false);
	}
	
	public void insertAtTail(T data, boolean shouldLoop) {
		Node newNode = new Node(data, tail, shouldLoop ? head : null);
		if (tail != null) {
			newNode.setPrevious(tail);
			tail.setNext(newNode);
		}
		if (head == null) {
			head = newNode;
		}
		tail = newNode;
	}
	
	public void insertAt(T data, int index) {
		if (index < 0) return;
		if (index == 0) { 
			insertAtHead(data);
			return;
		}
		int indexOfPrevious = 0;
		Node previous = head;
		if (previous == null) return;
		while(indexOfPrevious < index - 1) {
			indexOfPrevious++;
			previous = previous.getNext();
			if (previous == null ) return;
		}
		// We should have a pointer to the node prior to the
		// one we're inserting
		Node next = previous.getNext();
		if (next == null) {
			insertAtTail(data);
			return;
		}
		Node newNode = new Node(data, previous, next);
		previous.setNext(newNode);
		next.setPrevious(newNode);
	}
	
	public void deleteAt(int index) {
		if (index == 0) {
			deleteAtHead();
			return;
		}
		Node previous = head;
		int indexOfPrevious = 0;
		while(indexOfPrevious < index - 1) {
			indexOfPrevious++;
			previous = previous.getNext();
			if (previous.getNext() == null) return;
		}
		// We should have a pointer to the node prior to the
		// one we're deleting
		Node next = previous.getNext().getNext();
		if (next == null) {
			deleteAtTail();
			return;
		}
		previous.setNext(next);
		next.setPrevious(previous);
		return;
	}
	
	public void deleteAtHead() {
		if (head == null) return;
		Node next = head.getNext();
		if (next != null) {
			head = next;
			next.setPrevious(null);
		} else {
			// head and tail are the same node
			head = null;
			tail = null;
		}
	}
	
	public void deleteAtTail() {
		if (tail == null) return;
		Node previous = tail.getPrevious();
		if (previous != null) {
			tail = previous;
			previous.setNext(null);
		} else {
			// head and tail are the same node
			head = null;
			tail = null;
		}
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public Node getAt(int index) {
		int currentIndex = 0;
		Node current = head;
		if (current == null) return null;
		if (index == 0) return current;
		while (currentIndex < index) {
			currentIndex++;
			current = current.getNext();
			if (current == null) return null;
			if (currentIndex == index) return current;
		}
		return null;
	}
	
	public class Node {
		private Node previous;
		private Node next;
		private T data;
		
		public Node(T data, Node previous, Node next) {
			this.previous = previous;
			this.next = next;
			this.data = data;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}
	}
}
