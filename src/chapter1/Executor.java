package chapter1;
import java.util.Collections;
import java.util.HashSet;

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
	
	public boolean isUnique2(String str) { return false; }
	
	// Problem 1.5
}
