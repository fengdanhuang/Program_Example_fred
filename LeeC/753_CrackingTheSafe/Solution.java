


class Solution {

    public String crackSafe(int n, int k) {
	System.out.println("\nn = " + n);
	System.out.println("k = " + k);

        int M = (int) Math.pow(k, n-1);
	System.out.println("M = " + M);
        
	int[] P = new int[M * k];

	for (int i = 0; i < k; ++i)
            for (int q = 0; q < M; ++q)
                P[i*M + q] = q*k + i;

        StringBuilder ans = new StringBuilder();
        
	for (int i = 0; i < M*k; ++i) {
            int j = i;
            while (P[j] >= 0) {
                ans.append(String.valueOf(j / M));
                int v = P[j];
                P[j] = -1;
                j = v;
            }
        }

        for (int i = 0; i < n-1; ++i)
            ans.append("0");
	
	String s = new String(ans);
        System.out.println("s = " + s + "\n");
	return s;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int n = 1;
	int k = 2;
	s1.crackSafe(n, k);

	n = 2;
	k = 2;
	s1.crackSafe(n, k);	

    }
}
