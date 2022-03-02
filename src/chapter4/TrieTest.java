package chapter4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrieTest {
	
	private Trie trie;

	@BeforeEach
	void setUp() throws Exception {
		trie = new Trie();
	}

	@Test
	void testInsert() {
		trie.insert("apple");
		trie.insert("apartment");
		assertTrue(trie.search("apple"));
		assertTrue(trie.search("apartment"));
	}
	
	@Test
	void testSearch() {
		trie.insert("apple");
		trie.insert("apartment");
		assertFalse(trie.search("app"));
		assertFalse(trie.search("banana"));
		trie.insert("app");
		assertTrue(trie.search("app"));
	}
	
	@Test
	void testStartsWith() {
		assertTrue(trie.startsWith(""));
		trie.insert("apple");
		trie.insert("apartment");
		assertTrue(trie.startsWith(""));
		assertTrue(trie.startsWith("a"));
		assertTrue(trie.startsWith("ap"));
		assertTrue(trie.startsWith("app"));
		assertTrue(trie.startsWith("apple"));
		assertFalse(trie.startsWith("b"));
		assertFalse(trie.startsWith("book"));
	}

}
