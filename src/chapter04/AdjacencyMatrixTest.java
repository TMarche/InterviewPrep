package chapter04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdjacencyMatrixTest {
	
	private AdjacencyMatrix graph;

	@BeforeEach
	void setUp() throws Exception {
		graph = new AdjacencyMatrix();
	}

	@Test
	void testInsertVertex() {
		// Assert no vertices exist
		assertFalse(graph.hasVertex(0));
		assertFalse(graph.hasVertex(1));
		
		// Add vertices and assert existence
		graph.insertVertex();
		graph.insertVertex();
		assertTrue(graph.hasVertex(0));
		assertTrue(graph.hasVertex(1));
	}

	@Test
	void testInsertEdge() {
		// Attempt to insert edges before vertices exist
		graph.insertEdge(0, 0);
		graph.insertEdge(0, 1);
		assertFalse(graph.hasEdge(0, 0));
		assertFalse(graph.hasEdge(0, 1));
		
		// Add vertices and edges and assert existence
		graph.insertVertex();
		graph.insertVertex();
		graph.insertEdge(0, 0);
		graph.insertEdge(0, 1);
		assertTrue(graph.hasEdge(0, 0));
		assertTrue(graph.hasEdge(0, 1));
		
		// Attempt to add edges outside range
		graph.insertEdge(0, 2);
		graph.insertEdge(2, 0);
		graph.insertEdge(2, 2);
		assertFalse(graph.hasEdge(0, 2));
		assertFalse(graph.hasEdge(2, 0));
		assertFalse(graph.hasEdge(2, 2));
	}

	@Test
	void testRemoveVertex() {
		// Attempt to remove vertex before it exists
		graph.removeVertex(0);
		
		// Add vertices and remove one
		graph.insertVertex();
		graph.insertVertex();
		assertTrue(graph.hasVertex(0));
		assertTrue(graph.hasVertex(1));
		graph.removeVertex(0);
		assertFalse(graph.hasVertex(0));
		assertTrue(graph.hasVertex(1));
		
		// Re-insert vertex and add edges
		graph.insertVertex();
		assertTrue(graph.hasVertex(0));
		assertTrue(graph.hasVertex(1));
		graph.insertEdge(0, 0);
		graph.insertEdge(1, 0);
		graph.insertEdge(0, 1);
		graph.insertEdge(1, 1);
		assertTrue(graph.hasEdge(0, 0));
		assertTrue(graph.hasEdge(1, 0));
		assertTrue(graph.hasEdge(0, 1));
		assertTrue(graph.hasEdge(1, 1));
		
		// Remove vertex and assert that some edges no longer exist
		graph.removeVertex(0);
		assertFalse(graph.hasEdge(0, 0));
		assertFalse(graph.hasEdge(1, 0));
		assertFalse(graph.hasEdge(0, 1));
		assertTrue(graph.hasEdge(1, 1));
		
		// Re-insert vertex and assert that edges haven't changed
		graph.insertVertex();
		assertFalse(graph.hasEdge(0, 0));
		assertFalse(graph.hasEdge(1, 0));
		assertFalse(graph.hasEdge(0, 1));
		assertTrue(graph.hasEdge(1, 1));		
	}

	@Test
	void testRemoveEdge() {
		// Attempt to remove edge that does not exist
		graph.removeEdge(0, 0);
		
		// Add edges and test removal
		graph.insertVertex();
		graph.insertVertex();
		graph.insertEdge(0, 0);
		graph.insertEdge(1, 0);
		graph.insertEdge(0, 1);
		graph.insertEdge(1, 1);
		assertTrue(graph.hasEdge(0, 0));
		assertTrue(graph.hasEdge(1, 0));
		assertTrue(graph.hasEdge(0, 1));
		assertTrue(graph.hasEdge(1, 1));
		graph.removeEdge(0, 0);
		graph.removeEdge(1, 0);
		graph.removeEdge(0, 1);
		graph.removeEdge(1, 1);
		assertFalse(graph.hasEdge(0, 0));
		assertFalse(graph.hasEdge(1, 0));
		assertFalse(graph.hasEdge(0, 1));
		assertFalse(graph.hasEdge(1, 1));
		
		// Attempt to remove edges that don't exist
		graph.removeEdge(-1, 0);
		graph.removeEdge(0, -1);
		graph.removeEdge(0, 2);
		graph.removeEdge(0, 4);
		graph.removeEdge(2, 0);
		graph.removeEdge(4, 0);
	}

	@Test
	void testHasVertex() {
		assertFalse(graph.hasVertex(-1));
		assertFalse(graph.hasVertex(0));
		assertFalse(graph.hasVertex(1));
		assertFalse(graph.hasVertex(1));
		assertFalse(graph.hasVertex(3));
		assertFalse(graph.hasVertex(4));
		graph.insertVertex();
		graph.insertVertex();
		graph.insertVertex();
		graph.insertVertex();
		graph.insertVertex();
		assertTrue(graph.hasVertex(0));
		assertTrue(graph.hasVertex(1));
		assertTrue(graph.hasVertex(2));
		assertTrue(graph.hasVertex(3));
		assertTrue(graph.hasVertex(4));
	}
}
