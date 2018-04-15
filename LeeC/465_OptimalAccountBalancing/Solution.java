
import java.util.*;

class Solution {
    
    public int minTransfers(int[][] transactions) {
        for(int i=0; i<transactions.length; i++){
	    for(int j=0; j<transactions[0].length; j++){
		System.out.print(transactions[i][j] + "  ");
	    }
	    System.out.println();
	}


        if(transactions == null || transactions.length == 0) return 0;
        
	Map<Integer, Integer> acc = new HashMap<>();
        
	for(int i = 0;i<transactions.length;i++){
            int id1 = transactions[i][0];
            int id2 = transactions[i][1];
            int m = transactions[i][2];
            acc.put(id1, acc.getOrDefault(id1, 0)-m);
            acc.put(id2, acc.getOrDefault(id2, 0)+m);
        }
	System.out.println("acc = " + acc);
        
	List<Integer> negs = new ArrayList<>();
        List<Integer> poss = new ArrayList<>();
        
	for(Integer key:acc.keySet()){
            int m = acc.get(key);
            if(m == 0) continue;
            if(m<0) negs.add(-m);
            else poss.add(m);
        }
	System.out.println("negs = " + negs);
	System.out.println("poss = " + poss);
        
	int ans = Integer.MAX_VALUE;
        
	Stack<Integer> stNeg = new Stack<>(), stPos = new Stack<>();
        
	for(int i =0;i<1000;i++){
            for(Integer num:negs) stNeg.push(num);
            for(Integer num:poss) stPos.push(num);
            int cur = 0;
            while(!stNeg.isEmpty()){
                int n = stNeg.pop();
                int p = stPos.pop();
                cur++;
                if(n == p) continue;
                if(n>p){
                    stNeg.push(n-p);
                } else {
                    stPos.push(p-n);
                }
            }
            ans = Math.min(ans, cur);
            Collections.shuffle(negs);
            Collections.shuffle(poss);
        }
	System.out.println("stNeg = " + stNeg);
	System.out.println("stPos = " + stPos);

	System.out.println("ans = " + ans);
        return ans;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	int[][] transactions = new int[][]{{0,1,10},{1,0,1},{1,2,5},{2,0,5}};
	s1.minTransfers(transactions);
    }    
}
