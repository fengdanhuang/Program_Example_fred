
import java.util.*;


class Solution {
    
    public boolean isStrobogrammatic(String num) {
       System.out.println("num = " + num);
	 
       boolean re;
       for (int i=0, j=num.length()-1; i <= j; i++, j--)   
           
	   if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j))){
                re = false;
       		
		System.out.println("re = " + re);
		return re;
	   }
                
	re = true;
       	System.out.println("re = " + re);
       	return re; 
    }

    public static void main(String args[]){
	Solution s1 = new Solution();
	
	String s = new String("69");
	s1.isStrobogrammatic(s);
	
	s = new String("88");
	s1.isStrobogrammatic(s);
	
	s = new String("818");
	s1.isStrobogrammatic(s);
    }
    
}
