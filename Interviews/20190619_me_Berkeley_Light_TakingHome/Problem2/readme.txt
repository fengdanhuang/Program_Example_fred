

-----------------------------
Implementation
Since there is no clear regulation about letter and digits in the questions, we will make the following assumptions in my implementation:
Assumption1. The lower case letters a to z is interchangable with 1 to 26.
Assumption2. For any of version, if the index get to z, the z+1 would be 27.
Assumption3. For any of version, if it uses letter, we will keep use letter. If it uses digits, we will keep use digits, unless we hit 'z'.


-----------------------------
Answer the questions in Problem2.
1. What are the edge cases that need to be considered?
Answer: The following edge cases are what we consider, mainly for z and b
1. IncrementVersion("1.2.3.z", 3) -> 1.2.3.27
2. IncrementVersion("1.2.z.b", 2) -> 1.2.27.0
3. IncrementVersion("1.z.z.b", 1) -> 1.27.0.0
4. IncrementVersion("z.z.z.z", 0) -> 27.0.0.0

2. How would you test it?
Answer: we will write unit test functions to test all these edge cases one by one. These unit test cases are written into main function.

-----------------------------

The way to execute:

python incremental_version.py 

