


class Solution:
    
    def merge(self, nums1, m, nums2, n):
    
        while m > 0 and n > 0:
            
            if nums1[m-1] >= nums2[n-1]:
                
                nums1[m+n-1] = nums1[m-1]
                m -= 1
                
            else:
                
                nums1[m+n-1] = nums2[n-1]
                n -= 1
                
        if n > 0:
            nums1[:n] = nums2[:n]

num1 = [1,2,3]
num2 = [5,2,3,7]


s1 = Solution()
s1.merge(num1,len(num1),num2,len(num2))

