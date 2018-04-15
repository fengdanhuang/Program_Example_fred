


public class Solution {
    
    public String addStrings(String num1, String num2) {
	System.out.println("num1 = " + num1);
	System.out.println("num2 = " + num2);       
	System.out.println("num1.length() = " + num1.length());
	System.out.println("num2.length() = " + num2.length());       
 
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
	    System.out.println("    i=" + i + ",j=" +j);
 
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            System.out.println("    x=" + x);
	    System.out.println("    y=" + y);
	    
	    int digit = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
	    System.out.println("    digit=" + digit);
	    System.out.println("    carry=" + carry);
	    sb.append(digit);
            System.out.println("    sb = " + sb + "\n");
        }

        String re = sb.reverse().toString();
	System.out.println("re = " + re + "\n");
	return re;
    }
 
    public static void main(String args[]){
	Solution s1 = new Solution();
	
	String num1 = new String("4288");
	String num2 = new String("3295");
	s1.addStrings(num1, num2);
    }   
}
