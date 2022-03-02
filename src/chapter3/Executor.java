package chapter3;

public class Executor {
	
	public static void sortStack(Stack<Integer> toSort) {
		if (toSort == null) return;
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while (!toSort.isEmpty()) {
			s1.push(toSort.pop());
		}
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
					toSort.push(current);
					s2.pop();
				} else {
					s1.push(s2.pop());
				}
			}
		}
	}
	
	public static void sortStack2(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		// Take from s1 and move to s2 in reverse sorted order
		while(!s1.isEmpty()) {
			Integer tmp = s1.pop();
			while(!s2.isEmpty() && s2.peek() > tmp) {
				s1.push(s2.pop());
			}
			s2.push(tmp);
		}
		
		// Take from s2 and move back into s1
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
}
