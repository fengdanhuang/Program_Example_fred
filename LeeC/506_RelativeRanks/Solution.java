
import java.util.*;


class Solution {
    
    public String[] findRelativeRanks(int[] nums) {
	for(int i=0; i<nums.length; i++)
	    System.out.print(nums[i] + "  ");
	System.out.println();       
 
        int[][] pair = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        
        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
        
        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

	for(int i=0; i<result.length; i++)
	    System.out.print(result[i] + "  ");
	System.out.println();
        return result;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] nums = new int[]{5, 4, 3, 2, 1};
	s1.findRelativeRanks(nums);

		

    }
}
