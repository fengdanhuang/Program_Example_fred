
/*
Interviewer: ML (Indian Woman)
Interview Result: DOWN

Question 1:
Input:  A method getRandom01Uniform() that generates a random integer in [0, 1], where 0 and 1 are generated with uniform probability
Output: A method getRandom06Uniform() that generates a random integer in [0, 6] with uniform probability 

000 0
001 1
010 2
011 3
100 4
101 5
110 6

getRandom01Uniform()*2^2 + getRandom01Uniform()*2^1 + getRandom01Uniform()*2^0

0.5*0.5*0.5  0

while ouput == 7: 
  getRandom01Uniform()*2^2 + getRandom01Uniform()*2^1 + getRandom01Uniform()*2^0
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Solution{


    public int getRandom06(){
        int[] re =  new int[]{-1};
        getRandom06Uniform(re);
        return re[0];
    }

    public void getRandom06Uniform(int[] re){
        re[0] = getRandom01Uniform()*4 + getRandom01Uniform()*2 + getRandom01Uniform();
        System.out.println("  Generated random numbner == " + re[0]);
        if(re[0] == 7){
            System.out.println("  Generated random number == " + re[0] +", start to do recursion.");
            getRandom06Uniform(re);   
        }
        //return re;
    }
    
    public int getRandom01Uniform(){
        Random random = new Random();
        int re = random.nextInt(2);
        System.out.println("random 01 = " + re);
        return re;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        int re = so.getRandom06();
        System.out.println("The genenrated random number is: " + re);
 

    }
}

