




class Solution(object):
    def maxProfit(self, prices):
	for p in prices:
	    print p,
	print 

        if len(prices) < 2:
            return 0
        sell, buy, prev_sell, prev_buy = 0, -prices[0], 0, 0
        for price in prices:
            prev_buy = buy
            buy = max(prev_sell - price, prev_buy)
            prev_sell = sell
            sell = max(prev_buy + price, prev_sell)
        print "sell = ", sell, "\n"
	return sell
        

s1 = Solution()

prices = [1, 2, 3, 0, 2]
s1.maxProfit(prices)
