



class Solution{

    public int numWays(int n, int k) {
        System.out.println("n = " + n + ",  k = " + k);

	int re;	
 
        if(n == 0) return 0;        
        else if(n == 1) return k;
        
        int diffColorCounts = k*(k-1);
        
        int sameColorCounts = k;
        
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        
        re = diffColorCounts + sameColorCounts;
    	System.out.println("re = " + re);
	return re;
    }
    
    public static void main(String args[]){
	Solution s1 = new Solution();

	s1.numWays(10, 3);
	s1.numWays(3, 3);
	s1.numWays(3,10);
	

    }
}
