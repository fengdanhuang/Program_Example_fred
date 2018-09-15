


class Solution {
    
    public int maxProfit(int[] prices) {
        for(int i=0; i<prices.length; i++)
            System.out.print(prices[i] + "  ");
        System.out.println();       
 
        int minSoFar = Integer.MAX_VALUE;
        System.out.println("minSoFar = " + minSoFar);       
 
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            
            minSoFar = Math.min(minSoFar, prices[i]);
            
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            System.out.println("i = " + i);
            System.out.println("    minSoFar = " + minSoFar);       
            System.out.println("    maxProfit = " + maxProfit);       
            
        }
        
        System.out.println("maxProfit = " + maxProfit + "\n"); 
        return maxProfit;
    }


    public static void main(String args[]){
        Solution s = new Solution();

        int[] prices = new int[]{7,1,5,3,6,4};
        s.maxProfit(prices);

        prices = new int[]{7,6,4,3,1};
        s.maxProfit(prices);
    }
    
}
