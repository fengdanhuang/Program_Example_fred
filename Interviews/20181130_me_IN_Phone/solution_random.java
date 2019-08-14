Input:
A method getRandom01Uniform() that generates a random integer in [0, 1], where 0 and 1 are generated with uniform probability
Output:
A method getRandom06Uniform() that generates a random integer in [0, 6] with uniform probability 

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

class Solution{

    public int getRandom06Uniform(){

        int re;

        re = getRandom01Uniform()*4 + getRandom01Uniform()*2 + getRandom01Uniform()

        if(re == 7){
            getRandom06Uniform();   
        }

        return re;

    }
}

biased coin
toss N times
get heads k times
What is the MLE of the bias?

beta

L = beta^k(1-beta)^(N-k)
lnL = 
p(k)=p^k

p(k)=p(k|N)* p(N) 

Accrary = Sigma(y-y')^2