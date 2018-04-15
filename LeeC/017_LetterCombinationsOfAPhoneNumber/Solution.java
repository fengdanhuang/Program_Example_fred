


import java.util.*;


public class Solution {
    	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    	public List<String> letterCombinations(String digits) {
		System.out.println("digits = " + digits);
    		List<String> ret = new LinkedList<String>();
    		combination("", digits, 0, ret);
		
		System.out.println("ret = " + ret);
    		return ret;
    	}
    
    	private void combination(String prefix, String digits, int offset, List<String> ret) {
		System.out.println("Inside combination() recursion:");
		System.out.println("    prefix = " + prefix);
		System.out.println("    digits = " + digits);
                System.out.println("    offset = " + offset);
		System.out.println("    ret = " + ret);
    		

		if (offset >= digits.length()) {
    			ret.add(prefix);
    			return;
    		}
    		
		String letters = KEYS[(digits.charAt(offset) - '0')];
    		System.out.println("    letters = " + letters);
		
		for (int i = 0; i < letters.length(); i++) {
    			combination(prefix + letters.charAt(i), digits, offset + 1, ret);
    		}
    	}


        public static void main(String args[]){
		Solution s1 = new Solution();

		String digits = new String("23");
		s1.letterCombinations(digits);

        }


}
