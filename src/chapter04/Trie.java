package chapter04;

public class Trie {
	private Node root;
	
	public Trie() {
		root = new Node();
	}

	// Allows characters a-z
	public void insert(String word) {
		word = word.toLowerCase();
		Node currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (currentNode.children[getIndex(c)] != null) {
				currentNode = currentNode.children[getIndex(c)];
			} else {
				currentNode.children[getIndex(c)] = new Node();
				currentNode = currentNode.children[getIndex(c)];
			}
		}
		currentNode.isWord = true;
	}

	public boolean search(String word) {
		Node node = getNode(word);
		return node != null && node.isWord;
	}

	public boolean startsWith(String word) {
		return getNode(word) != null;
	}
	
	private Node getNode(String word) {
		word = word.toLowerCase();
		Node currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (currentNode.children[getIndex(c)] == null) return null;
			else currentNode = currentNode.children[getIndex(c)];
		}
		return currentNode;
	}
	
	private int getIndex(char c) {
		return c - 'a';
	}
		
	protected class Node {
		Node[] children;
		boolean isWord;
		
		public Node() {
			children = new Node[26];
			isWord = false;
		}
	}
}
