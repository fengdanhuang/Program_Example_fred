


public class Solution {
    
    public String addBoldTag(String s, String[] dict) {
        System.out.println("s = " + s);
	for(int i=0; i<dict.length; i++)
	    System.out.print(dict[i] + "  ");
	System.out.println();	
 
        boolean[] bold = new boolean[s.length()];
        
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
       
	System.out.println("result = " + result); 
        return result.toString();
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	String s = new String("abcxyz123");
	String[] dict = new String[]{"abc","123"};
	s1.addBoldTag(s, dict);

	s = new String("aaabbcc");
	dict = new String[]{"aaa","aab","bc"};
	s1.addBoldTag(s, dict);

    }
}
