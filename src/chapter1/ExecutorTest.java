package chapter1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExecutorTest {
	
	private Executor e;

	@BeforeEach
	void setUp() throws Exception {
		e = new Executor();
	}

	@Test
	void testIsUnique() {
		assertFalse(e.isUnique("aaaa"));
		assertFalse(e.isUnique("test"));
		assertTrue(e.isUnique("abcd"));
	}

}
