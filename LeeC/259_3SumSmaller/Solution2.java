

import java.util.Arrays;

public class Solution2 {
        
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
    
        for(int i=0; i<nums.length-2; i++) {
            int left = i+1, right = nums.length-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    res += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }
       
	System.out.println("res = " + res); 
        return res;
    }

    public static void main(String args[]){

	Solution2 s1 = new Solution2();
	
	int[] nums = new int[]{-2, 0, 1, 3};
	int target = 2;
	s1.threeSumSmaller(nums, target);
	
    }
    
}
