

import java.util.*;

public class Solution {

	public List<String> findMissingRanges(int[] nums, int lower, int upper){
    		
		List<String> res = new ArrayList<String>();
    		long low = (long)lower;
    		long high = (long)lower;
    
    		for(int i=0;i<=nums.length;i++){        //i<=nums.length can add last missing range
        		low = i==0?low:(long)nums[i-1]+1;
        		high = i==nums.length?(long)upper:(long)nums[i]-1;
        
        		if(low==high) res.add(low+"");
        		if(low<high) res.add(low+"->"+high); 
    		}
		System.out.println("res = " + res);
    		return res;
	}

	public static void main(String args[]){
		Solution s1 = new Solution();

		int[] nums = new int[]{0, 1, 3, 50, 75};
		int lower = 0;
		int upper = 99;
		s1.findMissingRanges(nums, lower, upper);
		

        }
}
