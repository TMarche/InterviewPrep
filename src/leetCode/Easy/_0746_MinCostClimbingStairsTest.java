package leetCode.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class _0746_MinCostClimbingStairsTest {

	_0746_MinCostClimbingStairs mccs;
	
	@BeforeEach
	void setUp() throws Exception {
		mccs = new _0746_MinCostClimbingStairs();
	}

	@Test
	void testMinCostClimbingStairs() {
		assertEquals(15, mccs.minCostClimbingStairs(new int[] {10,15,20}));
		assertEquals(6, mccs.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

	@Test
	void testMinCostClimbingStairs2() {
		assertEquals(15, mccs.minCostClimbingStairs2(new int[] {10,15,20}));
		assertEquals(6, mccs.minCostClimbingStairs2(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

	@Test
	void testMinCostClimbingStairs3() {
		assertEquals(15, mccs.minCostClimbingStairs3(new int[] {10,15,20}));
		assertEquals(6, mccs.minCostClimbingStairs3(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

	@Test
	void testMinCostClimbingStairs4() {
		assertEquals(15, mccs.minCostClimbingStairs4(new int[] {10,15,20}));
		assertEquals(6, mccs.minCostClimbingStairs4(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

}
