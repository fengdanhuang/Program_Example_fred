

import java.util.*;


class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        
        if((s==null) || s.length()==0) return 0;
        
        int re = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0, j=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }else{
                set.add(s.charAt(i));
                re = Math.max(re, s.length());
            }
        }
        
        return re;
        
    }
}
