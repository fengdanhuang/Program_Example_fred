


class Solution {
    
    public void moveZeroes(int[] nums) {
	for (int i=0; i<nums.length; i++)
		System.out.print(nums[i] + "  ");
	System.out.println();


    	if (nums == null || nums.length == 0) return;        

    	int insertPos = 0;
    	for (int num: nums) {
        	if (num != 0) nums[insertPos++] = num;
    	}        

    	while (insertPos < nums.length) {
        	nums[insertPos++] = 0;
    	}

	
	for (int i=0; i<nums.length; i++)
		System.out.print(nums[i] + "  ");
	System.out.println();
    }


    public void moveZeroes_best(int[] nums) {

        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + "  ");
        System.out.println();
        
        int low = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[low++] = nums[i];
            }
        }
        
        while (low < nums.length) {
            nums[low++] = 0;
        }

        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + "  ");
        System.out.println("\n");
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int [] nums = new int [] {0, 1, 0, 3, 12};
	//s1.moveZeroes(nums);
        s1.moveZeroes_best(nums);

        nums = new int[]{1};
        s1.moveZeroes_best(nums);
 	
        nums = new int[]{1,2};
        s1.moveZeroes_best(nums);
        
        nums = new int[]{1,0};
        s1.moveZeroes_best(nums);


    }    
}
