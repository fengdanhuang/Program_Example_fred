


public class Solution {
    
    public boolean isPowerOfTwo(int n) {
	boolean re;
	System.out.println(" n = " + n);
	System.out.println("Integer.bitCount(n) = " + Integer.bitCount(n));
        if ( n>0 && Integer.bitCount(n) == 1){
	    re = true;
	}else{
	    re = false;
	}
	System.out.println("re = " + re + "\n");
	return re;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	s1.isPowerOfTwo(2);
	s1.isPowerOfTwo(3);
	s1.isPowerOfTwo(4);
	s1.isPowerOfTwo(8);
	s1.isPowerOfTwo(16);
	s1.isPowerOfTwo(17);
	s1.isPowerOfTwo(20);
	s1.isPowerOfTwo(32);
	s1.isPowerOfTwo(64);
	s1.isPowerOfTwo(128);
	s1.isPowerOfTwo(256);
	

    }    
}
