
import java.util.*;


class Solution {
    
    public List<String> generatePossibleNextMoves(String s) {
   	System.out.println("s = " + s);
	 
        List<String> list = new ArrayList<>();
    
        for (int i=-1; (i = s.indexOf("++", i+1)) >= 0; )
            list.add(s.substring(0, i) + "--" + s.substring(i+2));
   
	System.out.println("list = " + list); 
        return list;

    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	String s = new String("++++");
	s1.generatePossibleNextMoves(s);


    }
    
}
