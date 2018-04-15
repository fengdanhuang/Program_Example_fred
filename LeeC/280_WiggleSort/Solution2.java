

class Solution2 {
    
    public void wiggleSort(int[] nums) {
	for (int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();    

    
        for(int i=1; i< nums.length; i++){
	    System.out.println("i = " + i);
            if ((i%2==1 && nums[i]<nums[i-1]) || (i%2==0 && nums[i]>nums[i-1])){
                System.out.println(nums[i-1] + ", " + nums[i]);
		int tem = nums[i];nums[i]=nums[i-1];nums[i-1]=tem;
                System.out.println(nums[i-1] + ", " + nums[i]);
            }
        }

	for (int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();    	
        
    }

    public static void main(String args[]){
        Solution2 s1 = new Solution2();

        int[] nums = new int[]{3, 5, 2, 1, 6, 4}; 
        s1.wiggleSort(nums);

    }
}
