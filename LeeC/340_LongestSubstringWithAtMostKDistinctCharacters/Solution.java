


public class Solution {
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int[] count = new int[256];
        
        int num = 0, i = 0, res = 0;
        
        for (int j = 0; j < s.length(); j++) {

            System.out.println("s.charAt(j) = " + s.charAt(j)); 
            System.out.println("count[s.charAt(j)] = " + count[s.charAt(j)]);

	    if (count[s.charAt(j)]++ == 0) num++;
            
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
            
        }

	System.out.println("res = " + res);	
        return res;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

        String s = new String("eceba");
	int k = 2;
	s1.lengthOfLongestSubstringKDistinct(s, k);
    }
    
}
