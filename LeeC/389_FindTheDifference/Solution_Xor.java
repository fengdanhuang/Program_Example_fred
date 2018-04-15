


class Solution_Xor {

    public char findTheDifference(String s, String t) {
        System.out.println("s = " + s);
	System.out.println("t = " + t);

	char c = t.charAt(t.length()-1);
        System.out.println("c = " + c);
	for(int i=0; i<s.length(); i++){
            c ^= s.charAt(i);
            System.out.println("    c = " + c);
            c ^= t.charAt(i);    
            System.out.println("    c = " + c);
        }
        System.out.println("c = " + c + "\n");
        return c;
    }

    public static void main(String args[]){
	Solution_Xor s1 = new Solution_Xor();

	String s = new String("abcd");
	String t = new String("abcde");
	s1.findTheDifference(s, t);

	s = new String("abcd");
	t = new String("badec");
	s1.findTheDifference(s, t);
	

    }
}
