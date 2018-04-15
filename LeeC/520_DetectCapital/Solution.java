


class Solution {
    public boolean detectCapitalUse(String word) {
	System.out.println("word = " + word);
	System.out.println("word.length() = " + word.length());
	System.out.println("word.toUpperCase() = " + word.toUpperCase());
	System.out.println("word.substring(1) = " + word.substring(1));
	System.out.println("\n");

        if (word.length() < 2) return true;
        if (word.toUpperCase().equals(word)) return true;
        if (word.substring(1).toLowerCase().equals(word.substring(1))) return true;
        return false;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	String word = new String("USA");
	s1.detectCapitalUse(word);

	word = new String("FlaG");
	s1.detectCapitalUse(word);

    }
}
