



class Solution {
    public int findNthDigit(int n) {
	System.out.println("n = " + n);

	int len = 1;
	long count = 9;
	int start = 1;

	while (n > len * count) {
	    n -= len * count;
	    len += 1;
	    count *= 10;
	    start *= 10;
	}

	start += (n - 1) / len;
	String s = Integer.toString(start);
	int re = Character.getNumericValue(s.charAt((n - 1) % len));
        
	System.out.println("re = " + re);
	return re;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	s1.findNthDigit(3);
	s1.findNthDigit(11);	

    }
}
