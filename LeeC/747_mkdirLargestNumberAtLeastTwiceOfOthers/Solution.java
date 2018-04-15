

class Solution {
    
    public int dominantIndex(int[] nums) {
	for(int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();       
 
        int maxIndex = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i]){
		System.out.println("    return " + (-1) + ";\n");
                return -1;
	    }
        }

	System.out.println("return maxIndex = " + maxIndex + "\n");
        return maxIndex;
        
    }
    

    public static void main(String args[]){
	Solution s1 = new Solution();


	int[] nums = new int[]{3, 6, 1, 0};
	s1.dominantIndex(nums);

	nums = new int[]{1, 2, 3, 4};
	s1.dominantIndex(nums);
    }
    
}
