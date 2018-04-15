

import java.util.*;

class Solution {
    
    public int[] anagramMappings(int[] A, int[] B) {
	for(int i=0; i<A.length; i++)
	    System.out.print(A[i] + "  ");
	System.out.println();        

	for(int i=0; i<B.length; i++)
	    System.out.print(B[i] + "  ");
	System.out.println();        

        Map<Integer, Integer> D = new HashMap<>();
        
        for (int i = 0; i < B.length; ++i)
            D.put(B[i], i);

	System.out.println("D = " + D);


        int[] ans = new int[A.length];
        
        int t = 0;
        
        for (int x: A)
            ans[t++] = D.get(x);

	for(int i=0; i<ans.length; i++)
	    System.out.print(ans[i] + "  ");
	System.out.println();
        
        return ans;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] A = new int[]{12, 28, 46, 32, 50};
	int[] B = new int[]{50, 12, 32, 46, 28};
	s1.anagramMappings(A, B);

    }
    
}
