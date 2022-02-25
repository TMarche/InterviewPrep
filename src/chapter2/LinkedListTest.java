package chapter2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
	
	private LinkedList<String> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new LinkedList<String>();
	}

	@Test
	void testInsertAtHead() {
		assertEquals(null, list.getAt(0));
		assertEquals(null, list.getAt(-1));
		list.insertAtHead("buns");
		assertEquals("buns", list.getAt(0).getData());
		assertEquals("buns", list.getHead().getData());
		assertEquals("buns", list.getTail().getData());
	}

	@Test
	void testInsertAtTail() {
		assertEquals(null, list.getAt(0));
		assertEquals(null, list.getAt(-1));
		assertEquals(null, list.getAt(1));
		list.insertAtTail("buns");
		assertEquals("buns", list.getAt(0).getData());
		assertEquals("buns", list.getHead().getData());
		assertEquals("buns", list.getTail().getData());
	}

	@Test
	void testInsertAt() {
		list.insertAt("shouldn't work", -1);
		list.insertAt("shouldn't work", 1);
		list.add("first");
		list.add("second");
		list.insertAt("newFirst", 0);
		list.insertAt("newSecond", 2);
		list.insertAt("third", 4);
		assertEquals("newFirst", list.getAt(0).getData());
		assertEquals("newFirst", list.getHead().getData());
		assertEquals("newSecond", list.getAt(2).getData());
		assertEquals("second", list.getAt(3).getData());
		assertEquals("third", list.getAt(4).getData());
		assertEquals("third", list.getTail().getData());
		list.insertAt("shouldn't work", 6);
	}

	@Test
	void testDeleteAt() {
		list.deleteAt(0); // Should do nothing
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");
		list.deleteAt(4); // Should do nothing
		list.deleteAt(0);
		assertEquals("second", list.getAt(0).getData());
		assertEquals("second", list.getHead().getData());
		assertEquals("third", list.getAt(1).getData());
		assertEquals("fourth", list.getAt(2).getData());
		assertEquals("fourth", list.getTail().getData());
		list.deleteAt(1);
		assertEquals("second", list.getAt(0).getData());
		assertEquals("second", list.getHead().getData());
		assertEquals("fourth", list.getAt(1).getData());
		assertEquals("fourth", list.getTail().getData());
		list.deleteAt(1);
		assertEquals("second", list.getAt(0).getData());
		assertEquals("second", list.getHead().getData());
		assertEquals("second", list.getTail().getData());
		list.deleteAt(0);
		assertEquals(null, list.getAt(0));
		assertEquals(null, list.getHead());
		assertEquals(null, list.getTail());
	}

	@Test
	void testDeleteAtHead() {
		list.add("first");
		list.deleteAtHead();
		assertEquals(null, list.getHead());
		assertEquals(null, list.getTail());
		list.add("second");
		list.add("third");
		list.deleteAtHead();
		assertEquals("third", list.getHead().getData());
		assertEquals("third", list.getTail().getData());
	}

	@Test
	void testDeleteAtTail() {
		list.deleteAtTail();
		list.add("first");
		assertEquals("first", list.getHead().getData());
		assertEquals("first", list.getTail().getData());
		list.deleteAtTail();
		assertEquals(null, list.getHead());
		assertEquals(null, list.getTail());
		list.add("second");
		list.add("third");
		assertEquals("second", list.getHead().getData());
		assertEquals("third", list.getTail().getData());
		list.deleteAtTail();
		assertEquals("second", list.getHead().getData());
		assertEquals("second", list.getTail().getData());
	}

	@Test
	void testGetAt() {
		list.add("first");
		list.add("second");
		list.add("third");
		assertEquals("first", list.getAt(0).getData());
		assertEquals("second", list.getAt(1).getData());
		assertEquals("third", list.getAt(2).getData());
		assertEquals(null, list.getAt(-1));
		assertEquals(null, list.getAt(3));
	}
	
	@Test
	void testRemoveDuplicates() {
		list.removeDuplicates();
		list.add("a");
		list.add("b");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("b");
		list.removeDuplicates();
		assertEquals("a", list.getAt(0).getData());
		assertEquals("a", list.getHead().getData());
		assertEquals("b", list.getAt(1).getData());
		assertEquals("c", list.getAt(2).getData());
		assertEquals("c", list.getTail().getData());
		list.removeDuplicates();
		assertEquals("a", list.getAt(0).getData());
		assertEquals("a", list.getHead().getData());
		assertEquals("b", list.getAt(1).getData());
		assertEquals("c", list.getAt(2).getData());
		assertEquals("c", list.getTail().getData());		
	}
	
	@Test
	void testSumLists() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		LinkedList<Integer> result;
		result = Executor.sumLists(list1, list2);
		assertEquals(null, result.getHead());
		assertEquals(null, result.getTail());
		assertEquals(null, result.getAt(0));
		
		// Test with null and zero
		list1.add(0);
		result = Executor.sumLists(list1, list2);
		assertEquals(0, result.getHead().getData());
		assertEquals(0, result.getTail().getData());
		assertEquals(0, result.getAt(0).getData());
		
		result = Executor.sumLists(list2, list1);
		assertEquals(0, result.getHead().getData());
		assertEquals(0, result.getTail().getData());
		assertEquals(0, result.getAt(0).getData());
		
		// Test with null and non-zero
		list1.deleteAtHead();
		list1.add(9);
		list1.add(8); // list1 represents 89
		result = Executor.sumLists(list1, list2);
		assertEquals(9, result.getHead().getData());
		assertEquals(8, result.getTail().getData());
		
		// Test with carry over into hundreds place
		// 89 + 11 --> 100
		list2.add(1);
		list2.add(1);
		result = Executor.sumLists(list1, list2);
		assertEquals(0, result.getAt(0).getData());
		assertEquals(0, result.getAt(1).getData());
		assertEquals(1, result.getAt(2).getData());		
	}
	
	@Test
	void testDetectLoop() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertEquals(null, list.detectLoop());
		list.insertAtTail("D", true);
		assertEquals("A", list.detectLoop().getData());
		list.insertAtHead("1");
		list.insertAtHead("2");
		assertEquals("A", list.detectLoop().getData());
	}

}
