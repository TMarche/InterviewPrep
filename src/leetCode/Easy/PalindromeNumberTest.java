package leetCode.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromeNumberTest {
	
	PalindromeNumber pn;

	@BeforeEach
	void setUp() throws Exception {
		pn = new PalindromeNumber();
	}

	@Test
	void testIsPalindrome() {
		assertTrue(pn.isPalindrome(0));
		assertTrue(pn.isPalindrome(1));
		assertTrue(pn.isPalindrome(11));
		assertTrue(pn.isPalindrome(121));
		assertTrue(pn.isPalindrome(1221));
		assertFalse(pn.isPalindrome(-1));
		assertFalse(pn.isPalindrome(-11));
		assertFalse(pn.isPalindrome(-121));
		assertFalse(pn.isPalindrome(-1221));
		assertFalse(pn.isPalindrome(123));
		assertFalse(pn.isPalindrome(111112));		
		assertFalse(pn.isPalindrome(211111));
		assertFalse(pn.isPalindrome(112111));
		assertFalse(pn.isPalindrome(111211));
	}

}
