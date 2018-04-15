
import java.util.*;


public class Solution {
    
    public List<String> summaryRanges(int[] nums) {
        System.out.println();
	for(int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();
	 
        List<String> summary = new ArrayList<>();
        
        for (int i = 0, j = 0; j < nums.length; ++j) {
            
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        
	System.out.println("summary = " + summary);
        return summary; 
    }
    
    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] nums = new int []{0,1,2,4,5,7};
	s1.summaryRanges(nums);

	nums = new int []{0,2,3,4,6,8,9};
	s1.summaryRanges(nums);
    }
    
}

