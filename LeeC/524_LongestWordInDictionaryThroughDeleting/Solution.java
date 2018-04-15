
import java.util.*;


public class Solution {
    
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    
    public String findLongestWord(String s, List < String > d) {
	System.out.println();	
	System.out.println("s = " + s);
	System.out.println("d = " + d);

        String max_str = "";
	System.out.println("max_str = " + max_str + "\n");
        
	for (String str: d) {
	    System.out.println("    str = " + str);
            System.out.println("    isSubsequence(str, s) = " + isSubsequence(str, s));
            if (isSubsequence(str, s)) {
		System.out.println("        str.length() = " + str.length());
		System.out.println("        max_str.length() = " + max_str.length());
		System.out.println("        str.compareTo(max_str) = " + str.compareTo(max_str));
		
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
	    System.out.println("    max_str = " + max_str + "\n");
        }

	System.out.println("max_str = " + max_str + "\n");
        return max_str;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	String s = new String("abpcplea");
	List<String> d = new LinkedList<String>(Arrays.asList("ale","apple","monkey","plea"));
	s1.findLongestWord(s, d);

    }
}
