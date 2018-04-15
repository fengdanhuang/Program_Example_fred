
import java.util.*;


class Solution {
    
    public String nextClosestTime(String time) {
       
	System.out.println("time.substring(0,2) = "+ time.substring(0,2)); 
        System.out.println("Integer.parseInt(time.substring(0,2) = " + Integer.parseInt(time.substring(0,2)));

	int cur = 60 * Integer.parseInt(time.substring(0, 2));
	System.out.println("cur = " + cur);
        
	
	System.out.println("time.substring(3) = "+ time.substring(3)); 
        cur += Integer.parseInt(time.substring(3));
	System.out.println("cur = " + cur);
        
        Set<Integer> allowed = new HashSet<Integer>();
        
        for (char c: time.toCharArray()) 
		if (c != ':') {
            		allowed.add(c - '0');
        	}
	System.out.println("allowed = " + allowed);

        while (true) {
            cur = (cur + 1) % (24 * 60);
	    //System.out.println("cur = " + cur);
            
	    int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            search : {
		for (int d: digits) if (!allowed.contains(d)) break search;
                System.out.printf("%02d:%02d\n\n", cur/60, cur%60);
		return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
    }
    
    public static void main(String args[]){

	Solution s1 = new Solution();
	
	String s = new String("19:34");
	s1.nextClosestTime(s);

	s = new String("23:59");
	s1.nextClosestTime(s);

    }
}
