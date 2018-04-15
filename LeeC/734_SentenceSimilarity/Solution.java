
import java.util.*;


class Solution {

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
	System.out.println("words1 = " + words1);        

	
	if (words1.length != words2.length) return false;

        Set<String> pairset = new HashSet<String>();
        System.out.println("pairset = " + pairset);
	
	for (String[] pair: pairs)
            pairset.add(pair[0] + "#" + pair[1]);
        System.out.println("pairset = " + pairset);

        for (int i = 0; i < words1.length; ++i) {
            System.out.println("    words1["+i+"]=" + words1[i]);
            System.out.println("    words2["+i+"]=" + words2[i]);

	    if (!words1[i].equals(words2[i]) &&
                    !pairset.contains(words1[i] + "#" + words2[i]) && 
                    !pairset.contains(words2[i] + "#" + words1[i])){
                System.out.println("    pairset = " + pairset);
                return false;
            }
        }
	
        System.out.println("pairset = " + pairset);
        return true;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	String[] word1 = new String[]{"great","acting","skills"};
	
	String[] word2 = new String[]{"fine","drama","talent"};
	
	String[][] pairs = new String[][]{{"great","fine"},{"drama","acting"},{"skills","talent"}};

	s1.areSentencesSimilar(word1, word2, pairs);

    }
}
