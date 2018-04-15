


public class Solution {
    
    public void nextPermutation(int[] nums) {
	for (int a=0; a<nums.length; a++){
		System.out.print(nums[a] + "  ");
	}
	System.out.println();
        
	int i = nums.length - 2;
        
	while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            
	    while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            
            //swap(nums, i, j);
	    int temp = nums[i]; nums[i]=nums[j]; nums[j]=temp;
        }
        
        reverse(nums, i + 1);

	for (int a=0; a<nums.length; a++){
		System.out.print(nums[a] + "  ");
	}
	System.out.println();
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]){
	
	Solution s1 = new Solution();
	
	int[] nums = {1,2,3};
	s1.nextPermutation(nums);
	int[] nums2 = {1,5,7,19,4,2,4,5,7,10};
	s1.nextPermutation(nums2);
    }
    
}
