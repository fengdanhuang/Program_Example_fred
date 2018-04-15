

class Solution:
    
    # @return a list of strings, [s1, s2]
    def letterCombinations(self, digits):
        
        if '' == digits: return []
        
        kvmaps = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        
        Output = reduce(lambda acc, digit: [x + y for x in acc for y in kvmaps[digit]], digits, [''])
        print "Output = \n", Output
	return Output


s1 = Solution()

Input="2"
print "Input = ", Input
s1.letterCombinations(Input)

Input="3"
print "Input = ", Input
s1.letterCombinations(Input)

Input="23"
print "Input = ", Input
s1.letterCombinations(Input)


Input="45"
print "Input = ", Input
s1.letterCombinations(Input)


Input="234"
print "Input = ", Input
s1.letterCombinations(Input)


Input="2345"
print "Input = ", Input
s1.letterCombinations(Input)


Input="12345"
print "Input = ", Input
s1.letterCombinations(Input)



