
import java.util.*;

class Solution {
    
    public int[] intersection(int[] nums1, int[] nums2) {
       
        for(int n1=0; n1<nums1.length; n1++)
            System.out.print(nums1[n1] + "  ");
        System.out.println();

        for(int n2=0; n2<nums2.length; n2++)
            System.out.print(nums2[n2] + "  ");
        System.out.println();
         
        Set<Integer> set = new HashSet<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
            
        }
        
        int[] result = new int[set.size()];
        
        int k = 0;
        
        for (Integer num : set) {
            result[k++] = num;
        }
       
        for(int r=0; r<result.length; r++)
            System.out.print(result[r] + "  ");
        System.out.println("\n"); 
        return result;
        
    }

    public static void main(String args[]){
        Solution s = new Solution();

        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        s.intersection(nums1, nums2);

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        s.intersection(nums1, nums2);
    }
}
