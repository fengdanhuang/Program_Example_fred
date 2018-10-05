



class Solution {
    public int climbStairs(int n) {
        
        System.out.println("n = " + n);
 
        if(n == 1){
            return 1;
        }
        
        if(n == 2){
            return 2;
        }
        
        int[] memo = new int[n];
        
        memo[0] = 1;
        memo[1] = 2;
        
        for(int i = 2; i < n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        System.out.println("memo[n-1] = " + memo[n-1] + "\n");
        
        return memo[n-1];

    }

    public static void main(String args[]){
        Solution sol = new Solution();


        int n = 2;
        sol.climbStairs(n);
 
        n = 3;
        sol.climbStairs(n);

        n = 4;
        sol.climbStairs(n);

        n = 5;
        sol.climbStairs(n);
    }
}
