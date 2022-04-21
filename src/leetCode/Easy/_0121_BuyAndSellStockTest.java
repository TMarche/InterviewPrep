package leetCode.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class _0121_BuyAndSellStockTest {
	
	private _0121_BuyAndSellStock bass;

	@BeforeEach
	void setUp() throws Exception {
		bass = new _0121_BuyAndSellStock();
	}

	@Test
	void testMaxProfit() {
		assertEquals(5, bass.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
		assertEquals(0, bass.maxProfit(new int[] {7, 6, 4, 3, 1}));
		assertEquals(0, bass.maxProfit(new int[] {}));
	}
	
	@Test
	void testMaxProfit2() {
		assertEquals(5, bass.maxProfit2(new int[] {7, 1, 5, 3, 6, 4}));
		assertEquals(0, bass.maxProfit2(new int[] {7, 6, 4, 3, 1}));
		assertEquals(0, bass.maxProfit2(new int[] {}));
	}
	
	@Test
	void testMaxProfit3() {
		assertEquals(5, bass.maxProfit3(new int[] {7, 1, 5, 3, 6, 4}));
		assertEquals(0, bass.maxProfit3(new int[] {7, 6, 4, 3, 1}));
		assertEquals(0, bass.maxProfit3(new int[] {}));
	}
}
