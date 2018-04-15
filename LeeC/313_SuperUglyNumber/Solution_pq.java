
import java.util.*;

class Solution_pq{

    public int nthSuperUglyNumber(int n, int[] primes){
        int[] res = new int[n];
	res[0] = 1;

	
        PriorityQueue<Num> pq = new PriorityQueue<>((a,b) -> (a.val-b.val));
        for(int i=0; i<primes.length; i++){
            pq.add(new Num(primes[i], 1, primes[i]));
        }

	System.out.println("pq = " + pq);
        for(int i=1; i<n; i++){
            res[i] = pq.peek().val;
            while(pq.peek().val == res[i]){
                Num next = pq.poll();
                pq.add(new Num(next.prime * res[next.index], next.index+1, next.prime));
            }
         }

         return res[n-1]; 
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[] primes = new int[]{2, 7, 13, 19};
	int n = 4;
	s1.nthSuperUglyNumber(n, primes);


    }


    class Num{
        int val;
        int index;
        int prime;

	public Num(int val, int index, int prime){
            this.val = val;
            this.index = index;
            this.prime = prime;
	}
    }
}
