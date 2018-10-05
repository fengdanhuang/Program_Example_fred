


class Solution {

    public int removeDuplicates(int[] A) {
    
        if (A.length==0) return 0;
    
        int j=0; //i is iterator, j is current & final index
    
        for (int i=0; i<A.length; i++)
            if (A[i]!=A[j]) A[++j]=A[i];
    
        return ++j;
    
    }
 
    public static void main(String args[]){
        Solution sol = new Solution();

        int[] A = int[]{1,1,2};
        sol.removeDuplicates(A);

        A = int[]{0,0,1,1,1,2,2,3,3,4};
        sol.removeDuplicates(A);
  

    }   
}
