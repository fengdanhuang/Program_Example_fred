

import java.util.*;



class Solution {

    public int lenLongestFibSubseq(int[] A) {
        
        for(int i=0; i<A.length; i++)
            System.out.print(A[i] + "  ");
        System.out.println();        

        int N = A.length;
         
        Map<Integer,Integer> index = new HashMap<>();
        
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);
        System.out.println("index = " + index);       

        Map<Integer,Integer> longest = new HashMap<>();
        
        int ans = 0;

        for (int k = 0; k < N; ++k){
            for (int j = 0; j < k; ++j) {
                
                int i = index.getOrDefault(A[k]-A[j], -1);
                
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
                
            }
        }
        System.out.println("longest = " + longest);

        System.out.println("ans = " + ans);
        return ans >= 3 ? ans : 0;
    }

    public static void main(String args[]){

        Solution sol = new Solution();

        int[] A = new int[]{1,2,3,4,5,6,7,8};
        sol.lenLongestFibSubseq(A);
    }
    
}
