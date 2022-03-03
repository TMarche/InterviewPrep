package chapter4;

public class AdjacencyMatrix {
	private int capacity;
	private boolean[] vertices;
	private boolean[][] edges;
	
	public AdjacencyMatrix() {
		capacity = 4;
		vertices = new boolean[capacity];
		edges = new boolean[capacity][capacity];
	}
	
	public void insertVertex() {
		// Add to first empty cell in nodes
		for (int i = 0; i < vertices.length; i++) {
			if (!vertices[i]) {
				vertices[i] = true;
				return;
			}
		}
		// Not enough room -- increase capacity
		int nextIndex = vertices.length;
		increaseCapacity();
		vertices[nextIndex] = true;
	}
	
	public void insertEdge(int start, int end) {
		if (!hasVertex(start) || !hasVertex(end)) return;
		edges[start][end] = true;
	}
	
	public void removeVertex(int index) {
		if (!hasVertex(index)) return;
		vertices[index] = false;
		for (int i = 0; i < edges.length; i++) {
			// Remove outgoing edges
			removeEdge(index, i);
			// Remove incoming edges
			removeEdge(i, index);
		}
	}
	
	public void removeEdge(int start, int end) {
		if (!hasEdge(start, end)) return;
		edges[start][end] = false;
	}
	
	public boolean hasEdge(int start, int end) {
		if (start < 0 || start > capacity - 1) return false;
		if (end < 0 || end > capacity - 1) return false;
		return edges[start][end];
	}
	
	public boolean hasVertex(int index) {
		if (index < 0 || index > capacity - 1) return false;
		return vertices[index];
	}
	
	/**
	 * Double capacity and resize arrays 
	 */
	public void increaseCapacity() {
		// Double capacity
		capacity *= 2;
		
		// Copy over node data
		boolean[] newVertices = new boolean[capacity];
		for (int i = 0; i < vertices.length; i++) {
			newVertices[i] = vertices[i];
		}
		vertices = newVertices;
		
		// Copy over edge data
		boolean[][] newEdges = new boolean[capacity][capacity];
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[i].length; j++) {
				newEdges[i][j] = edges[i][j];
			}
		}
		edges = newEdges;
	}
}
