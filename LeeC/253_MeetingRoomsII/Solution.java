
import java.util.*;

/**
 * Definition for an interval.
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    
    public int minMeetingRooms(Interval[] intervals) {
        
        int[] starts = new int[intervals.length];
        
        int[] ends = new int[intervals.length];
        
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int endsItr = 0;
        
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        System.out.println("rooms = " + rooms);
        return rooms;
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	Interval i1 = new Interval(0, 30);
	Interval i2 = new Interval(5, 10);
	Interval i3 = new Interval(15, 20);
	Interval[] intervals = new Interval[] {i1, i2, i3};
	s1.minMeetingRooms(intervals);
	

    }
}

