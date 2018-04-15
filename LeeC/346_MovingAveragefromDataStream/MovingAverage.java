



public class MovingAverage {
    
    private int [] window;
    
    private int n, insert;
    
    private long sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
	
	for(int i=0; i<window.length; i++)
	    System.out.print(window[i] + "  ");
	System.out.println();
	System.out.println("insert = " + insert);
	System.out.println("sum = " + sum);
	System.out.println("n = " + n + "\n");
    }
    
    public double next(int val) {

        if (n < window.length)  n++;

        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;
        
        double re = (double)sum / n;
	for(int i=0; i<window.length; i++)
	    System.out.print(window[i] + "  ");
	System.out.println();
	System.out.println("insert = " + insert);
	System.out.println("sum = " + sum);
	System.out.println("n = " + n);
	System.out.println("re = " + re + "\n");
	
        return re;
    }



    public static void main(String args[]){
        //* Your MovingAverage object will be instantiated and called as such:
        MovingAverage obj = new MovingAverage(3);
        obj.next(1);
        obj.next(10);
        obj.next(3);
        obj.next(5);
        obj.next(6);
        obj.next(7);
        obj.next(8);
        obj.next(9);
        obj.next(4);
    }
    
}
