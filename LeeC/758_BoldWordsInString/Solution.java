

class Solution {
    
    public String boldWords(String[] words, String S) {
	for(int i=0; i<words.length; i++)
	    System.out.print(words[i] + "  ");
	System.out.println();

	System.out.println("S = " + S);

        int N = S.length();
        
	boolean[] mask = new boolean[N];
        
	for (int i = 0; i < N; ++i)
            for (String word: words) search: {
                for (int k = 0; k < word.length(); ++k)
                    if (k+i >= S.length() || S.charAt(k+i) != word.charAt(k))
                        break search;

                for (int j = i; j < i+word.length(); ++j)
                    mask[j] = true;
            }

        StringBuilder ans = new StringBuilder();
        int anchor = 0;
        for (int i = 0; i < N; ++i) {
            if (mask[i] && (i == 0 || !mask[i-1]))
                ans.append("<b>");
            ans.append(S.charAt(i));
            if (mask[i] && (i == N-1 || !mask[i+1]))
                ans.append("</b>");
        }
	String re = ans.toString();
	System.out.println("re = " + re + "\n");
        return re;
    }

    public boolean match(String S, int i, int j, String T) {
        for (int k = i; k < j; ++k)
            if (k >= S.length() || S.charAt(k) != T.charAt(k-i))
                return false;
        return true;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	String[] words = new String[]{"ab","bc"};
	String S = new String("aabcd");
	s1.boldWords(words, S);


    }

}
