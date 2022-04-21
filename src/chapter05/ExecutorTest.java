package chapter05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExecutorTest {
	
	Executor e;
	
	@BeforeEach
	void setUp() {
		e = new Executor();
	}

	@Test
	void testInsertion() {
		assertEquals(0b11001100, e.insertion(0b10000000, 0b10011, 2, 6));
	}

	@Test
	void testClearBits() {
		assertEquals(0b11111110, e.clearBits(0b11111111, 0, 0));
		assertEquals(0b11111101, e.clearBits(0b11111111, 1, 1));
		assertEquals(0b11111011, e.clearBits(0b11111111, 2, 2));
		assertEquals(0b11110111, e.clearBits(0b11111111, 3, 3));
		assertEquals(0b11101111, e.clearBits(0b11111111, 4, 4));
		assertEquals(0b11011111, e.clearBits(0b11111111, 5, 5));
		assertEquals(0b10111111, e.clearBits(0b11111111, 6, 6));
		assertEquals(0b01111111, e.clearBits(0b11111111, 7, 7));
		assertEquals(0b11110000, e.clearBits(0b11111111, 0, 3));
		assertEquals(0b11100001, e.clearBits(0b11111111, 1, 4));
		assertEquals(0b11000011, e.clearBits(0b11111111, 2, 5));
		assertEquals(0b10000111, e.clearBits(0b11111111, 3, 6));
		assertEquals(0b00001111, e.clearBits(0b11111111, 4, 7));
	}

	@Test
	void testUpdateBits() {
		assertEquals(0b11111111, e.updateBits(0b00000000, 0b11111111, 0, 7));
		assertEquals(0b00111100, e.updateBits(0b00000000, 0b11111111, 2, 5));
		assertEquals(0b10101010, e.updateBits(0b00001010, 0b10100011, 2, 7));
	}

	@Test
	void testClearBit() {
		assertEquals(0b11111110, e.clearBit(0b11111111, 0));
		assertEquals(0b11111101, e.clearBit(0b11111111, 1));
		assertEquals(0b11111011, e.clearBit(0b11111111, 2));
		assertEquals(0b11110111, e.clearBit(0b11111111, 3));
		assertEquals(0b11101111, e.clearBit(0b11111111, 4));
		assertEquals(0b11011111, e.clearBit(0b11111111, 5));
		assertEquals(0b10111111, e.clearBit(0b11111111, 6));
		assertEquals(0b01111111, e.clearBit(0b11111111, 7));
	}

	@Test
	void testGetBit() {
		assertTrue(e.getBit(0b00000001, 0));
		assertTrue(e.getBit(0b00000010, 1));
		assertTrue(e.getBit(0b00000100, 2));
		assertTrue(e.getBit(0b00001000, 3));
		assertTrue(e.getBit(0b00010000, 4));
		assertTrue(e.getBit(0b00100000, 5));
		assertTrue(e.getBit(0b01000000, 6));
		assertTrue(e.getBit(0b10000000, 7));
		assertFalse(e.getBit(0b00000001, 1));
		assertFalse(e.getBit(0b00000010, 2));
		assertFalse(e.getBit(0b00000100, 3));
		assertFalse(e.getBit(0b00001000, 4));
		assertFalse(e.getBit(0b00010000, 5));
		assertFalse(e.getBit(0b00100000, 6));
		assertFalse(e.getBit(0b01000000, 7));
		assertFalse(e.getBit(0b10000000, 8));
	}

	@Test
	void testSetBit() {
		assertEquals(0b00000001, e.setBit(0b00000000, 0, true));
		assertEquals(0b00000010, e.setBit(0b00000000, 1, true));
		assertEquals(0b00000100, e.setBit(0b00000000, 2, true));
		assertEquals(0b00001000, e.setBit(0b00000000, 3, true));
		assertEquals(0b00010000, e.setBit(0b00000000, 4, true));
		assertEquals(0b00100000, e.setBit(0b00000000, 5, true));
		assertEquals(0b01000000, e.setBit(0b00000000, 6, true));
		assertEquals(0b10000000, e.setBit(0b00000000, 7, true));
		assertEquals(0b11111110, e.setBit(0b11111111, 0, false));
		assertEquals(0b11111101, e.setBit(0b11111111, 1, false));
		assertEquals(0b11111011, e.setBit(0b11111111, 2, false));
		assertEquals(0b11110111, e.setBit(0b11111111, 3, false));
		assertEquals(0b11101111, e.setBit(0b11111111, 4, false));
		assertEquals(0b11011111, e.setBit(0b11111111, 5, false));
		assertEquals(0b10111111, e.setBit(0b11111111, 6, false));
		assertEquals(0b01111111, e.setBit(0b11111111, 7, false));
	}

}
