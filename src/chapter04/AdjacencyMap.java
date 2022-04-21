package chapter04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Implementation of directed graph that uses
 * Java HashMap<K,V> to store data
 * @author tmarc
 *
 */
public class AdjacencyMap<T> {
	
	Map<String, Node> nodes;
	
	public AdjacencyMap() {
		nodes = new HashMap<String, Node>();
	}
	
	public boolean hasRoute(String start, String end) {
		Node startNode = nodes.get(start);
		Node endNode = nodes.get(end);
		if (startNode == null || endNode == null) return false;
		if (startNode.name == endNode.name) return true;
		
		// Initialize queues for start and end
		Set<String> visited = new HashSet<String>();
		Queue<Node> startQueue = new LinkedList<Node>();
		visited.add(startNode.name);
		startQueue.addAll(startNode.outgoing.values());
		Queue<Node> endQueue = new LinkedList<Node>();
		visited.add(endNode.name);
		endQueue.addAll(endNode.incoming.values());
		
		// Perform bi-directional search from start and end
		while(!startQueue.isEmpty() || !endQueue.isEmpty()) {
			if (!startQueue.isEmpty()) {
				Node current = startQueue.remove();
				if (visited.contains(current.name)) return true;
				visited.add(current.name);
				current.outgoing.forEach((k, v) -> {
					if (!visited.contains(v.name)) startQueue.add(v);
				});
			}
			if (!endQueue.isEmpty()) {
				Node current = endQueue.remove();
				if (visited.contains(current.name)) return true;
				visited.add(current.name);
				current.incoming.forEach((k, v) -> {
					if (!visited.contains(v.name)) endQueue.add(v);
				});
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return nodes.isEmpty();
	}
	
	public Node getVertex(String name) {
		return nodes.get(name);
	}
	
	public void insertVertex(String name, T data) {
		if (nodes.get(name) != null) removeVertex(name); // Remove edges associated with old node
		nodes.put(name, new Node(name, data));
	}
	
	public void removeVertex(String name) {
		// Need to remove vertex along with all incoming edges
		Node toRemove = nodes.get(name);
		if (toRemove == null) return;
		// Iterate over incoming edges, and remove the
		// corresponding outgoing edges
		toRemove.incoming.forEach((key, value) -> {
			value.removeOutgoing(toRemove);
		});
		toRemove.outgoing.forEach((key, value) -> {
			value.removeIncoming(toRemove);
		});
		nodes.remove(toRemove.name);
	}
	
	public void insertEdge(String start, String end) {
		Node startNode = nodes.get(start);
		Node endNode = nodes.get(end);
		if (startNode == null || endNode == null) return;
		startNode.addOutgoing(endNode);
		endNode.addIncoming(startNode);
	}
	
	public void removeEdge(String start, String end) {
		Node startNode = nodes.get(start);
		Node endNode = nodes.get(end);
		if (startNode == null || endNode == null) return;
		startNode.removeOutgoing(endNode);
		endNode.removeIncoming(startNode);
	}
	
	protected class Node {
		protected T data;
		protected String name;
		protected Map<String, Node> incoming;
		protected Map<String, Node> outgoing;
		
		public Node(String name, T data) {
			this.name = name;
			this.data = data;
			this.incoming = new HashMap<String, Node>();
			this.outgoing = new HashMap<String, Node>();
		}
		
		public T getData() {
			return this.data;
		}
		
		public void addOutgoing(Node node) {
			outgoing.put(node.name, node);
		}
		
		public void removeOutgoing(Node node) {
			outgoing.remove(node.name);
		}
		
		public void addIncoming(Node node) {
			incoming.put(node.name, node);
		}
		
		public void removeIncoming(Node node) {
			incoming.remove(node.name);
		}
	}
}
