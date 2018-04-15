


class Solution {
    
    public String licenseKeyFormatting(String S, int K) {
	System.out.println("S = " + S);
    
        S = S.replaceAll("[-]", "");
	System.out.println("S = " + S);
    
        S = S.toUpperCase();
	System.out.println("S = " + S);

        StringBuilder sb = new StringBuilder();
    
        sb.append(S);
	System.out.println("sb = " + sb);

	System.out.println("sb.length() = " + sb.length());
	System.out.println("K = " + K);	
        
	int i=sb.length()-K;
    	System.out.println("i = " + i);

        while(i>0) {
            sb.insert(i, '-');
	    System.out.println("    sb = " + sb);
	    
            i = i-K;
    	    System.out.println("    i = " + i);
        }

	System.out.println("sb.toString() = " + sb.toString() + "\n");
        return sb.toString();
    }

    public static void main(String args[]){

	Solution s1 = new Solution();

	String S = new String("5F3Z-2e-9-w");
	int K = 4;
	s1.licenseKeyFormatting(S,K);

	S = new String("2-5g-3-J");
	K = 2;
	s1.licenseKeyFormatting(S,K);
    }

}
