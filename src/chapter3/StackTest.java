package chapter3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
	
	private Stack<String> stack;

	@BeforeEach
	void setUp() throws Exception {
		stack = new Stack<String>();
	}

	@Test
	void testPush() {
		stack.push("first");
		stack.push("second");
		stack.push("third");
		assertEquals("third", stack.peek());
	}

	@Test
	void testPop() {
		assertNull(stack.pop());
		stack.push("first");
		stack.push("second");
		stack.push("third");
		assertEquals("third", stack.pop());
		assertEquals("second", stack.pop());
		assertEquals("first", stack.pop());
		assertNull(stack.pop());
	}

	@Test
	void testPeek() {
		assertNull(stack.peek());
		stack.push("first");
		stack.push("second");
		stack.push("third");
		assertEquals("third", stack.peek());
		stack.pop();
		stack.pop();
		stack.pop();
		assertNull(stack.peek());
	}

	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push("first");
		stack.push("second");
		assertFalse(stack.isEmpty());
		stack.pop();
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}

}
