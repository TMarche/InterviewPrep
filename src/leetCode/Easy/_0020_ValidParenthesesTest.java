package leetCode.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class _0020_ValidParenthesesTest {
	
	_0020_ValidParentheses vp;

	@BeforeEach
	void setUp() throws Exception {
		vp = new _0020_ValidParentheses();
	}

	@Test
	void testIsValid() {
		assertTrue(vp.isValid(""));
		assertTrue(vp.isValid("()[]{}"));
		assertTrue(vp.isValid("({[](()())}[])"));
		assertFalse(vp.isValid("("));
		assertFalse(vp.isValid(")("));
		assertFalse(vp.isValid("([)]{}"));
		assertFalse(vp.isValid("({[](()()){}[])"));
	}
	
	@Test
	void testIsValid2() {
		assertTrue(vp.isValid2(""));
		assertTrue(vp.isValid2("()[]{}"));
		assertTrue(vp.isValid2("({[](()())}[])"));
		assertFalse(vp.isValid2("("));
		assertFalse(vp.isValid2(")("));
		assertFalse(vp.isValid2("([)]{}"));
		assertFalse(vp.isValid2("({[](()()){}[])"));
	}
}
