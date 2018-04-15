
import java.util.*;

class MedianFinder {

    private Queue<Long> small = new PriorityQueue<>(),
                        large = new PriorityQueue<>();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
	System.out.println("large = " + large);
	System.out.println("small = " + small);
    }

    public double findMedian() {
	double re;	
	if (large.size() > small.size()){
		re = large.peek();
	}else{
		re = (large.peek()-small.peek()) / 2.0;
		
	}
	System.out.println("re = " + re);
	return re;
    }

    public static void main(String args[]){
	MedianFinder mf = new MedianFinder();

	mf.addNum(1);
	mf.addNum(2);
	mf.findMedian();
	mf.addNum(3); 
	mf.findMedian(); 
    }
    
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
