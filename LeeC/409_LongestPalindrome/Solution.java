
import java.util.*;

class Solution {
    
    public int longestPalindrome(String s) {
	System.out.println("s = " + s);       
 
        if(s==null || s.length()==0) return 0;
        
        HashSet<Character> hs = new HashSet<Character>();
        
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }

	System.out.println("hs = " + hs);
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }
    
    public static void main(String args[]){
	Solution s1 = new Solution();

	String s = new String("abccccdd");
	s1.longestPalindrome(s);

    }
}
