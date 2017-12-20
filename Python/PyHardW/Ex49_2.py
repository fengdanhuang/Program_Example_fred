def  match(word_list ,  expecting):
	if  word_list:
		word  =  word_list.pop(0)

		if  word[0]  ==  expecting:
			return  word
		else:
			return  None
	else:
		return  None