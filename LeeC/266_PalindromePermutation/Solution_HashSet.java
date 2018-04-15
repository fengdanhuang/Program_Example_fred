
import java.util.*;


class Solution_HashSet {

    public boolean canPermutePalindrome(String s) {
        
        HashSet<Character> set = new HashSet<>();
        char ca[] = s.toCharArray();
	boolean re;
        
	for(int i=0; i<ca.length; i++)
	    System.out.print("ca[" + i + "]=" + ca[i] + "  ");
	System.out.println();	 

        for(char c: ca){
	    System.out.println("    c = " + c);
            if (set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
	    System.out.println("    set = " + set);
        }
        
        if(set.size()<=1){
            re = true;
        }else{
            re = false;
        }
	System.out.println("re = " + re + "\n");
        return re;
        
    }


    public static void main(String args[]){
	Solution_HashSet s1 = new Solution_HashSet();

	String s = new String("code");
	s1.canPermutePalindrome(s);

	s = new String("aab");
	s1.canPermutePalindrome(s);
	
	s = new String("carerac");
	s1.canPermutePalindrome(s);
    }
}
