


class Solution {
    
    public int repeatedStringMatch(String A, String B) {
      	System.out.println("A = " + A);
	System.out.println("B = " + B); 
	 
        int q = 1;
        
        StringBuilder S = new StringBuilder(A);
        System.out.println("S = " + S);
        
	for (; S.length() < B.length(); q++) 
		S.append(A);
        System.out.println("S = " + S);
       
	System.out.println("S.indexOf(B) = " + S.indexOf(B)); 
	System.out.println("S.append(A).indexOf(B) = " + S.append(A).indexOf(B)); 
	System.out.println("q = " + q + "\n");	
	
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	String A = new String("abcd");
	String B = new String("abcdabcdabcd");
	s1.repeatedStringMatch(A, B);

	A = new String("abcd");
	B = new String("cdabcdab");
	s1.repeatedStringMatch(A, B);
	

    }
    
}
