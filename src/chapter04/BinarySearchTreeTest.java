package chapter04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
	
	private BinarySearchTree<Integer> tree;

	@BeforeEach
	void setUp() throws Exception {
		tree = new BinarySearchTree<Integer>();
	}

	@Test
	void testInsert() {
		tree.insert(0);
		tree.insert(-5);
		tree.insert(7);
		tree.insert(-2);
		tree.insert(-7);
		tree.insert(1);
		tree.insert(3);
		assertTrue(tree.has(0));
		assertTrue(tree.has(-5));
		assertTrue(tree.has(7));
		assertTrue(tree.has(-2));
		assertTrue(tree.has(-7));
		assertTrue(tree.has(1));
		assertTrue(tree.has(3));
	}
	
	@Test
	void testPreOrder() {
		tree.insert(0);
		tree.insert(-5);
		tree.insert(7);
		tree.insert(-2);
		tree.insert(-7);
		tree.insert(1);
		tree.insert(3);
		tree.preOrder((x) -> System.out.println(x.toString()));
	}
	
	@Test
	void testInOrder() {
		tree.insert(0);
		tree.insert(-5);
		tree.insert(7);
		tree.insert(-2);
		tree.insert(-7);
		tree.insert(1);
		tree.insert(3);
		tree.inOrder((x) -> System.out.println(x.toString()));
	}
	
	@Test
	void testPostOrder() {
		tree.insert(0);
		tree.insert(-5);
		tree.insert(7);
		tree.insert(-2);
		tree.insert(-7);
		tree.insert(1);
		tree.insert(3);
		tree.postOrder((x) -> System.out.println(x.toString()));
	}
}
