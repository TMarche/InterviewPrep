package leetCode.Easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class _0020_ValidParentheses {
	public boolean isValid(String s) {
		HashMap<Character, Character> matchingCharacters = new HashMap<Character, Character>();
		matchingCharacters.put('(', ')');
		matchingCharacters.put('[', ']');
		matchingCharacters.put('{', '}');
		
		matchingCharacters.size();
		// Push opening brackets onto stack
		// Pop from stack when encountering appropriate closing brackets
		LinkedList<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			// Handle opening brackets
			if (matchingCharacters.get(s.charAt(i)) != null) {
				stack.push(s.charAt(i));
			}
			// Handle closing brackets
			else {
				if (stack.isEmpty() ||
					s.charAt(i) != matchingCharacters.get(stack.peek()) // We have the wrong closing bracket
				) {
					return false;
				}
				stack.pop();
			}
		}
		// Ensure stack is empty -- i.e. all brackets have been closed
		return stack.size() == 0;
	}
	
	// Better solution?
	public boolean isValid2(String s) {
		if (s.length() % 2 != 0) return false;
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	// Questions to add to "Java" section:
	//    Does Java have a built-in Stack class? If not, what can you use as an alternative?
	//        No -- However, you can use the LinkedList class as a stack
	//    Does the ABC List class support Stack/Queue methods?
	//        NO it does not
	//    How do you import the LinkedList class?
	//    How do you import the List class?
	//    How do you import the HashMap class?
	//    How do you get the length of a String? String.length()
	//    How do you get the length of an array? array.length
	//    How do you get the length of a List? List.size()
	//    How do you get the character at a specific index of a string?
	//    How do you specify a Character literal?
	//    How do you compare characters for equality?
	//    How do you compare Strings for equality?
}
