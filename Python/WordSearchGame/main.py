import sys

class Queue:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.insert(0,item)

    def dequeue(self):
        return self.items.pop()

    def size(self):
        return len(self.items)

# use BFS to search which word occurs in the board

def DFS(r,c,letter,gameBoard,contains):
	wordList = []
	words = contains[letter]
	height = len(gameBoard)
	width = len(gameBoard[0])
	visited = [[0 for x in range(height)] for y in range(width)]
	for word in words:
		for i in range(height):
			for j in range(width):
				#print i
				visited[i][j] = False	
		index = DFS_helper(word,gameBoard,0,r,c,visited)
		
		#print word,index
		if index == len(word):
			wordList.append(word)
	#print wordList
	return wordList
	


	
def DFS_helper(word,gameBoard,index,r,c,visited):
	#print word,index
	if index>=len(word):
		return 0
	if r<0 or r>=len(gameBoard) or c<0 or c>=len(gameBoard[0]) or visited[r][c]:
		return 0 

	
	
	#print r,c,gameBoard[r][c]
	if word[index]==gameBoard[r][c]:
		one = DFS_helper(word,gameBoard,index+1,r+1,c+1,visited)
		two = DFS_helper(word,gameBoard,index+1,r,c+1,visited)
		three = DFS_helper(word,gameBoard,index+1,r-1,c+1,visited)
		four = DFS_helper(word,gameBoard,index+1,r-1,c,visited)
		five = DFS_helper(word,gameBoard,index+1,r+1,c,visited)
		six = DFS_helper(word,gameBoard,index+1,r+1,c-1,visited)
		seven = DFS_helper(word,gameBoard,index+1,r,c-1,visited)
		eight = DFS_helper(word,gameBoard,index+1,r-1,c-1,visited)
		visited[r][c] = True	
		return 1+max(max(max(max(max(max(max(one,two),three),four),five),six),seven),eight)
	return 0;


# search all word in the list with the same starting letter
def SearchWords(contains,gameBoard,indices):
	FinalList = []
	for index in indices:
	#	print index
		r = index[0]
		c = index[1]
		letter = gameBoard[r][c]	
		#print letter
	#	FinalList.append(BFS(r,c,letter,gameBoard,contains))
		FinalList.append(DFS(r,c,letter,gameBoard,contains))
	#print FinalList
	return FinalList


def Search(wordList,gameBoard):
	contain = {}  # key:first letter in each word in wordList,  value:words with the same first letter in wordList
	FirstLetterIndex = {}  # key: first letter of a word,   value:list of index of where the letter appears in the board 
	finalList = [] # list contains all words apppears in the gameboard
	
	i = 0
	for word in wordList:
		word = word.lower()
		if word[0] in contain:
			contain[word[0]].append(word)	
		else:
			contain[word[0]] = [word]
	#print contain
	
	contain_key = contain.keys()  # at most 26 keys
	for i in range(len(gameBoard)):
		for j in range(len(gameBoard[0])):
			gameBoard[i][j] = gameBoard[i][j].lower()
			temp_letter = gameBoard[i][j]
			if temp_letter in FirstLetterIndex:
				FirstLetterIndex[temp_letter].append([i,j])
			else:
				if temp_letter in contain_key:
					#print "haha"
					FirstLetterIndex[temp_letter] = [[i,j]]
	
	#contain:{'a':[actor,actress,act],'b':[boy,bad]}
	#FirstLetterIndex : {'a':[[0,1],[2,2]],'b':[[3,3][10,10]]}
	
	#print(FirstLetterIndex)
	for letter in contain:
		# print FirstLetterIndex[letter]
		 words = SearchWords(contain,gameBoard,FirstLetterIndex[letter])
		 for word in words:
		 	finalList.append(word)
#	print finalList
	return finalList	


letterPoints ={
"a":2,
"e":2,
"i":2,
"o":2,
"u":2,
"y":2
}

wordList = [
"air", "car", "card", "cards",
"drag", "drags", "sad", "sadden",
"Sin", "snail", "zig"
]

gameBoard= [
[ "C", "G", "S" ],
[ "N", "A", "D" ],
[ "I", "Z", "R" ]
]

visited = [[0 for x in range(3)] for y in range(3)]
	
for i in range(3):
	for j in range(3):
				#print i
		visited[i][j] = False	


Final = Search(wordList,gameBoard)
FinalList = []
for list1 in Final:
	for list2 in list1:
		FinalList.append(list2)
		
FinalList.sort()
print FinalList
	
