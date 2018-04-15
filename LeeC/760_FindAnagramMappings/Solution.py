


class Solution(object):
    def anagramMappings(self, A, B):
        print "A = ", A
	print "B = ", B

        dict_index={}
        P=[]
        for index in range(len(B)):
	    print "    index = ", index
            if B[index] not in dict_index:
                dict_index[B[index]]=[]
                dict_index[B[index]].append(index)
            else:
                dict_index[B[index]].append(index)
        for index in range(len(A)):
	    print "    index = ", index
            if A[index] in dict_index:
                P.append(dict_index[A[index]].pop())
	print "P = ", P
        return P     

s1 = Solution()
A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
s1.anagramMappings(A,B)
