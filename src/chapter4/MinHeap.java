package chapter4;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
	private List<T> nodes = new ArrayList<T>();
	
	
	public void add(T data) {
		// Insert in next-available spot
		int currentIndex = nodes.size();
		nodes.add(data);
		// Swap with parent while less than parent or until no more parent
		while (currentIndex != 0) {
			int parentIndex = getParentIndex(currentIndex);
			T parent = nodes.get(parentIndex);
			int compareValue = data.compareTo(parent);
			// If data is less than parent, swap
			// Otherwise, keep same positions
			if (compareValue == -1) {
				nodes.set(currentIndex, parent);
				nodes.set(parentIndex, data);
				currentIndex = parentIndex;
			} else {
				return;
			}
		}
	}
	
	public T extractMin() {
		T retValue = getMin();
		if (nodes.size() == 1) {
			nodes.remove(0);
			return retValue;
		}
		// Swap min node with last item in heap
		nodes.set(0, nodes.get(nodes.size() - 1));
		nodes.remove(nodes.size() - 1);
		// Swap node down
		int parentIndex = 0;
		while (true) {
			T parent = nodes.get(parentIndex);
			
			// Need to check if child indices exist in heap
			int leftChildIndex = getLeftChildIndex(parentIndex);
			if (leftChildIndex > nodes.size() - 1) return retValue;
			T left = nodes.get(leftChildIndex);
			int leftComparison = parent.compareTo(left);
			
			int rightChildIndex = getRightChildIndex(parentIndex);
			if (rightChildIndex > nodes.size() - 1) {
				if (leftComparison == 1) {
					// Swap values
					nodes.set(parentIndex, left);
					nodes.set(leftChildIndex, parent);
				}
				return retValue;
			}
			
			// Case where both left and right exist
			// Compare to right
			T right = nodes.get(rightChildIndex);
			int rightComparison = parent.compareTo(right);
			// Compare left to right
			int leftRightComparison = left.compareTo(right);

			// Swap with left if left smaller than right
			if (leftComparison == 1 && leftRightComparison <= 0) {
				nodes.set(parentIndex, left);
				nodes.set(leftChildIndex, parent);
				parentIndex = leftChildIndex;
			} 
			// Swap with right if right smaller than left
			else if (rightComparison == 1 && leftRightComparison >= 0) {
				nodes.set(parentIndex, right);
				nodes.set(rightChildIndex, parent);
				parentIndex = rightChildIndex;
			} else {
				return retValue;
			}
		}
	}
		
	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}
	
	public T getMin() {
		return nodes.get(0);
	}
}
