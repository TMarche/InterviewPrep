package chapter3;

public class Executor {
	
	// Unfortunate side-effect of emptying the original stack :'(
	public static Stack<Integer> sortStack(Stack<Integer> s1) {
		if (s1 == null) return null;
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> sorted = new Stack<Integer>();
		while (!s1.isEmpty()) {
			// First loop identifies max
			Integer max = null;
			while(!s1.isEmpty()) {
				Integer current = s1.peek();
				if (max == null || current > max) max = current;
				s2.push(s1.pop());
			}
			// Second loop transfers max to sorted list
			while(!s2.isEmpty()) {
				// Transfer all equivalent to max -- including duplicates
				Integer current = s2.peek();
				if (current == max) {
					sorted.push(current);
					s2.pop();
				} else {
					s1.push(s2.pop());
				}
			}
		}
		return sorted;
	}
}
