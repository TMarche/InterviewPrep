package leetCode.Easy;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Each number only has one possible paring to equal the target
        // Ex. If target is 7 and the current number is 2, the other value MUST be 9
        // Store the index of each number with the number in a HashMap??
        HashMap<Integer, Integer> encountered = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (encountered.containsKey(target - current)) {
            	return new int[]{i, encountered.get(target - current)};            	
            }
            encountered.put(current, i);
        }
        return null;
    }
}
