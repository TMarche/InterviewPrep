package chapter4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdjacencyMapTest {
	
	private AdjacencyMap<Integer> map;
	
	@BeforeEach
	void setUp() throws Exception {
		map = new AdjacencyMap<Integer>();
	}

	@Test
	void testGetVertex() {
		// Attempt get non-existent vertex
		assertNull(map.getVertex("A"));

		// Insert vertices and get vertex data
		map.insertVertex("A", 1);
		map.insertVertex("B", 2);
		map.insertVertex("C", 3);
		assertEquals(1, map.getVertex("A").getData());
		assertEquals(2, map.getVertex("B").getData());
		assertEquals(3, map.getVertex("C").getData());
	}

	@Test
	void testInsertVertex() {
		// Add vertices normally
		map.insertVertex("A", 1);
		map.insertVertex("B", 2);
		map.insertVertex("C", 3);
		assertEquals(1, map.getVertex("A").getData());
		assertEquals(2, map.getVertex("B").getData());
		assertEquals(3, map.getVertex("C").getData());
		
		// Add edges for testing vertex replacement
		map.insertEdge("A", "B");
		map.insertEdge("B", "A");
		assertNotNull(map.getVertex("A").outgoing.get("B"));
		assertNotNull(map.getVertex("B").incoming.get("A"));
		assertNotNull(map.getVertex("B").outgoing.get("A"));
		assertNotNull(map.getVertex("A").incoming.get("B"));
		
		// Replace vertex -- associated edges should be removed
		map.insertVertex("A", 2);
		assertNull(map.getVertex("A").outgoing.get("B"));
		assertNull(map.getVertex("B").incoming.get("A"));
		assertNull(map.getVertex("B").outgoing.get("A"));
		assertNull(map.getVertex("A").incoming.get("B"));
		assertEquals(2, map.getVertex("A").getData());
	}

	@Test
	void testRemoveVertex() {
		// Attempt remove vertex before it exists
		map.removeVertex("A");
		
		// Add vertices and remove
		map.insertVertex("A", 1);
		map.insertVertex("B", 2);
		map.insertVertex("C", 3);
		map.insertEdge("A", "B");
		map.insertEdge("B", "A");
		assertNotNull(map.getVertex("A").outgoing.get("B"));
		assertNotNull(map.getVertex("B").incoming.get("A"));
		assertNotNull(map.getVertex("B").outgoing.get("A"));
		assertNotNull(map.getVertex("A").incoming.get("B"));
		map.removeVertex("A");
		assertNull(map.getVertex("B").incoming.get("A"));
		assertNull(map.getVertex("B").outgoing.get("A"));
	}

	@Test
	void testInsertEdge() {
		// Attempt insert edges before vertices exist
		map.insertEdge("A", "B");
		map.insertEdge("B", "C");
		map.insertEdge("C", "A");

		// Insert vertices and edges normally
		map.insertVertex("A", 1);
		map.insertVertex("B", 2);
		map.insertVertex("C", 3);
		map.insertEdge("A", "B");
		map.insertEdge("B", "C");
		map.insertEdge("C", "A");
		assertNotNull(map.getVertex("A").outgoing.get("B"));
		assertNotNull(map.getVertex("B").outgoing.get("C"));
		assertNotNull(map.getVertex("C").outgoing.get("A"));
		assertNotNull(map.getVertex("B").incoming.get("A"));
		assertNotNull(map.getVertex("C").incoming.get("B"));
		assertNotNull(map.getVertex("A").incoming.get("C"));
		
		// Attempt insert edges to non-existent nodes
		map.insertEdge("A", "D");
		map.insertEdge("D", "A");
		
		// Insert same edges again
		map.insertEdge("A", "B");
		map.insertEdge("B", "C");
		map.insertEdge("C", "A");
		assertNotNull(map.getVertex("A").outgoing.get("B"));
		assertNotNull(map.getVertex("B").outgoing.get("C"));
		assertNotNull(map.getVertex("C").outgoing.get("A"));
		assertNotNull(map.getVertex("B").incoming.get("A"));
		assertNotNull(map.getVertex("C").incoming.get("B"));
		assertNotNull(map.getVertex("A").incoming.get("C"));
		
		// Insert edge to same vertex
		map.insertEdge("A", "A");
		assertNotNull(map.getVertex("A").outgoing.get("A"));
		assertNotNull(map.getVertex("A").incoming.get("A"));
	}

	@Test
	void testRemoveEdge() {
		// Attempt remove edge before it exists
		map.removeEdge("A", "A");
		
		// Add test vertices and edges
		map.insertVertex("A", 1);
		map.insertVertex("B", 2);
		map.insertVertex("C", 3);
		map.insertEdge("A", "B");
		map.insertEdge("B", "C");
		map.insertEdge("C", "A");
		map.insertEdge("A", "A");
		assertNotNull(map.getVertex("A").outgoing.get("B"));
		assertNotNull(map.getVertex("B").outgoing.get("C"));
		assertNotNull(map.getVertex("C").outgoing.get("A"));
		assertNotNull(map.getVertex("A").outgoing.get("A"));
		assertNotNull(map.getVertex("B").incoming.get("A"));
		assertNotNull(map.getVertex("C").incoming.get("B"));
		assertNotNull(map.getVertex("A").incoming.get("C"));
		assertNotNull(map.getVertex("A").incoming.get("A"));
		
		// Attempt remove non-existent edges
		map.removeEdge("A", "D");
		map.removeEdge("D", "A");
		
		// Remove all edges
		map.removeEdge("A", "B");
		map.removeEdge("B", "C");
		map.removeEdge("C", "A");
		map.removeEdge("A", "A");
		assertNull(map.getVertex("A").outgoing.get("B"));
		assertNull(map.getVertex("B").outgoing.get("C"));
		assertNull(map.getVertex("C").outgoing.get("A"));
		assertNull(map.getVertex("A").outgoing.get("A"));
		assertNull(map.getVertex("B").incoming.get("A"));
		assertNull(map.getVertex("C").incoming.get("B"));
		assertNull(map.getVertex("A").incoming.get("C"));
		assertNull(map.getVertex("A").incoming.get("A"));
	}
	
	@Test
	void testIsEmpty() {
		assertTrue(map.isEmpty());
		map.insertVertex("A", 1);
		assertFalse(map.isEmpty());
		map.removeVertex("A");
		assertTrue(map.isEmpty());
	}
	
	@Test
	void testHasRoute() {
		assertFalse(map.hasRoute("A", "A"));
		map.insertVertex("A", 1);
		map.insertVertex("B", 2);
		map.insertVertex("C", 3);
		assertTrue(map.hasRoute("A", "A"));
		assertFalse(map.hasRoute("A", "B"));
		map.insertEdge("A", "B");
		map.insertEdge("B", "C");
		map.insertEdge("C", "A");
		assertTrue(map.hasRoute("A", "C"));
		assertTrue(map.hasRoute("B", "A"));
		assertTrue(map.hasRoute("C", "B"));
		map.insertVertex("D", 4);
		map.insertVertex("E", 5);
		map.insertVertex("F", 6);
		map.insertVertex("G", 7);
		assertFalse(map.hasRoute("A", "G"));
		assertFalse(map.hasRoute("G", "A"));
		map.insertEdge("C", "D");
		map.insertEdge("D", "E");
		map.insertEdge("E", "F");
		map.insertEdge("F", "G");
		assertTrue(map.hasRoute("A", "G"));
		assertFalse(map.hasRoute("G", "A"));
		map.insertEdge("G", "C");
		assertTrue(map.hasRoute("G", "A"));
	}

}
