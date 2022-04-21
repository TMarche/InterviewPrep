package chapter04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinHeapTest {
	
	private MinHeap<Integer> heap;

	@BeforeEach
	void setUp() throws Exception {
		heap = new MinHeap<Integer>();
	}

	@Test
	void testGetMin() {
		heap.add(7);
		assertEquals(7, heap.getMin());
		heap.add(9);
		assertEquals(7, heap.getMin());
		heap.add(4);
		assertEquals(4, heap.getMin());
		heap.add(11);
		assertEquals(4, heap.getMin());
		heap.add(4);
		assertEquals(4, heap.getMin());
		heap.add(3);
		assertEquals(3, heap.getMin());
		heap.add(4);
		assertEquals(3, heap.getMin());
		heap.add(7);
		assertEquals(3, heap.getMin());
		heap.add(1);
		assertEquals(1, heap.getMin());
		heap.add(2);
		assertEquals(1, heap.getMin());
		heap.add(1);
		assertEquals(1, heap.getMin());
		heap.add(0);
		assertEquals(0, heap.getMin());
		heap.add(-5);
		assertEquals(-5, heap.getMin());
	}
	
	@Test
	void testExtractMin() {
		heap.add(9);
		heap.add(4);
		heap.add(15);
		heap.add(1);
		heap.add(12);
		heap.add(8);
		heap.add(13);
		heap.add(5);
		heap.add(2);
		heap.add(7);
		heap.add(0);
		heap.add(14);
		heap.add(3);
		heap.add(6);
		heap.add(10);
		heap.add(11);
		assertEquals(0, heap.extractMin());
		assertEquals(1, heap.extractMin());
		assertEquals(2, heap.extractMin());
		assertEquals(3, heap.extractMin());
		assertEquals(4, heap.extractMin());
		assertEquals(5, heap.extractMin());
		assertEquals(6, heap.extractMin());
		assertEquals(7, heap.extractMin());
		assertEquals(8, heap.extractMin());
		assertEquals(9, heap.extractMin());
		assertEquals(10, heap.extractMin());
		assertEquals(11, heap.extractMin());
		assertEquals(12, heap.extractMin());
		assertEquals(13, heap.extractMin());
		assertEquals(14, heap.extractMin());
		assertEquals(15, heap.extractMin());
	}

}
