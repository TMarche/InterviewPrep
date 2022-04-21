package chapter01;

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
	
	@Test
	void testIsUniqueNoDS() {
		assertFalse(e.isUnique2("aaaa"));
		assertFalse(e.isUnique2("test"));
		assertTrue(e.isUnique2("abcd"));
	}
	
	@Test
	void testOneAway() {
		assertTrue(e.oneAway("pale", "ale"));
		assertTrue(e.oneAway("pale", "spale"));
		assertTrue(e.oneAway("pale", "bale"));
		assertFalse(e.oneAway("pale", "bake"));
		assertTrue(e.oneAway("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnpqrstuvwxyz"));
	}
	
	@Test
	void testOneAway2() {
		assertTrue(e.oneAway2("pale", "ale"));
		assertTrue(e.oneAway2("pale", "spale"));
		assertTrue(e.oneAway2("pale", "bale"));
		assertFalse(e.oneAway2("pale", "bake"));
		assertTrue(e.oneAway2("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnpqrstuvwxyz"));
	}
	
	@Test
	void testIsRotation() {
		assertTrue(e.isRotation("waterbottle", "erbottlewat"));
		assertTrue(e.isRotation("erbottlewat", "waterbottle"));
		assertFalse(e.isRotation("a", "abc"));
		assertFalse(e.isRotation("abc", "cba"));
	}
}
