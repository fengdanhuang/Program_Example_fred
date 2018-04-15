

import java.util.*;



class Solution {
    public boolean isValid(String s) {
        
	Stack<Character> stack = new Stack<Character>();       
	System.out.println("stack = " + stack);
	boolean re;
	 
	for (char c : s.toCharArray()) {
		System.out.println("    c = " + c);
		if (c == '('){
			stack.push(')');
			System.out.println("    1.stack = " + stack);
		}else if (c == '{'){
			stack.push('}');
			System.out.println("    2.stack = " + stack);
		}else if (c == '['){
			stack.push(']');
			System.out.println("    3.stack = " + stack);
		}else if (stack.isEmpty() || stack.pop() != c){
			System.out.println("    4.stack = " + stack);
			re = false;
			System.out.println("    re = " + re);
			return re;
		}
		System.out.println("    stack = " + stack);
		
	}
	if(stack.isEmpty()){
		re = true;
	}else{
		re = false;
	}
	System.out.println("re = " + re);
	return re;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();
	
	String s = new String("[{([[[[[]]");
	s1.isValid(s);

	s = new String("[]{}()[][][][[]]");
	s1.isValid(s);
    }
}
