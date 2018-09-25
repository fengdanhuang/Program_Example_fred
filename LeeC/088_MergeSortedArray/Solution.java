


class Solution {
    
    public void merge(int A[], int m, int B[], int n) {
        
        for(int a=0; a<A.length; a++)
            System.out.print(A[a] + "  ");
        System.out.println();       
 
        for(int b=0; b<B.length; b++)
            System.out.print(B[b] + "  ");
        System.out.println();

        int i=m-1, j=n-1, k=m+n-1;
        
        while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
        
        while (j>-1) A[k--]=B[j--];
        
        for(int a=0; a<A.length; a++)
            System.out.print(A[a] + "  ");
        System.out.println();       
    }
     
    public static void main(String args[]){
        Solution s = new Solution();

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        s.merge(nums1, m, nums2, n);

    }   
}
