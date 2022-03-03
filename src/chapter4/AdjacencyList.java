package chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

// Implementation of a graph that does not use an
// explicit representation of edges
// This is also an undirected graph
/**
 * Implementation of an undirected graph that does not use
 * an exiplicit representation of edges.
 * @author tmarc
 *
 * @param <T> Type of data to store in each vertex
 */
public class AdjacencyList<T> {
	public List<Node> nodes;
	
	public AdjacencyList() {
		nodes = new ArrayList<Node>();
	}
	
	public void insertNode(T data) {
		nodes.add(new Node(data));
	}
	
	public void removeNode(int i) {
		// Can we actually remove a node?
		// Removing the node would cause all of the other nodes to shift...
	}
	
	public void insertEdge(int start, int end) {
		if (start > nodes.size() - 1 || end > nodes.size() - 1) return;
		// Undirected graph -- add each as a child of the other
		nodes.get(start).addChild(nodes.get(end));
		nodes.get(end).addChild(nodes.get(start));
	}
	
	public void removeEdge(int start, int end) {
		if (start > nodes.size() - 1 || end > nodes.size() - 1) return;
		// Undirected graph -- remove each as a child of the other
		nodes.get(start).removeChild(nodes.get(end));
		nodes.get(end).removeChild(nodes.get(start));
	}
	
	protected class Node {
		protected T data;
		protected List<Node> children;
		
		public Node(T data) {
			this.data = data;
			children = new ArrayList<Node>();
		}
		
		public void addChild(Node node) {
			children.add(node);
		}
		
		public void removeChild(Node node) {
			children.remove(node);
		}
	}
}
