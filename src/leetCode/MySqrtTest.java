package leetCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MySqrtTest {
	
	MySqrt ms;

	@BeforeEach
	void setUp() throws Exception {
		ms = new MySqrt();
	}

	@Test
	void test() {
		assertEquals(0, ms.mySqrt(0));
		assertEquals(1, ms.mySqrt(1));
		assertEquals(1, ms.mySqrt(2));
		assertEquals(1, ms.mySqrt(3));
		assertEquals(2, ms.mySqrt(4));
		assertEquals(2, ms.mySqrt(5));
		assertEquals(4, ms.mySqrt(16));
		assertEquals(4, ms.mySqrt(24));
		assertEquals(5, ms.mySqrt(25));
		assertEquals(5, ms.mySqrt(26));
		assertEquals(3162, ms.mySqrt(9999999));
		assertEquals(46340, ms.mySqrt(2147395600));
	}
	
	@Test
	void test2() {
		assertEquals(0, ms.mySqrt2(0));
		assertEquals(1, ms.mySqrt2(1));
		assertEquals(1, ms.mySqrt2(2));
		assertEquals(1, ms.mySqrt2(3));
		assertEquals(2, ms.mySqrt2(4));
		assertEquals(2, ms.mySqrt2(5));
		assertEquals(4, ms.mySqrt2(16));
		assertEquals(4, ms.mySqrt2(24));
		assertEquals(5, ms.mySqrt2(25));
		assertEquals(5, ms.mySqrt2(26));
		assertEquals(3162, ms.mySqrt2(9999999));
		assertEquals(46340, ms.mySqrt2(2147395600));
		assertEquals(46340, ms.mySqrt2(2147483647));
	}

}
