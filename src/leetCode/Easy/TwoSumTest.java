package leetCode.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoSumTest {
	
	private TwoSum ts;

	@BeforeEach
	void setUp() throws Exception {
		ts = new TwoSum();
	}

	@Test
	void test() {
		int[] result;
		result = ts.twoSum(new int[]{2,7,11,15}, 9);
		assertEquals(1, result[0]);
		assertEquals(0, result[1]);
		result = ts.twoSum(new int[]{3,2,4}, 6);
		assertEquals(2, result[0]);
		assertEquals(1, result[1]);
		result = ts.twoSum(new int[]{3,3}, 6);
		assertEquals(1, result[0]);
		assertEquals(0, result[1]);
	}
}
