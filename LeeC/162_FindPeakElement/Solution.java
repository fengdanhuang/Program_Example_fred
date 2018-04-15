



class Solution {
    
    public int findPeakElement(int[] nums) {
        
        return search(nums, 0, nums.length - 1);
    }
    
    public int search(int[] nums, int l, int r) {
        System.out.println("search(nums," + l + "," + r +");");
	 
        if (l == r) return l;
        
	int mid = (l + r) / 2;
	System.out.println("mid = " + mid);
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        
        return search(nums, mid + 1, r);
    }
   
    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] nums = new int[]{1, 2, 3, 1};	
	s1.findPeakElement(nums);
	System.out.println();
	
	nums = new int[]{1, 4, 7, 2, 9, 4, 2, 1};	
	s1.findPeakElement(nums);
    } 
    
}
