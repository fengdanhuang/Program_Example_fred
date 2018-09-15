



enum Result {
    TRUE, FALSE
}

class Solution {

    Result[][] memo;
        
    public boolean isMatch(String text, String pattern) {
        System.out.println("text = " + text);
        System.out.println("pattern = " + pattern);
 
        memo = new Result[text.length() + 1][pattern.length() + 1];
        
        boolean re = dp(0, 0, text, pattern);
        System.out.println("re = " + re + "\n");
        return re;
        
    }
    
    public boolean dp(int i, int j, String text, String pattern) {
        
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        
        boolean ans;
        
        if (j == pattern.length()){
            
            ans = i == text.length();
            
        } else{
            
            boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                
                ans = (dp(i, j+2, text, pattern) || first_match && dp(i+1, j, text, pattern));
                
            } else {
                
                ans = first_match && dp(i+1, j+1, text, pattern);
                
            }
        }
        
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        
        return ans;
    }


    public static void main(String args[]){
	Solution s = new Solution();

        String str = "aa", p="a";
        s.isMatch(str, p);

        str="aa"; p="a*";
        s.isMatch(str, p);

        str="ab"; p=".*";
        s.isMatch(str, p);
         
        str="aab"; p="c*a*b";
        s.isMatch(str, p);

        str="mississippi"; p="mis*is*p*.";
        s.isMatch(str, p);
    }
     
}
