package leetCode.Easy;

public class _0746_MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] costs) {
		// Brute force
		// Time: O(2^n)
		// Space: O(n) -- NOTE: The call stack only contains
		//   calls of a single branch down to the bottom of the
		//   binary tree. While there are 2^n total calls being,
		//   the call stack will only ever be as large as N in size,
		//   which is the path that walks the maximum height of the
		//   tree when we take every single step available to the top
		int n = costs.length;
		return Math.min(minCost(n - 1, costs), minCost(n - 2, costs));
	}
	
	public int minCost(int n, int[] costs) {
		if (n < 0) return 0;
		if (n <= 1) return costs[n];
		
		return costs[n] + Math.min(minCost(n - 1, costs), minCost(n - 2, costs));
	}
	
	public int minCostClimbingStairs2(int[] costs) {
		// Memoized/optimized top-down solution
		// Time:  O(n)
		// Space: O(n)
		int n = costs.length;
		int[] memo = new int[n];
		for (int i = 0; i < memo.length; i++) memo[i] = -1; // init array
		// Make initial call to recursive funciton
		return Math.min(minCost2(n - 1, costs, memo), minCost2(n - 2, costs, memo));
	}
	
	public int minCost2(int n, int[] costs, int[] memo) {
		if (n < 0) return 0;
		if (n <= 1) return costs[n];
		if (memo[n] != -1) return memo[n];
		
		memo[n] = costs[n] + Math.min(minCost2(n - 1, costs, memo), minCost2(n - 2, costs, memo));
		return memo[n];
	}
	
	public int minCostClimbingStairs3(int[] costs) {
		// Memoized/optimized bottom-up solution (tabulation)
		// Time:  O(n)
		// Space: O(n)
		int n = costs.length;
		int[] memo = new int[n];
		for (int i = 0; i < n; i++) {
			if (i < 2) {
				memo[i] = costs[i];
			} else {
				// NOTE: We're only leveraging the last two values in our memo array
				//   Could we optimize our space complexity here?
				memo[i] = costs[i] + Math.min(memo[i - 1], memo[i - 2]);
			}
		}
		return Math.min(memo[n - 1], memo[n -2]);
	}
	
	public int minCostClimbingStairs4(int[] costs) {
		// Memoized/optimized bottom-up solution
		// Time:  O(n)
		// Space: O(1)
		int n = costs.length;
		if (n == 0) return 0;
		if (n == 1) return costs[0];
	
		// Take info from base cases and use it to solve more-complex cases
		int a = costs[0];
		int b = costs[1];
		
		int current = Integer.MAX_VALUE;
		for (int i = 2; i < n; i++) {
			current = costs[i] + Math.min(a, b);
			a = b;
			b = current;
		}
		return Math.min(a, b);
	}
}
