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
		Stack<Integer> intStack = new Stack<Integer>();
		intStack.push(3);
		intStack.push(2);
		intStack.push(1);
		Executor.sortStack(intStack);
		assertEquals(1, intStack.pop());
		assertEquals(2, intStack.pop());
		assertEquals(3, intStack.pop());
		assertTrue(intStack.isEmpty());
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(2);
		Executor.sortStack(intStack);
		assertEquals(1, intStack.pop());
		assertEquals(2, intStack.pop());
		assertEquals(2, intStack.pop());
		assertEquals(3, intStack.pop());
		intStack.push(-7);
		intStack.push(-7);
		intStack.push(-7);
		Executor.sortStack(intStack);
		assertEquals(-7, intStack.pop());
		assertEquals(-7, intStack.pop());
		assertEquals(-7, intStack.pop());
	}
	
	@Test
	void testSortStack2() {
		Stack<Integer> intStack = new Stack<Integer>();
		intStack.push(3);
		intStack.push(2);
		intStack.push(1);
		Executor.sortStack2(intStack);
		assertEquals(1, intStack.pop());
		assertEquals(2, intStack.pop());
		assertEquals(3, intStack.pop());
		assertTrue(intStack.isEmpty());
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(2);
		Executor.sortStack2(intStack);
		assertEquals(1, intStack.pop());
		assertEquals(2, intStack.pop());
		assertEquals(2, intStack.pop());
		assertEquals(3, intStack.pop());
		intStack.push(-7);
		intStack.push(-7);
		intStack.push(-7);
		Executor.sortStack2(intStack);
		assertEquals(-7, intStack.pop());
		assertEquals(-7, intStack.pop());
		assertEquals(-7, intStack.pop());
	}

}
