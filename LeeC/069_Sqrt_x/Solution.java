

class Solution {
    
    public static int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }

    
    public static int mySqrt_BS(int x) {

    	if (x == 0) return 0;
    
	int left = 1, right = Integer.MAX_VALUE;
   	System.out.println("left = " + left);
	System.out.println("right = " + right);
	 
	while (true) {
        	int mid = left + (right - left)/2;
        	if (mid > x/mid) {
            		right = mid - 1;
        	} else {
            		if (mid + 1 > x/(mid + 1)) {
				System.out.println("mid = " + mid);
				return mid;
			}
            		left = mid + 1;
        	}
     	}
    }

   

    public static void main(String args[]){
	Solution s1 = new Solution();

	int x = 0;
	s1.mySqrt_BS(x);	
	x = 1;
	s1.mySqrt_BS(x);
	x = 2;
	s1.mySqrt_BS(x);
	x = 3;
	s1.mySqrt_BS(x);
	x = 8;
	s1.mySqrt_BS(x);
		
    }
    
}
