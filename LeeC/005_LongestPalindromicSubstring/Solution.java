



public class Solution {
    
    int len = 0, maxLength = 0, init = 0;
    
    public String longestPalindrome(String s) {
        
        char[] chars = s.toCharArray();
        
        len = s.length();
        
        if (len <= 1) return s;
        
        for (int i = 0; i < len; i++) {
            i = manacher(chars, i);
        }
        return s.substring(init, init + maxLength);
    }
    
    public int manacher(char[] chars, int k) {
        
        int i = k - 1, j = k;
        while (j < len - 1 && chars[j] == chars[j + 1]) j++;
        int nextCenter = j++;
        
        while (i >= 0 && j < len && chars[i] == chars[j]) {
            i--;
            j++;
        }
        
        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            init = i + 1;
        }
        
        return nextCenter;
    }
    
    public static void main(String args[]){
        Solution sol = new Solution();

        String s = "babad";
        sol.longestPalindrome(s);

        s = "cbbd";
        sol.longestPalindrome(s);


    }    
}
