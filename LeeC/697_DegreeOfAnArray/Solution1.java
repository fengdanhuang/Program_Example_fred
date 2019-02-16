
import java.util.*;


class Solution1 {
    
    public int findShortestSubArray(int[] nums) {
        
        Arrays.sort(nums);
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        int[] freq = new int[set.size()];
        
        for(int i=0; i<freq.length; i++){
            freq[i] = 1;
        }
        
        int id = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]) freq[id]++;
            else id++;
        }

        for(int i=0; i<freq.length; i++){
            System.out.print(freq[i] + " ");
        }
        System.out.println();
        
        int degree = freq[0];
        for(int i=1; i<freq.length; i++){
            if(degree < freq[i]) degree = freq[i];
        }
        
        System.out.println("degree = " + degree);
        return degree;
             
    }

    public static void main(String[] args){
        Solution1 s1 = new Solution1();
      
        int[] nums = new int[]{1,2,2,3,1};
        s1.findShortestSubArray(nums);

        nums = new int[]{1,2,2,3,1,4,2};
        s1.findShortestSubArray(nums);
    }
}
