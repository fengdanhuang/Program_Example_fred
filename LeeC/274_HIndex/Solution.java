


class Solution {
    
    public int hIndex(int[] citations) {
	    for(int i=0; i<citations.length; i++)
	        System.out.print(citations[i] + "  ");
	    System.out.println();       
 
	    int L = citations.length;
        
	    if(L<1) return 0;
        
	    int[] counts = new int[L+1];
        
	    for(int i : citations) {
		    if(i>L) counts[L]++;
		    else counts[i]++;
	    }
        
	    int res = 0;
	    for(int k=L; k>=0; k--) {
	        res += counts[k];
	        if(res>=k) return k;
	    }
	    return 0;
    }
   
    public static void main(String args[]){
            
	    Solution s1 = new Solution();
            
            int[] citations = new int[]{3, 0, 6, 1, 5};

	    s1.hIndex(citations);
	
    }

    
}
