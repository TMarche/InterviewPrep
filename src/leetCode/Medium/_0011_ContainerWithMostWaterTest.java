package leetCode.Medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class _0011_ContainerWithMostWaterTest {
	
	_0011_ContainerWithMostWater cwmw;

	@BeforeEach
	void setUp() throws Exception {
		cwmw = new _0011_ContainerWithMostWater();
	}

	@Test
	void testMaxArea() {
		assertEquals(49, cwmw.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
		assertEquals(0, cwmw.maxArea(new int[] {}));
		assertEquals(0, cwmw.maxArea(new int[] {5}));
		assertEquals(5, cwmw.maxArea(new int[] {5, 5}));
		assertEquals(5, cwmw.maxArea(new int[] {1, 0, 2, 0, 2, 1}));
	}
	
	@Test
	void testMaxArea2() {
		assertEquals(49, cwmw.maxArea2(new int[] {1,8,6,2,5,4,8,3,7}));
		assertEquals(0, cwmw.maxArea2(new int[] {}));
		assertEquals(0, cwmw.maxArea2(new int[] {5}));
		assertEquals(5, cwmw.maxArea2(new int[] {5, 5}));
		assertEquals(5, cwmw.maxArea2(new int[] {1, 0, 2, 0, 2, 1}));
	}
}
