


public class Solution {

    public int longestValidParentheses(String s) {
        System.out.println("s = " + s);
        System.out.println("s.length() = " + s.length());
        if (s.length() < 2) {
            return 0;
        }

        int[] memo = new int[s.length()];

        memo[s.length() - 1] = 0;
        memo[s.length() - 2] = s.charAt(s.length() - 2) == '(' && s.charAt(s.length() - 1) == ')' ? 2 : 0;

        int longest = memo[s.length() - 2];

        for (int i = s.length() - 3; i >= 0; i--) {

            int subLongest = 0;
            int nextLongest = i + memo[i + 1] + 1;
            if (nextLongest < s.length() && s.charAt(i) == '(' && s.charAt(nextLongest) == ')') {
                subLongest += memo[i + 1];
                if (nextLongest + 1 < s.length()) {
                    subLongest += memo[nextLongest + 1];
                }
                subLongest += 2;
                longest = longest > subLongest ? longest : subLongest;
            }
            memo[i] = subLongest;
        }
        
        System.out.println("longest = " + longest);
        return longest;
    }

    public static void main(String args[]){
        Solution s1 = new Solution();

        String s = "(()";
        s1.longestValidParentheses(s);
        
        s = ")()())";
        s1.longestValidParentheses(s);
        

    }
}
