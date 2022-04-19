package leetCode.Easy;

/**
 * Must remove duplicates *in place* -- no extra memory
 * Input list is always sorted in ascending order
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
    	if (nums.length <= 1) return nums.length;
    	int uniqueCount = 1; // Serves as overwrite index and return value
    	for (int i = 1; i < nums.length; i++)
    		if (nums[i] > nums[uniqueCount - 1])
    			nums[uniqueCount++] = nums[i];
    	return uniqueCount;
    }
    
    public int removeDuplicates2(int[] nums) {
	    int i = nums.length > 0 ? 1 : 0;
	    for (int n : nums)
	        if (n > nums[i-1])
	            nums[i++] = n;
	    return i;
    }
}
