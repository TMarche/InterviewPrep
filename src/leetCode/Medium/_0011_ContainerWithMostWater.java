package leetCode.Medium;

public class _0011_ContainerWithMostWater {
	public int maxArea(int[] heights) {
		// Brute force
		// time: O(n^2)
		// space: O(1)
		// Find max of all possible rectangles constructed
		// from the lines
		
		// For each rect:
		//   length = min(a,b) 
		//   width  = b_i - a_i
		int maxArea = 0;
		
		for (int i = 0; i < heights.length - 1; i++) {
			for (int j = i+1; j < heights.length; j++) {
				int length = Math.min(heights[i], heights[j]);
				int width = j - i;
				if (length * width > maxArea) {
					maxArea = length * width;
				}
			}
		}
		return maxArea;
	}
	
	public int maxArea2(int[] heights) {
		// New technique: "two shifting pointers"
		// What happens if larger number gets larger? No impact -- We don't care about it
		// What happens if larger number gets smaller? Area shrinks
		// Where do we start with our pointers? Why? We start on the ends. This starts us at the largest width possible
		//   and ensures that there's no possible way where the values on the outskirts (i.e. the opposing sides of our variables)
		//   could possibly give us a larger container
		// What are the main considerations when using "two shifting pointers"?
		//   - How we move the two pointers
		//   - When the pointers are considered done moving
		//   - How we determine which one of them to move in the first place
		// Time: O(n)
		// Space: O(1)
		
		// Start pointers at ends of array
		if (heights.length <= 1) return 0;
		int p1 = 0;
		int p2 = heights.length - 1;
		int maxArea = 0;
		
		while (p1 != p2) {
			// Evaluate area
			int height = Math.min(heights[p1], heights[p2]);
			int width = p2 - p1;
			int area = height * width;
			// Adjust max area if necessary
			maxArea = Math.max(area, maxArea);
			// Shift pointers -- move pointer with smaller value
			if (heights[p1] < heights[p2]) {
				p1++;
			} else {
				p2--;
			}
		}
		
		return maxArea;
	}
}





















