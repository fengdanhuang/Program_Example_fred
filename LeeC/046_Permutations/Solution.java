


class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(res, nums, 0);
        
        return res;
    }
    
    public void helper(List<List<Integer>> res, int[] nums, int start) {
        
        if(start >= nums.length) {
            
            ArrayList<Integer> curr = new ArrayList<>();
            
            for(int i:nums) curr.add(i);
            
            res.add(curr);
            
        } else {
            
            for(int i = start; i < nums.length; i++) {
                swap(start, i, nums);
                helper(res, nums, start + 1);
                swap(start, i, nums);
            }
            
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];nums[i] = nums[j];nums[j] = tmp;
    }
}
