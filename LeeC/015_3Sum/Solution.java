
import java.util.*;

class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();


        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length-2; i++) {
            
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int target = -nums[i];
            int left = i+1, right = nums.length-1;
            
            while(left < right) {
                
                if(nums[left] + nums[right] == target) {    
                    
                    res.add(Arrays.asList(nums[left],nums[right], nums[i]));
                    
                    left++; right--;
                    
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }
                else if(nums[left] + nums[right] < target) {
                    left++;
                }else{
                    right--;
                }
                
            }
        }
       
        System.out.println("res = ");
        System.out.println(res); 
        return res;
        
    }
    
    public static void main(String args[]){

        Solution s = new Solution();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        s.threeSum(nums);

    }
}
