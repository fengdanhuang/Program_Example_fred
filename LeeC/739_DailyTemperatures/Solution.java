
import java.util.*;


class Solution {
    
    public int[] dailyTemperatures(int[] T) {
	for (int i=0; i<T.length; i++)
 	    System.out.print(T[i] + "  ");
	System.out.println();       
 
        int[] ans = new int[T.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = T.length - 1; i >= 0; --i) {
            
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            
            stack.push(i);
        }
	System.out.println("stack = " + stack);

	for (int i=0; i<ans.length; i++)
	    System.out.print(ans[i] + "  ");
	System.out.println();
        return ans;
        
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
	s1.dailyTemperatures(T);

    }

}
