
import java.util.*;

public class Solution {
    
    public String decodeString(String s) {
        System.out.println("s = " + s);
	 
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        
        while (idx < s.length()) {
            System.out.println("    s.charAt(idx) = " + s.charAt(idx));
		 
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }else {
                res += s.charAt(idx++);
            }
            
        }
       
	System.out.println("countStack = " + countStack); 
	System.out.println("resStack = " + resStack);
	System.out.println("res = " + res + "\n");
        return res;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	String s = new String("3[a]2[bc]");
	s1.decodeString(s);	  
  
     }

}

