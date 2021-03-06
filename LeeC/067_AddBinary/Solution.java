


public class Solution {
    
    public String addBinary(String a, String b) {
	System.out.println("\na = " + a);
	System.out.println("b = " + b);
        
        StringBuilder sb = new StringBuilder();
	System.out.println("sb = " + sb);        
        
	int i = a.length() - 1, j = b.length() -1, carry = 0;
        System.out.println("i = " + i);
	System.out.println("j = " + j);
	
        while (i >= 0 || j >= 0) {
            
            int sum = carry;
            
            if (j >= 0) sum += b.charAt(j) - '0';
            
            if (i >= 0) sum += a.charAt(i) - '0';
           
            j--;
            i--;             
 
            sb.append(sum % 2);
            
            carry = sum / 2;
            System.out.println("    carry = " + carry); 
        }
        
        if (carry != 0) sb.append(carry);
        
        String res = sb.reverse().toString();
        System.out.println("res = " + res + "\n");
	return res;
        
    }

    public String addBinary_best(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        
        int carry = 0, i = a.length(),j = b.length();
        
        int res = 0;
        
        while (i > 0 || j > 0 || carry == 1) {
            
            if (i > 0) {
                carry += (a.charAt(--i) - '0');
            }
            
            if (j > 0) {
                carry += (b.charAt(--j) - '0');
            }
            
            sb.insert(0, (char) ((carry % 2) + '0'));
            carry >>>= 1;    
                   
        }
        
        return sb.toString();
        
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	String a = new String("11");
	String b = new String("1");
	s1.addBinary(a,b);

	a = new String("1010101");
	b = new String("1111001");
	s1.addBinary(a,b);
    }
    
}
