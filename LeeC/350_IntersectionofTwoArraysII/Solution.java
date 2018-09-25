
<<<<<<< HEAD
=======

>>>>>>> master
import java.util.*;

class Solution {
    
<<<<<<< HEAD
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
        
=======
    public int[] intersect(int[] nums1, int[] nums2) {
       
        for(int i=0; i<nums1.length; i++)
            System.out.print(nums1[i] + "  ");
        System.out.println();

        for(int i=0; i<nums2.length; i++)
            System.out.print(nums2[i] + "  ");
        System.out.println();
 
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int[] res=new int[nums1.length];
        
        int i=0,j=0,index=0,count=0;
        
        while(i<nums1.length&&j<nums2.length){
            
            if(nums1[i]==nums2[j]){
                res[index++]=nums1[i];
                count++;
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        
        int[] result=new int[count];
        
        for(int x=0;x<count;x++){
            result[x]=res[x];
        }
        
        for(int x=0; x<result.length; x++)
            System.out.print(result[x] + "  ");
        System.out.println("\n");

        return result;
>>>>>>> master
    }

    public static void main(String args[]){
        Solution s = new Solution();

        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
<<<<<<< HEAD
        s.intersection(nums1, nums2);

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        s.intersection(nums1, nums2);
         

    }
=======
        s.intersect(nums1, nums2);

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        s.intersect(nums1, nums2);

    }

    
>>>>>>> master
}
