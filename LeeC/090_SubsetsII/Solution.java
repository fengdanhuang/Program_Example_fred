
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
 
   public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
	System.out.println("nums = " + nums);
	for(int i=0; i<nums.length; i++)
		System.out.print(nums[i] + " ");
	System.out.println();
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> each = new ArrayList<>();
        
        helper(res, each, 0, nums);
        
	System.out.println("res = " + res);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
    
        if (pos <= n.length) {
            res.add(each);
	    System.out.println("   each = " + each);
            System.out.println("   res = " + res);	
	}
        
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }

    public static void main(String args[]){
	
	Solution s1 = new Solution();
	int[] nums = {1,2,3,4};
	s1.subsetsWithDup(nums);
    }
}
