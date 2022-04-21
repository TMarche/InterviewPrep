package chapter01;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Executor {

	// Problem 1.1
	public boolean isUnique(String str) {
		HashSet<Character> encountered = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (encountered.contains(str.charAt(i))) { return false; }
			encountered.add(str.charAt(i));
		}
		return true;
	}
	
	public boolean isUnique2(String str) {
		// Iterate over each character and check that only
		// one instance of it exists in the string
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) { // We only have to check the remaining characters
				if (str.charAt(i) == str.charAt(j)) { return false; }
			}
		}
		return true;
	}
	
	// Problem 1.5
	public boolean oneAway(String a, String b) {
		List<String> patterns = generatePatterns(a);
		for (String pattern: patterns) {
			if (b.matches(pattern)) { return true; }
		}
		return false;
	}
	
	public List<String> generatePatterns(String str) {
		List<String> patterns = new ArrayList<String>();
		// Generate all 'replace/remove' patterns
		for (int i = 0; i < str.length(); i++) {
			patterns.add(str.substring(0, i) + ".?" + str.substring(i+1));
		}
		// Generate all 'insert' patterns
		for (int i = 0; i < str.length() + 1; i++) {
			patterns.add(str.substring(0, i) + "." + str.substring(i));
		}
		return patterns;
	}
	
	public boolean oneAway2(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return isOneReplace(s1, s2);
		} else if (s1.length() +1 == s2.length()) {
			return isOneInsert(s1, s2);
		} else if (s2.length() + 1 == s1.length()) {
			return isOneInsert(s2, s1);
		}
		return false;
	}
	
	private boolean isOneReplace(String s1, String s2) {
		if (s1.length() != s2.length()) { return false; }

		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				// Have we already found a difference?
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	
	private boolean isOneInsert(String s1, String s2) {
		if (s1.length() +1 != s2.length()) { return false; }
		
		int firstIndex = 0;
		int secondIndex = 0;
		boolean foundDifference = false;
		while (firstIndex < s1.length()) {
			if (s1.charAt(firstIndex) != s2.charAt(secondIndex)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
				secondIndex++;
				continue;
			}
			firstIndex++;
			secondIndex++;
		}
		return true;
	}
	
	// Problem 1.9
	public boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		return (s2 + s2).contains(s1);
	}
}
