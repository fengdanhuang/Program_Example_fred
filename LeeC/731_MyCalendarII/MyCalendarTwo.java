

import java.util.*;


class MyCalendarTwo {
    
    TreeMap<Integer, Integer> delta;

    public MyCalendarTwo() {
        
        delta = new TreeMap<>();
        
    }

    public boolean book(int start, int end) {
	System.out.println("start = " + start + ", end = " + end);       
 
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);

		System.out.println("active>=3, delta = " + delta + "\n");
                return false;
            }
        }
        
	System.out.println("After for, delta = " + delta + "\n");
        return true;
    }


    public static void main(String args[]){
        //Your MyCalendarTwo object will be instantiated and called as such:
        MyCalendarTwo obj = new MyCalendarTwo();
        boolean param_1 = obj.book(10,20);
        param_1 = obj.book(50,60);
        param_1 = obj.book(10,40);
        param_1 = obj.book(5,15);
        param_1 = obj.book(5,10);
        param_1 = obj.book(25,55);
    }
       
}


