
import java.util.*;


class Solution {
   
    public int[][] reconstructQueue(int[][] people) {
        for (int i=0; i<people.length; i++)
	    for (int j=0; j<people[0].length; j++)
		System.out.print(people[i][j] + "   ");
	System.out.println();
	 
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        
        List<int[]> res = new LinkedList<>();
        
        for(int[] cur : people){
            res.add(cur[1],cur);       
        }
        
        int P[][] = res.toArray(new int[people.length][]);
        for (int i=0; i<P.length; i++)
	    for (int j=0; j<P[0].length; j++)
		System.out.print(P[i][j] + "   ");
	System.out.println();
	return P;
	
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	int[][] people = new int [][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
	s1.reconstructQueue(people);


    }

}
