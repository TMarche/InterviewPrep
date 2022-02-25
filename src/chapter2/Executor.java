package chapter2;

public class Executor {
	
	public static LinkedList<Integer> sumLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer>.Node l1Current = l1.getHead();
		LinkedList<Integer>.Node l2Current = l2.getHead();
		boolean shouldIteratel1 = true;
		boolean shouldIteratel2 = true;
		int carry = 0;
		LinkedList<Integer> result = new LinkedList<Integer>();
		while(true) {
			if (l1Current == null) shouldIteratel1 = false;
			if (l2Current == null) shouldIteratel2 = false;
			if (!shouldIteratel1 && !shouldIteratel2 && carry == 0) break;
			int sum = (l1Current != null ? l1Current.getData() : 0)
					+ (l2Current != null ? l2Current.getData() : 0)
					+ carry;
			int add = sum % 10;
			carry = sum / 10;
			// Add new node to list
			result.add(add);
			// Advance pointers
			if (shouldIteratel1) l1Current = l1Current.getNext();
			if (shouldIteratel2) l2Current = l2Current.getNext();
		}
		return result;
	}
}