


class Solution {
    
    public int maxProfit(int[] prices) {
   	for(int i=0; i<prices.length; i++)
	    System.out.print(prices[i] + "  ");
	System.out.println();
	 
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }

	System.out.println("sell = " + sell);
        return sell;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] prices = new int[]{1, 2, 3, 0, 2};
	s1.maxProfit(prices);

    }    
}
