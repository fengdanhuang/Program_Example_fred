


class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] nums = new int[nums1.length+nums2.length];
        
        for(int i=0; i<nums1.length; i++){
            nums[i] = nums1[i];
        }
        
        for(int i=0; i<nums2.length; i++){
            nums[nums1.length+i] = nums2[i];
        }
        
        Arrays.sort(nums);
        
        if(nums.length%2 == 0)  return ((double)nums[nums.length/2-1]+nums[nums.length/2]) / 2.0;
        else return nums[(nums.length-1)/2];
        
        
    }
 
    public static void main(String args[]){


    }
   
}
