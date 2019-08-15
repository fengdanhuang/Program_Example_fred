
/*
Interviewer: MF (American White)
Interview Result: DOWN


Question: Best Average Grade

Given a list of student test scores, find the best average grade.
Each student may have more than once test score in the list.

Complete the bestAverageGrade function in the editor below.
It has one parameter, scores, which an array of student test scores.
Each element in the array is a two-element array of the form [student name, test score]
e.g. [ "Bobby", "87" ].
Test scores may be posistive or negative integers.

If you end up with an average grade that is not an integer, you should
use a floor function to return the largest integer less than or equal to the average.
Return 0 for an empty input.

Example:

Input:
[["Bobby", "87"],
 ["Charles", "100"],
 ["Eric", "64"],
 ["Charles", "22"]].

Expected output: 87
Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric, respectively. 
87 is the highest.
*/

class Solution {

    public static Double bestAverageGrade(String[][] scores){
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();


