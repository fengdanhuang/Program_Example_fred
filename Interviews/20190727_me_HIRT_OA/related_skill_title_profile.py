import nltk
import json
import heapq 
from heapq import nsmallest

# Load the json data into a dictionary
with open('talent_profiles_20k.json', 'r') as infile:
    data_dict = json.load(infile)

# Get all skill set in the dataset
skill_set = set()
for key in data_dict.keys():
    skill_set = skill_set.union(set(data_dict[key]['basic']['skill']))

#Input skill data. Transfer the list into a set.
input_skill = ['Marketing Strategy', 'Account Management', 'business development']
print ("    The input skills are:")
print ("    ", input_skill)
input_skill_set = set(input_skill)

#Use the dictionary skill_dict to store all skill and its minimal Levenshtein distance.

skill_dict = {}
for skill in skill_set:
    min_dist = []
    for input_skill in input_skill_set:
        dist = nltk.edit_distance(skill, input_skill)
        min_dist.append(dist)
    skill_dict[skill] = min(min_dist) 
#Use heapq to output the keys(skill) with top 10 smallest levenshten distance
ten_smallest = nsmallest(10, skill_dict, key = skill_dict.get)
print ("    10 most relavant skills are = ", ten_smallest)
print ("---------------------------------------------------")

#Input skill data. Transfer the list into a set.
input_title = ['HR Supervisor', 'data analyst', 'Senior Software Developer']
print ("    The input titles are: ")
print ("    ", input_title)
input_title_set = set(input_title)

# Get all title set in the dataset
title_list = []
for key in data_dict.keys():
    if 'title' in data_dict[key]['basic']:
        title_list.append(data_dict[key]['basic']['current_title'])
#print (title_list)

#Use the dictionary title_dict to store all title and its minimal Levenshtein distance.
title_dict = {}
for title in title_list:
    min_dist = []
    for input_title in input_title_set:
        #print (title, ",", input_title)
        if title is not None:
            dist = nltk.edit_distance(title, input_title)
            min_dist.append(dist)
    if min_dist:
        title_dict[title] = min(min_dist) 
#Use heapq to output the keys(title) with top 10 smallest levenshten distance
ten_smallest_title = nsmallest(10, title_dict, key = title_dict.get)
print ("    10 most relavant titles are = ", ten_smallest_title)
