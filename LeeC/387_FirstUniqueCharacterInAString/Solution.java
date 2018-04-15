


class Solution {
    
    public int firstUniqChar(String s) {
	System.out.println("s = " + s);

        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++) freq [s.charAt(i) - 'a'] ++;

	for(int i=0; i<freq.length; i++)
	    System.out.print((char)(i+97) + "  ");
	System.out.println();

	for(int i=0; i<freq.length; i++)
	    System.out.print(freq[i] + "  ");
	System.out.println();

        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1){
	        System.out.println("return " + i + ";\n");
                return i;
	    }
        return -1;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	String s = new String("leetcode");
	s1.firstUniqChar(s);
	
	s = new String("loveleetcode");
	s1.firstUniqChar(s);

    }
    
}



