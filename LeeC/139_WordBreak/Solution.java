
import java.util.List;
import java.util.ArrayList;
import java.util.*;

class Solution {
 
    public boolean wordBreak(String s, List<String> wordDict) {
	System.out.println("s = " + s);
	System.out.println("wordDict = " + wordDict);	
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
	for (int i=0; i<f.length; i++)
	    System.out.println("f["+i+"]="+f[i]);

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                    
                }
            }
        }
        
        return f[s.length()];
    }


    public static void main(String args[]){
	Solution s1 = new Solution();
	String s = new String("leetcode");
	List<String> dict = new ArrayList<String>();
	dict.add("leet");
	dict.add("code");
	s1.wordBreak(s, dict);

    }

}
