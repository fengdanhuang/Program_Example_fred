
import java.util.*;


public class HitCounter {
    
        Queue<Integer> q = null;
    
        /** Initialize your data structure here. */
        public HitCounter() {
            q = new LinkedList<Integer>();
        }
        
        /** Record a hit.
            @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            q.offer(timestamp);
	    System.out.println("q = " + q);
        }
        
        /** Return the number of hits in the past 5 minutes.
            @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            while(!q.isEmpty() && timestamp - q.peek() >= 300) {
                q.poll();
            }
	    System.out.println("q.size() = " + q.size());
            return q.size();
        }
    
	public static void main(String args[]){
	    
	    HitCounter h1 = new HitCounter();
		
	    h1.hit(1);
	    h1.hit(2);
	    h1.hit(3);
	    h1.getHits(4);
	    h1.hit(300);
	    h1.getHits(300);
	    h1.getHits(301);

	}
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
