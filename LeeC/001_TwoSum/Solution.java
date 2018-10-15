
import java.util.*;


class Solution {

    public int[] twoSumBF(int[] nums, int target) {
        
        for(int i=0; i<nums.length; i++)
            System.out.print(nums[i] + "  ");
        System.out.println();

        System.out.println("target = " + target); 
        int[] index = new int[2];
        
        for(int i=0; i<nums.length-1; i++){
            
            for(int j=i+1; j<nums.length; j++){
                
                if(nums[i]+nums[j] == target){
                    index[0] = i; index[1] = j;
                   
                    for(int x=0; x<index.length; x++)
                        System.out.print(index[x] + "  ");
                    System.out.println(); 
                    
                    return index;
                }
            }
            
        }
        
        return null;
        
    }

    public int[] twoSumTwoPass(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        System.out.println("map = " + map);                
        System.out.println("map.size() = " + map.size()); 

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumOnePass(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
    
        for (int i = 0; i < nums.length; i++) {
            
           int complement = target - nums[i];
           
           if (map.containsKey(complement)) {
              
              int[] index = new int[2];
              index[0] = map.get(complement);
              index[1] = i;

              return index;
            }

            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    } 

    public static void main(String argv[]){
        Solution sol = new Solution();

        int[] nums = new int[]{2, 7, 11, 15};  
        int target = 9;
        sol.twoSumBF(nums, target);
          
        /* Only one solution.
        nums = new int[]{2,2,2,2};
        int target = 4;
        sol.twoSumBF(nums, target);
        */
        
        sol.twoSumTwoPass(nums, target);

        nums = new int[]{2,2,2,2};
        target = 4;
        sol.twoSumTwoPass(nums, target);

        nums = new int[]{4,4,5,8};
        target = 8;
        sol.twoSumTwoPass(nums, target);
 
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
                   
    }
}
