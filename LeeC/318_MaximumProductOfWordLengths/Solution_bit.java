


class Solution_bit{
    

    public int maxProduct(String[] words){
	for(int i=0; i<words.length; i++)
	    System.out.print(words[i] + "  ");
	System.out.println();

        int res = 0;
        int[] bytes = new int[words.length];
        for(int i=0; i<words.length; i++){
            int val = 0;
            for (int j=0; j<words[i].length(); j++){
	        val |= 1 << (words[i].charAt(j)-'a');
	    }
	    bytes[i] = val;
	}
	for (int i=0; i<bytes.length; i++){
            for (int j=i+1; j<bytes.length; j++){
                if ((bytes[i] & bytes[j]) == 0){ 
		    res = Math.max(res, words[i].length()*words[j].length());
                }
	    }
         }
	 System.out.println("res = " + res);
	 return res;
    }

    public static void main(String args[]){
	Solution_bit s1 = new Solution_bit();

	String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        s1.maxProduct(words);

	words = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        s1.maxProduct(words);

	words = new String[]{"a", "aa", "aaa", "aaaa"};
        s1.maxProduct(words);
    }
}
