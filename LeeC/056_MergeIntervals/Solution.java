
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

// Definition for an interval.
 
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}




class Solution {
    
    private class IntervalComparator implements Comparator<Interval> {
        
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public List<Interval> merge1(List<Interval> intervals) {
        
        if (intervals.size()<=1) {return intervals;}
        
        List<Interval> r = new ArrayList<>();
        
        int n = intervals.size();
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        
        for (int i = 0; i< n ; i++) {
            Interval t = intervals.get(i);
            starts[i] = t.start;
            ends[i] = t.end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int start = starts[0];
        int end = ends[0];
        for (int i = 0; i < n; i++) {
            if (starts[i] > end) {
                r.add(new Interval(start, end));
                start = starts[i];
            } 
            end = ends[i];
        }
        if (r.isEmpty() || r.get(r.size()-1).end < end) {
            r.add(new Interval(start, end));
        }

        return r;
    }

    
    public static void main(String args[]){
	Solution s1 = new Solution();
	
	Interval i1 = new Interval(1,3);
	Interval i2 = new Interval(2,6);
	Interval i3 = new Interval(8,10);
	Interval i4 = new Interval(15,18);
	
	//List<Interval> in = new LinkedList.asList(i1,i2,i3,i4);
	List<Interval> l1 = new LinkedList();
        s1.merge(in);    
        s1.merge1(in);		
    }

}
