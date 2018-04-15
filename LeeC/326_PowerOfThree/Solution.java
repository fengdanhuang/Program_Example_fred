


public class Solution {
    
    public boolean isPowerOfThree(int n) {
        boolean re = Integer.toString(n, 3).matches("^10*$");
	System.out.println("n = " + n);
	System.out.println("Integer.toString(n) = " + Integer.toString(n));
	System.out.println("Integer.toString(n,3) = " + Integer.toString(n, 3));
	
	System.out.println("re = " + re + "\n");
	return re;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	s1.isPowerOfThree(3);
	s1.isPowerOfThree(9);
	s1.isPowerOfThree(27);
	s1.isPowerOfThree(100);
	s1.isPowerOfThree(200);
	s1.isPowerOfThree(300);

    }
}
