
import java.util.*;

class Solution {
    
    public int lengthLongestPath(String input) {
	System.out.println("\ninput = " + input);


        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0); // "dummy" length

        int maxLen = 0;

        for(String s:input.split("\n")){
	    System.out.println("    s.lastIndexOf(\"\\t\") = " + s.lastIndexOf("\t"));
		
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            System.out.println("    lev = " + lev);

	    while(lev+1<stack.size()) stack.pop(); // find parent
	    System.out.println("    stack = " + stack);
	                
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            System.out.println("    len = " + len);
            
            stack.push(len);
	    System.out.println("    stack = " + stack);	           
 
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1); 
	    System.out.println("    maxLen = " + maxLen + "\n");	           
        }

	System.out.println("stack = " + stack);
	System.out.println("maxLen = " + maxLen);
        return maxLen;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	String s = new String("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
	s1.lengthLongestPath(s);
    
	s = new String("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
	s1.lengthLongestPath(s);

    }
}
