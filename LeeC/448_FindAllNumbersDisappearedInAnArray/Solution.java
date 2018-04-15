
import java.util.*;


class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();
	 
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
	    System.out.println("    val = " + val);

	    
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
	    System.out.println("    nums[" + val + "]=" + nums[val]);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
	    System.out.println("nums[" + i + "]=" + nums[i] + ", 0, " + " ret = " + ret);
        }

	System.out.println("ret = " + ret);
        return ret;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] nums = new int[]{4,3,2,7,8,2,3,1};
	s1.findDisappearedNumbers(nums);
	


    }
}
