
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

class Solution{

    public int getRandom06Uniform(){
        int re = getRandom01Uniform()*4 + getRandom01Uniform()*2 + getRandom01Uniform();
        if(re == 7){
            getRandom06Uniform();   
        }
        return re;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        so.getRandom06Uniform();
 

    }
}

