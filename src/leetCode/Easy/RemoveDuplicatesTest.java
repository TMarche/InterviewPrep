package leetCode.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {
	
	RemoveDuplicates rd;

	@BeforeEach
	void setUp() throws Exception {
		rd = new RemoveDuplicates();
	}

	@Test
	void testRemoveDuplicates() {
		assertEquals(0, rd.removeDuplicates(new int[]{}));
		assertEquals(1, rd.removeDuplicates(new int[]{0}));
		assertEquals(1, rd.removeDuplicates(new int[]{0, 0}));
		assertEquals(2, rd.removeDuplicates(new int[]{0, 1}));
		assertEquals(2, rd.removeDuplicates(new int[]{0, 0, 0, 1, 1}));
		assertEquals(5, rd.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
	}
	
	@Test
	void testRemoveDuplicates2() {
		assertEquals(0, rd.removeDuplicates2(new int[]{}));
		assertEquals(1, rd.removeDuplicates2(new int[]{0}));
		assertEquals(1, rd.removeDuplicates2(new int[]{0, 0}));
		assertEquals(2, rd.removeDuplicates2(new int[]{0, 1}));
		assertEquals(2, rd.removeDuplicates2(new int[]{0, 0, 0, 1, 1}));
		assertEquals(5, rd.removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
		
		assertEquals(5, rd.removeDuplicates2(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4}));
	}
}
