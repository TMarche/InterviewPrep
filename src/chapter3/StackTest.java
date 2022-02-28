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
	
	@Test
	void testSortStack() {
		assertNull(Executor.sortStack(null));
		Stack<Integer> intStack = new Stack<Integer>();
		intStack.push(3);
		intStack.push(2);
		intStack.push(1);
		Stack<Integer> sorted = Executor.sortStack(intStack);
		assertEquals(1, sorted.pop());
		assertEquals(2, sorted.pop());
		assertEquals(3, sorted.pop());
		assertTrue(sorted.isEmpty());
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(2);
		sorted = Executor.sortStack(intStack);
		assertEquals(1, sorted.pop());
		assertEquals(2, sorted.pop());
		assertEquals(2, sorted.pop());
		assertEquals(3, sorted.pop());
		intStack.push(-7);
		intStack.push(-7);
		intStack.push(-7);
		sorted = Executor.sortStack(intStack);
		assertEquals(-7, sorted.pop());
		assertEquals(-7, sorted.pop());
		assertEquals(-7, sorted.pop());
	}

}
