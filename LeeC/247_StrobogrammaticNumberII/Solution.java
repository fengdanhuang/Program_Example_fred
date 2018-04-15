
import java.util.*;


class Solution {
    
    public List<String> findStrobogrammatic(int n) {
        System.out.println("\nn = " + n);
	
	List<String> h = helper(n, n);

	System.out.println("h = " + h + "\n");
	return h;
    }

    List<String> helper(int n, int m) {
    
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
    
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
    
        List<String> list = helper(n - 2, m);
    
        List<String> res = new ArrayList<String>();
   	
	System.out.println("res = " + res); 
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println("    s = " + s);
 
            if (n != m) res.add("0" + s + "0");
        
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
	    System.out.println("    res = " + res); 
        }
    
        return res;
    }

    public static void main(String args[]){
        Solution s1 = new Solution();
        
 	int n = 0;
	s1.findStrobogrammatic(n);
 	
	n = 1;
	s1.findStrobogrammatic(n);
 	
	n = 2;
	s1.findStrobogrammatic(n);
 	
	n = 3;
	s1.findStrobogrammatic(n);
    }    
    	    
}
