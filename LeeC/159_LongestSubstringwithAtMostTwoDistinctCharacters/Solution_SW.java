
import java.util.HashMap;

class Solution_SW{

    public int lengthOfLongestSubstringTwoDistinct(String s) {
	System.out.println("s = " + s);
        if (s == null || s.length() == 0) return 0;
	HashMap<Character, Integer> map = new HashMap<>();
	int start = 0;
	int end = 0;
	int re = 0;

	while(end < s.length()){
	    if(map.size() <= 2) {
                map.put(s.charAt(end),end);
		end++;
	    }	    
	    if(map.size() > 2){
		int leftMost = s.length();
		for (int num: map.values()){
		    leftMost = Math.min(leftMost, num);    
		}
		map.remove(s.charAt(leftMost));
		start = leftMost + 1;
	    }
	    re = Math.max(re, end-start);
	}
	System.out.println("re = " + re + "\n");
	return re;
    }

    
    public static void main(String args[]){
	Solution_SW s1 = new Solution_SW();

	String s = new String("eceba");
	s1.lengthOfLongestSubstringTwoDistinct(s);
    }

}
