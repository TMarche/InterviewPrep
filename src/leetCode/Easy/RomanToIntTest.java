package leetCode.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RomanToIntTest {
	
	RomanToInt rti;

	@BeforeEach
	void setUp() throws Exception {
		rti = new RomanToInt();
	}

	@Test
	void test() {
		assertEquals(0, rti.romanToInt(""));
		assertEquals(1, rti.romanToInt("I"));
		assertEquals(5, rti.romanToInt("V"));
		assertEquals(10, rti.romanToInt("X"));
		assertEquals(50, rti.romanToInt("L"));
		assertEquals(100, rti.romanToInt("C"));
		assertEquals(500, rti.romanToInt("D"));
		assertEquals(1000, rti.romanToInt("M"));
		assertEquals(2, rti.romanToInt("II"));
		assertEquals(3, rti.romanToInt("III"));
		assertEquals(4, rti.romanToInt("IV"));
		assertEquals(27, rti.romanToInt("XXVII"));
		assertEquals(24, rti.romanToInt("XXIV"));
		assertEquals(164, rti.romanToInt("CLXIV"));
	}

}
