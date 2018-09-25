
import java.util.*;


class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
       
        System.out.println("s = " + s);
        System.out.println("p = " + p); 
        
        int[] map = new int[26];

        for(char c : p.toCharArray()) map[c - 'a']++;
        
        for(int i=0; i<map.length; i++)
            System.out.print(map[i] + "  ");
        System.out.println();
        
        
        int end = 0;
    	char[] str = s.toCharArray();
    	
        int count = p.length();
    	List<Integer> res = new ArrayList<>();
    	
        int start = 0;
    	while(end < s.length()){
    		
            if(map[str[end++] - 'a']-- > 0) count--;
    		
            while(count == 0){
                if(end - start == p.length()) res.add(start);
                if(map[str[start++] - 'a']++ == 0) count++;
    	    }
            System.out.println("    count = " + count);
    	}
        System.out.println("res = " + res + "\n");
    	return res;
        
    }

    public static void main(String args[]){
        Solution s = new Solution();
        String str = "cbaebabacd", p = "abc";
        s.findAnagrams(str, p);
        
        str = "abab"; p = "ab";
        s.findAnagrams(str, p);

    }
    
}
