package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
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
	
	public int numPathsWithSum(int sum) {
		return numPathsWithSum(sum, root);
	}
	
	public int numPathsWithSum(int sum, Node node) {
		if (node == null) return 0;
		
		return numPathsStartingAtNodeWithSum(sum, node) +
			   numPathsWithSum(sum, node.left) +
			   numPathsWithSum(sum, node.right);
	}
	
	public int numPathsStartingAtNodeWithSum(int sum, Node node) {
		return numPathsStartingAtNodeWithSumHelper(sum, node, 0);
	}
	
	public int numPathsStartingAtNodeWithSumHelper(int sum, Node node, int currentSum) {
		if (node == null) return 0;
		
		currentSum += node.data;
		return (currentSum == sum ? 1 : 0) +
			   numPathsStartingAtNodeWithSumHelper(sum, node.left, currentSum ) + 
			   numPathsStartingAtNodeWithSumHelper(sum, node.right, currentSum );
	}
		
	public ArrayList<LinkedList<Integer>> bstSequence() {
		return bstSequence(root);
	}
	
	public ArrayList<LinkedList<Integer>> bstSequence(Node node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		
		ArrayList<LinkedList<Integer>> leftSeq = bstSequence(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = bstSequence(node.right);
		
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right: rightSeq) {
				ArrayList<LinkedList<Integer>> woven = new ArrayList<LinkedList<Integer>>();
				weave(left, right, prefix, woven);
				result.addAll(woven);
			}
		}
		return result;
	}
	
	private void weave(
		LinkedList<Integer> a,
		LinkedList<Integer> b,
		LinkedList<Integer> pre,
		ArrayList<LinkedList<Integer>> results)
	{
		if (a.size() == 0 || b.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) pre.clone();
			result.addAll(a);
			result.addAll(b);
			results.add(result);
			return;
		}
		
		// Evaluate using first item from a
		Integer headFirst = a.removeFirst();
		pre.addLast(headFirst);
		weave(a, b, pre, results);
		pre.removeLast();
		a.addFirst(headFirst);
		
		// Evaluate using first item from b
		Integer headSecond = b.removeFirst();
		pre.addLast(headSecond);
		weave(a, b, pre, results);
		pre.removeLast();
		b.addFirst(headSecond);
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
