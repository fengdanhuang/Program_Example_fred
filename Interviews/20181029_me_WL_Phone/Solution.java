
/*
Interviewer: MS
Interview Result: DOWN


Question:
Find the number of minimum steps to traverse all the coordinates passed in a list.
can move in all 8 directions:
X[] = [0,1,1], Y[] = [0,1,2]
(0,0), (1,1), (1,2) -> 2 steps

(x, y) to
  
 (x+1, y),
 (x-1, y),
 (x, y+1),
 (x, y-1),
 (x-1, y-1),
 (x+1, y+1),
 (x-1, y+1),
 (x+1, y-1)

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

    public int minSteps(int[] X, int[] Y){
        int re = 0;
        for(int i=0; i<X.length-1; i++){
            re += subMinSteps(X[i], Y[i], X[i+1], Y[i+1]);
        }
        return re;
    }

    public int subMinSteps(int x1, int y1, int x2, int y2){

        //int subMS;

        if (Math.abs(x2-x1) <=1 && Math.abs(y2-y1) <= 1) subMS = 1;
        else{
            subMS = subMinSteps(x1+1, y1+1, x2, y2) + 1;
            subMS = subMinSteps(x1-1, y1+1, x2, y2) + 1;
            //...
        }
        return subMS;
    }
    
    public static void main(String[] args){
        int[] X = new int[]{0, 1, 1};
        int[] Y = new int[]{0, 1, 2};
        Solution s = new Solution();
        s.minSteps(X, Y);
        
        X = new int[]{0, 2, 9, 10};
        Y = new int[]{-2, -4, 5, 7};
        s.minSteps(X, Y);   
    }
}       
