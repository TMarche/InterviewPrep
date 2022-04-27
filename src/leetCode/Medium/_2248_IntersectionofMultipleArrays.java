package leetCode.Medium;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class _2248_IntersectionofMultipleArrays {
	public List<Integer> intersection(int[][] nums) {
		// Integer array to store count of each number
		int[] counts = new int[1000];
		
		// Pass through each array once, increment counter
		for (int r = 0; r < nums.length; r++) { // Iterate over rows
			for (int c = 0; c < nums[r].length; c++) {
				counts[nums[r][c] - 1]++; // -1 accounts for offset in array
			}
		}
		
		// If counter is equal to number of rows, then it is 
		// part of the solution
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < counts.length; i++) {
			// Add to solution if counter value equals number of rows (nums.length)
			if (counts[i] == nums.length) {
				result.add(i + 1);
			}
		}
		
		return result;
	}
	
	// Java Questions:
	//   How do you write a for-each loop?
}
