package chapter04;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void preOrder(Consumer<T> visit) {
		preOrder(root, visit);
	}
	
	private void preOrder(Node current, Consumer<T> visit) {
		if (current == null) return;
		visit.accept(current.data);
		preOrder(current.left, visit);
		preOrder(current.right, visit);
	}
	
	public void inOrder(Consumer<T> visit) {
		inOrder(root, visit);
	}
	
	private void inOrder(Node current, Consumer<T> visit) {
		if (current == null) return;
		inOrder(current.left, visit);
		visit.accept(current.data);
		inOrder(current.right, visit);
	}
	
	public void postOrder(Consumer<T> visit) {
		postOrder(root, visit);
	}
	
	private void postOrder(Node current, Consumer<T> visit) {
		if (current == null) return;
		postOrder(current.left, visit);
		postOrder(current.right, visit);
		visit.accept(current.data);
	}
	
	public void insert(T data) {
		if (root == null) root = new Node(data);
		Node parent = root;
		while (true) {
			int comparisonValue = data.compareTo(parent.data);
			if (comparisonValue == 0) {
				// Already exists -- do not insert duplicate
				return;
			} else if (comparisonValue == -1) {
				// Insert in left subtree
				if (parent.left == null) {
					parent.left = new Node(data);
					return;
				} else {
					parent = parent.left;
				}
			} else {
				// Insert in right subtree
				if (parent.right == null) {
					parent.right = new Node(data);
					return;
				} else {
					parent = parent.right;
				}
			}
		}
	}
	
	public boolean has(T data) {
		Node current = root;
		while (true) {
			if (current == null) return false;
			int comparisonValue = data.compareTo(current.data);
			if (comparisonValue == 0) {
				return true;
			} else if (comparisonValue == -1) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
	}
		
	public class Node {
		protected T data;
		protected Node left;
		protected Node right;
		
		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public Node(T data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
