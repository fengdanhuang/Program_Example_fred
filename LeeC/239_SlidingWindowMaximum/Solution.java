
import java.util.*;


class Solution {
    
    public int[] maxSlidingWindow(int[] a, int k) {	
        
		if (a == null || k <= 0) {
			return new int[0];
		}
        
		int n = a.length;
        
		int[] r = new int[n-k+1];
        
		int ri = 0;
        
		// store index
		Deque<Integer> q = new ArrayDeque<>();
   		System.out.println("q = " + q); 
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
   			System.out.println("    q = " + q); 
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
   			System.out.println("    q = " + q); 
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
   			System.out.println("    q = " + q); 
		}
		for(int i=0; i<r.length; i++)
			System.out.print(r[i] + "  ");
       		System.out.println(); 
		return r;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] a = new int[]{1,3,-1,-3,5,3,6,7};
	int k = 3;
	s1.maxSlidingWindow(a, k);
	
    }
 	   
}
