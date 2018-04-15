


class Solution{

    public boolean canWin(String s) {
	System.out.println();
       	System.out.println("s = " + s);
	 
        if (s == null || s.length() < 2) {
            return false;
        }
    
        for (int i = 0; i < s.length() - 1; i++) {
	    System.out.println("    i = " + i);       
	 
            if (s.startsWith("++", i)) {
                System.out.println("    s.substring(0,i) = " + s.substring(0,i));
		System.out.println("    s.substring(i+2) = " + s.substring(i+2));
		String t = s.substring(0, i) + "--" + s.substring(i + 2);
      
                if (!canWin(t)) {
                    return true;
                }
            }
        }
    
        return false;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	String s = new String("++++");
	s1.canWin(s);

    }
}
