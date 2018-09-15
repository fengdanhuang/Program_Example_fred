


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        lr = []
        for element in nums:
            if (target-element) in nums:
              
                lr.append(nums.index(element))
                lr.append(nums.index(target-element))
                print "lr = ", lr
                return lr
        return null


nums = [2,7,11,15]
target = 9

s = Solution();
s.twoSum(nums, target)
