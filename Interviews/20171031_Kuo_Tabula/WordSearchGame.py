
#python version requirement: 2.7.x (Suggest:2.7.9)

#import python lib:
import sys
import os
import json


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


# use DFS to search which word occurs in the board
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
                index = DFS_helper(word,gameBoard,0,r,c,visited) #index represents the longest distance in the tile from [r,c]
    
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
        #       print index
                r = index[0]
                c = index[1]
                letter = gameBoard[r][c]
                #print letter
        #       FinalList.append(BFS(r,c,letter,gameBoard,contains))
                FinalList.append(DFS(r,c,letter,gameBoard,contains))
        #print FinalList
        return FinalList


def Search(wordList,gameBoard):
        contain = {}  # key:first letter in each word in wordList,  value:words with the same first letter in wordList
        FirstLetterIndex = {}  # key: first letter of a word,   value:list of index of where the letter appears in the board 
        finalList = [] # list contains all words apppears in the gameboard

        for word in wordList:
                if word[0] in contain:
                        contain[word[0]].append(word)
                else:
                        contain[word[0]] = [word]
        #print contain

        contain_key = contain.keys()  # at most 26 keys
        for i in range(len(gameBoard)):
                for j in range(len(gameBoard[0])):
                        temp_letter = gameBoard[i][j]
                        if temp_letter in FirstLetterIndex:
                                FirstLetterIndex[temp_letter].append([i,j])
                        else:
                                if temp_letter in contain_key:
                                        FirstLetterIndex[temp_letter] = [[i,j]]
        #print(FirstLetterIndex)

        for letter in contain:
                # print FirstLetterIndex[letter]
                 words = SearchWords(contain,gameBoard,FirstLetterIndex[letter])
                 for word in words:
                        finalList.append(word)
#       print finalList
        return finalList

def CalPointValuePerWord(word,letterPoints):
	totalPoint = 0
	for ic in word:
		if ic in letterPoints:
			totalPoint = totalPoint + letterPoints[ic]
		else:
			totalPoint = totalPoint + 1
	#print word, ", totalPoint = ", totalPoint
	return totalPoint

def Test_CalPointValuePerWord():
	#Test Point Value calculation
	CalPointValuePerWord('car', letterPoints)
	CalPointValuePerWord('card', letterPoints)
	CalPointValuePerWord('cards', letterPoints)
	CalPointValuePerWord('drag', letterPoints)
	CalPointValuePerWord('drags', letterPoints)
	CalPointValuePerWord('sad', letterPoints)


def CalTimePerWord(word, wordFindTime, letterIdentifyTime):
	wordTime = wordFindTime + (len(word)-1)*letterIdentifyTime
	#print word, ", wordTime = ", wordTime
	return wordTime

def Test_CalTimePerWord():
	CalTimePerWord('car', wordFindTime, letterIdentifyTime)
	CalTimePerWord('card', wordFindTime, letterIdentifyTime)
	CalTimePerWord('cards', wordFindTime, letterIdentifyTime)
	CalTimePerWord('drag', wordFindTime, letterIdentifyTime)
	CalTimePerWord('drags', wordFindTime, letterIdentifyTime)
	CalTimePerWord('sad', wordFindTime, letterIdentifyTime)


def CalMaxScore(wordList, letterPoints, wordFindTime, letterIdentifyTime, maxGameTime):
	timeList = [CalTimePerWord(w, wordFindTime, letterIdentifyTime) for w in wordList]#time calculated for each word
	#print "timeList = ", timeList
	pointList = [CalPointValuePerWord(w, letterPoints) for w in wordList]#points calculated for each word
	#print "pointList = ", pointList
	Points = [[0 for j in range(maxGameTime+1)] for j in range(len(wordList)+1)]
	#print "Points = ", Points
	for i in range(1, len(wordList)+1):
		for j in range(1, maxGameTime+1):	
			if timeList[i-1] > j:
				Points[i][j] = Points[i-1][j]
			else:
				Points[i][j] = max(Points[i-1][j], pointList[i-1]+Points[i-1][j-timeList[i-1]])
	#print "Points[len(wordList)][maxGameTime] = ", Points[len(wordList)][maxGameTime]
	return Points[len(wordList)][maxGameTime]	



##---Process Argument
paraLimit = 1
if len(sys.argv) != paraLimit:
	print  "\n       Usage:  cat input.json | python " + sys.argv[0] + " | diff answer.txt -  \n"
	sys.exit(0)

NOfPara = len(sys.argv)
program = sys.argv[0]

f1=open('./log.txt', 'w+')
#f1=sys.stdout
print >> f1, "\nThe number of arguments are: ", NOfPara
print >> f1, "The program is: ", program

##---read the json raw data
data = json.load(sys.stdin)
print >> f1
print >> f1, "data = ",data
print >> f1, "type(data) = ", type(data)


##---read all the numbers
rowCount = int(data['rowCount'])
if rowCount < 1 or rowCount > 1000:
	print >> f1, "Illegal rowCount!\n"
	sys.exit(1)
columnCount = int(data['columnCount'])
if columnCount <1 or columnCount > 1000:
	print >> f1, "Illegal columnCount!\n"
	sys.exit(1)
gameBoard = [[str(x).lower() for x in y] for y in data['gameBoard']]
wordList = [str(x).lower() for x in data['wordList']]
wordSet = set(wordList)
wordList = list(wordSet)
letterPoints = dict([(str(k), v) for k, v in data['letterPoints'].items()])
wordFindTime = int(data['wordFindTime'])
letterIdentifyTime = int(data['letterIdentifyTime'])
maxGameTime = int(data['maxGameTime'])

print >> f1
print >> f1, "rowCount = ", rowCount
print >> f1, "columnCount = ", columnCount
print >> f1, "gameBoard = ", gameBoard
print >> f1, "type(gameBoard) = ", type(gameBoard)
print >> f1, "wordList = ", wordList
print >> f1, "letterPoints = ", letterPoints
print >> f1, "wordFindTime = ", wordFindTime
print >> f1, "letterIdentifyTime = ", letterIdentifyTime
print >> f1, "maxGameTime = ", maxGameTime

#Test Point calculation
#Test_CalPointValuePerWord()
#Test Time calculation
#Test_CalTimePerWord()

Final = Search(wordList,gameBoard)
FinalList = []
for list1 in Final:
        for list2 in list1:
                FinalList.append(list2)

FinalList.sort()
#print "FinalList = ", FinalList
maxPoints = CalMaxScore(FinalList, letterPoints, wordFindTime, letterIdentifyTime, maxGameTime)
#print "maxPoints = ", maxPoints
for w in FinalList:
	print w
print maxPoints
