
import java.util.*;


class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + "  ");
        System.out.println();

        System.out.println("k = " + k);


        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + "  ");
        System.out.println();
        
        int re = nums[nums.length-k];
        System.out.println("nums.length - k = " + (nums.length-k));
        System.out.println("re = " + re + "\n");
        return re;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        s.findKthLargest(nums, k);

        nums = new int[]{3,2,3,1,2,4,5,5,6};
        k = 4;
        s.findKthLargest(nums, k); 

    }

}
