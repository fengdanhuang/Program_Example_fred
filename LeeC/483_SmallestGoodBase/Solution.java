


public class Solution {
    
    public String smallestGoodBase(String n) {
	System.out.println("\nn = " + n);       
 
        long num = 0;
        
        for (char c : n.toCharArray()) num = num * 10 + c - '0';
	System.out.println("num = " + num);       
 
        long x = 1;
       
	String re; 
        for (int p = 64; p >= 1; p--) {
            if ((x << p) < num) {
                long k = helper(num, p);
                if (k != -1) {
		    re = String.valueOf(k);
	            System.out.println("re = " + re + "\n");
		    return re;
		}
            }
        }

	re = String.valueOf(num - 1);
	System.out.println("re = " + re + "\n");
        return re;
    }
    
    private long helper(long num, int p) {
        
        long l = 1, r = (long)(Math.pow(num, 1.0/p) + 1);
        
        while (l < r) {
            long mid = l + (r - l) / 2;
            long sum = 0, cur = 1;
            for (int i = 0; i <= p; i++) {
                sum += cur;
                cur *= mid;
            }
            if (sum == num) return mid;
            else if (sum > num) r = mid;
            else l = mid + 1;
        }
        
        return -1;
        
    }

    public static void main(String args[]){
	
	Solution s1 = new Solution();

	String n = "13";
	s1.smallestGoodBase(n);

	n = "4681";
	s1.smallestGoodBase(n);

	n = "1000000000000000000";
	s1.smallestGoodBase(n);

    }
   
    
}
