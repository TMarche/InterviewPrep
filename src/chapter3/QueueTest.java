package chapter3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	
	private Queue<String> queue;

	@BeforeEach
	void setUp() throws Exception {
		queue = new Queue<String>();
	}

	@Test
	void testAdd() {
		queue.add("first");
		assertEquals("first", queue.peek());
		queue.add("second");
		assertEquals("first", queue.peek());
		queue.remove();
		assertEquals("second", queue.peek());
		queue.remove();
		assertTrue(queue.isEmpty());
	}

	@Test
	void testRemove() {
		assertEquals(null, queue.remove());
		queue.add("first");
		queue.add("second");
		queue.add("third");
		assertEquals("first", queue.remove());
		assertEquals("second", queue.remove());
		assertEquals("third", queue.remove());
	}

	@Test
	void testPeek() {
		assertEquals(null, queue.peek());
		queue.add("first");
		queue.add("second");
		queue.add("third");
		assertEquals("first", queue.peek());
		queue.remove();
		queue.remove();
		queue.remove();
		assertEquals(null, queue.peek());
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.add("first");
		assertFalse(queue.isEmpty());
		queue.remove();
		assertTrue(queue.isEmpty());
	}

}
