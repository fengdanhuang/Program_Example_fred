

import java.util.*;

class MyCalendar {
    
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
	    System.out.println("calendar = " + calendar);
            return true;
        }
	System.out.println("calendar = " + calendar);
        return false;
    }


    public static void main(String args[]){
 
        //Your MyCalendar object will be instantiated and called as such:
        MyCalendar obj = new MyCalendar();
        boolean param_1 = obj.book(10,20);
        param_1 = obj.book(15,25);
        param_1 = obj.book(20,30);


    }
    
}
