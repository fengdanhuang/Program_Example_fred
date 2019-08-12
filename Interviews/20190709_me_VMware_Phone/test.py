import json

'''
Given name, output all numbers.
Given address, output all numbers
'''
data = """{\"Tom\":[{\"123\":\"D1\"}, {\"235\":\"D2\"}], \"Bob\":[{\"234\":\"D3\"}, {\"537\":\"D4\"}], \"Cindy\":[{\"345\":\"D5\"}]}"""
#data = """{\"Tom\":\"123\"}"""
print type(data)
dict = json.loads(data);
print type(dict)
'''
dict = {'Tom':[{'123':'D1'}, {'235':'D2'}], 'Bob':[{'234':'D3'},{'537':'D4'}], 'Cindy':[{'345':'D5'}]}
print dict['Tom']
'''


#def find_number_by_name(name, dict):
    


print dict

for key in dict: 
    print key
    print dict[key]
    for l in dict[key]:
        for k in l: print k
    '''
    for l in dict[name]:
        print l
    '''


