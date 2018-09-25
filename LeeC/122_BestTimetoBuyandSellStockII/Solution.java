


class Solution {
    
    public int maxProfit(int[] prices) {
       
        for(int i=0; i<prices.length; i++)
            System.out.print(prices[i] + "  ");
        System.out.println();
 
        int maxprofit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            
            if (prices[i] > prices[i - 1]){
                
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        
        System.out.println("maxprofit = " + maxprofit + "\n");
        return maxprofit;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        int[] prices = new int[]{1,2,3,4,5};
        s.maxProfit(prices);

        prices = new int[]{7,6,4,3,1};
        s.maxProfit(prices);
       
    }
}
