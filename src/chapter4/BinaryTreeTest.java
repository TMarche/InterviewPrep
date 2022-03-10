package chapter4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	
	List<Integer> inOrder;
	List<Integer> preOrder;
	
	List<Integer> preOrder2;
	List<Integer> inOrder2;

	List<Integer> preOrder3;
	List<Integer> inOrder3;
	
	List<Integer> preOrder4;
	List<Integer> inOrder4;
	
	List<Integer> preOrder5;
	List<Integer> inOrder5;
	
	List<Integer> preOrder6;
	List<Integer> inOrder6;
	
	List<Integer> preOrder7;
	List<Integer> inOrder7;
	
	List<Integer> preOrder8;
	List<Integer> inOrder8;
	
	List<Integer> preOrder9;
	List<Integer> inOrder9;
	
	@BeforeEach
	void setUp() throws Exception {
		// Valid BST
		preOrder = new ArrayList<Integer>(Arrays.asList(new Integer[] {10, 5, 2, 7, 15, 12, 16}));
		inOrder = new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 5, 7, 10, 12, 15, 16}));
		
		// Invalid BST
		preOrder2 = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 4, 5, 3, 6}));
		inOrder2 = new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 2, 5, 1, 6, 3}));
		
		// Valid BST
		preOrder3 = new ArrayList<Integer>(Arrays.asList(new Integer[] {0, -1, -2, -3}));
		inOrder3 = new ArrayList<Integer>(Arrays.asList(new Integer[] {-3, -2, -1, 0}));
		
		// Valid BST
		preOrder4 = new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 2, 3}));
		inOrder4 = new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 2, 3}));
		
		// Invalid BST
		preOrder5 = new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 3, 4}));
		inOrder5 = new ArrayList<Integer>(Arrays.asList(new Integer[] {3, 2, 4}));
		
		// Valid BST
		preOrder6 = new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 1, 3}));
		inOrder6 = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3}));
		
		// Invalid BST
		preOrder7 = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 2}));
		inOrder7 = new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 1, 2}));
		
		// Invalid BST
		preOrder8 = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, -2, -3, 4, -4, -5}));
		inOrder8 = new ArrayList<Integer>(Arrays.asList(new Integer[] {-2, 2, -3, 1, -4, 4, -5}));
		
		// Invalid BST
		preOrder9 = new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, -1}));
		inOrder9 = new ArrayList<Integer>(Arrays.asList(new Integer[] {-1, 1, 0}));		
	}

	@Test
	void testBinaryTree() {
		BinaryTree bt = new BinaryTree(preOrder, inOrder);
		assertNotNull(bt);
		assertEquals(10, bt.root.data);
		assertEquals(5, bt.root.left.data);
		assertEquals(2, bt.root.left.left.data);
		assertEquals(7, bt.root.left.right.data);
		
		BinaryTree bt2 = new BinaryTree(preOrder2, inOrder2);
		assertNotNull(bt2);
		assertEquals(1, bt2.root.data);
		assertEquals(2, bt2.root.left.data);
		assertEquals(4, bt2.root.left.left.data);
		assertEquals(5, bt2.root.left.right.data);
		assertEquals(3, bt2.root.right.data);
		assertEquals(6, bt2.root.right.left.data);
		
		BinaryTree bt3 = new BinaryTree(preOrder3, inOrder3);
		assertNotNull(bt3);
		assertEquals(0, bt3.root.data);
		assertEquals(-1, bt3.root.left.data);
		assertEquals(-2, bt3.root.left.left.data);
		assertEquals(-3, bt3.root.left.left.left.data);
		assertNull(bt3.root.right);
		
		BinaryTree bt4 = new BinaryTree(preOrder4, inOrder4);
		assertNotNull(bt4);
		assertEquals(0, bt4.root.data);
		assertEquals(1, bt4.root.right.data);
		assertEquals(2, bt4.root.right.right.data);
		assertEquals(3, bt4.root.right.right.right.data);
		
		BinaryTree bt5= new BinaryTree(preOrder5, inOrder5);
		assertNotNull(bt5);
		assertEquals(2, bt5.root.data);
		assertEquals(3, bt5.root.left.data);
		assertEquals(4, bt5.root.right.data);
	}
	
	@Test
	void testIsValidBST() {
		BinaryTree bt = new BinaryTree(preOrder, inOrder);
		assertTrue(bt.isValidBST());
		BinaryTree bt2 = new BinaryTree(preOrder2, inOrder2);
		assertFalse(bt2.isValidBST());
		BinaryTree bt3 = new BinaryTree(preOrder3, inOrder3);
		assertTrue(bt3.isValidBST());
		BinaryTree bt4 = new BinaryTree(preOrder4, inOrder4);
		assertTrue(bt4.isValidBST());
		BinaryTree bt5 = new BinaryTree(preOrder5, inOrder5);
		assertFalse(bt5.isValidBST());
		BinaryTree btNull = new BinaryTree();
		assertTrue(btNull.isValidBST());
	}
	
	private void printBSTSequences(ArrayList<LinkedList<Integer>> sequences) {
		for (LinkedList<Integer> list : sequences) {
			StringBuilder resultBuilder = new StringBuilder();
			for (Integer i : list) {
				resultBuilder.append(String.format("%d ", i));
			}
			System.out.println(resultBuilder.toString().strip());
		}
	}
	
	@Test
	void testBSTSequence() {
		BinaryTree bt = new BinaryTree(preOrder, inOrder);
		assertTrue(bt.isValidBST());
		ArrayList<LinkedList<Integer>> result = bt.bstSequence();
		printBSTSequences(result);
		
		BinaryTree bt6 = new BinaryTree(preOrder6, inOrder6);
		assertTrue(bt.isValidBST());
		ArrayList<LinkedList<Integer>> result6 = bt6.bstSequence();
		printBSTSequences(result6);
	}
	
	@Test
	void testNumPathsWithSum() {
		BinaryTree b7 = new BinaryTree(preOrder7, inOrder7);
		assertEquals(0, b7.numPathsWithSum(0));
		assertEquals(1, b7.numPathsWithSum(1));
		assertEquals(2, b7.numPathsWithSum(2));
		assertEquals(2, b7.numPathsWithSum(3));
		assertEquals(0, b7.numPathsWithSum(4));
		
		BinaryTree b8 = new BinaryTree(preOrder8, inOrder8);
		assertEquals(0, b8.numPathsWithSum(-6));
		assertEquals(1, b8.numPathsWithSum(-5));
		assertEquals(1, b8.numPathsWithSum(-4));
		assertEquals(1, b8.numPathsWithSum(-3));
		assertEquals(1, b8.numPathsWithSum(-2));
		assertEquals(2, b8.numPathsWithSum(-1));
		assertEquals(4, b8.numPathsWithSum(0));
		assertEquals(3, b8.numPathsWithSum(1));
		assertEquals(1, b8.numPathsWithSum(2));
		assertEquals(1, b8.numPathsWithSum(3));
		assertEquals(1, b8.numPathsWithSum(4));
		assertEquals(1, b8.numPathsWithSum(5));
		assertEquals(0, b8.numPathsWithSum(6));
		
		BinaryTree b9 = new BinaryTree(preOrder9, inOrder9);
		assertEquals(0, b9.numPathsWithSum(-2));
		assertEquals(1, b9.numPathsWithSum(-1));
		assertEquals(3, b9.numPathsWithSum(0));
		assertEquals(2, b9.numPathsWithSum(1));
		assertEquals(0, b9.numPathsWithSum(2));
	}

}
