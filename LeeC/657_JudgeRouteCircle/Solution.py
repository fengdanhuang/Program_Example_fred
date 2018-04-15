

class Solution(object):
    def judgeCircle(self, moves):
        print "moves = ", moves
        re = moves.count('L') == moves.count('R') and moves.count('U') == moves.count('D')
	print "re = ", re, "\n"
	return re

s1 = Solution()
moves = "UD"
s1.judgeCircle(moves)
moves = "LL"
s1.judgeCircle(moves)

