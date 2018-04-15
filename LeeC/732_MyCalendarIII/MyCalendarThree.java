
import java.util.*;

class MyCalendarThree {
    
    TreeMap<Integer, Integer> delta;

    public MyCalendarThree() {
        delta = new TreeMap<>();
    }

    public int book(int start, int end) {
	System.out.println("start = " + start + ", end = " + end);
        
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }
	System.out.println("delta = " + delta);

	System.out.println("ans = " + ans + "\n");
        return ans;
    }

    public static void main(String args[]){
        // Your MyCalendarThree object will be instantiated and called as such:
        MyCalendarThree obj = new MyCalendarThree();
        int param_1 = obj.book(10,20);
        param_1 = obj.book(50,60);
        param_1 = obj.book(10,40);
        param_1 = obj.book(5,15);
        param_1 = obj.book(5,10);
        param_1 = obj.book(25,55);
    }
    
}

