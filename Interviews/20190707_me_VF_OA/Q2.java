import java.util.*;


public class Q2 {
    //Use greedy algorithm, each time pick up the smallest item.
    public int solution(int[] arr) {
        int maxW = 5000 - arr[0];
        int cnt = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-1; i++) {
            if (maxW - arr[i] > 0) {
                cnt++;
                maxW -= arr[i];
            }else break;
        }
        System.out.println("maxW = " + maxW);
        return cnt;
    }
   
    public void pr(int[] arr){
        for(int i=0; i<arr.length; i++)
           System.out.print(arr[i] + " ");
        System.out.println();
    } 
    public static void main(String args[]){
        Q2 q = new Q2();
        
	int[] arr = new int[]{4650, 150, 150, 150};  
        q.pr(arr);
        System.out.println(q.solution(arr));
        
	arr = new int[]{4850, 100, 30, 30, 100, 50, 100};  
        q.pr(arr);
        System.out.println(q.solution(arr));
	
	arr = new int[]{10, 100, 30, 30, 100, 50, 100};  
        q.pr(arr);
        System.out.println(q.solution(arr));
    }
}
