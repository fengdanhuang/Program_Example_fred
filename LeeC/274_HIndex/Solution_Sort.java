
import java.util.*;


class Solution_Sort {
    
    public int hIndex(int[] citations) {
	for(int i=0; i<citations.length; i++)
	    System.out.print(citations[i] + "  ");
	System.out.println();	

        Arrays.sort(citations);
        int re = 0;
        while(re<citations.length && citations[citations.length-1-re]>re){
            re ++;
        }
	System.out.println("re = " + re);
        return re;
    }

    public static void main(String args[]){
	Solution_Sort ss = new Solution_Sort();
	
	int[] citations = new int[]{3, 0, 6, 1, 5};
	ss.hIndex(citations);

    }

}
