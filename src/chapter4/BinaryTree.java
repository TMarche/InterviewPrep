package chapter4;

import java.util.List;

public class BinaryTree {
	protected Node root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public BinaryTree(List<Integer> preOrder, List<Integer> inOrder) {
		if (preOrder.size() == 0 || inOrder.size() == 0) {
			this.root = null;
			return;
		}
		
		this.root = new Node(preOrder.get(0));
		int rootIndex = inOrder.indexOf(preOrder.get(0));
		List<Integer> leftInOrder = inOrder.subList(0, rootIndex);
		List<Integer> leftPreOrder = preOrder.subList(1, leftInOrder.size() + 1);
		List<Integer> rightInOrder = inOrder.subList(rootIndex + 1, inOrder.size());
		List<Integer> rightPreOrder = preOrder.subList(leftInOrder.size() + 1, preOrder.size());
		this.root.left = buildTree(leftPreOrder, leftInOrder);
		this.root.right = buildTree(rightPreOrder, rightInOrder);
	}
	
	private Node buildTree(List<Integer> preOrder, List<Integer> inOrder) {
		if (preOrder.size() == 0 || inOrder.size() == 0) return null;
		Node node = new Node(preOrder.get(0));
		int rootIndex = inOrder.indexOf(preOrder.get(0));
		List<Integer> leftInOrder = inOrder.subList(0, rootIndex);
		List<Integer> leftPreOrder = preOrder.subList(1, leftInOrder.size() + 1);
		List<Integer> rightInOrder = inOrder.subList(rootIndex + 1, inOrder.size());
		List<Integer> rightPreOrder = preOrder.subList(leftInOrder.size() + 1, preOrder.size());
		node.left = buildTree(leftPreOrder, leftInOrder);
		node.right = buildTree(rightPreOrder, rightInOrder);
		return node;
	}
	
	public boolean isValidBST() {
		// Validate each of the nodes using min/max information passed down at each level
		if (root == null) return true;
		// equal to min or max should be fine
		return true && isValidBSTHelper(root.left, null, root.data) && isValidBSTHelper(root.right, root.data + 1, null);
	}
	
	public boolean isValidBSTHelper(Node node, Integer min, Integer max) {
		if (node == null) return true;
		if ((min != null && node.data < min) || (max != null && node.data > max)) return false;
		return true && isValidBSTHelper(node.left, min, node.data) && isValidBSTHelper(node.right, node.data + 1, max);
	}
	
	protected class Node {
		Node left;
		Node right;
		int data;
		
		protected Node(int data) {
			this.left = null;
			this.right = null;
			this.data = data;
		}
		
		protected Node(int data, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
}
