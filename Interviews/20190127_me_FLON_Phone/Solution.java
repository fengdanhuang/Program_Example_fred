
/*
Interviewer: JB (American White)
Interview Result: DOWN

Question:

p1_meetings = [
  (  0, 845),
  (   ,    ),
]

p2_meetings = [
  ( 930, 1200),
  (1600, 2359),
]

p3_meetings = [
  ( 845, 915),
  (1515, 1545),
]

schedules = [p1_meetings, p2_meetings, p3_meetings]

Expected output:

find_available_time(schedules)
 => [    0,  845],
    [  915,  930],
    [ 1200, 1230],
    [ 1500, 1515],
    [ 1545, 1600]

*/

import java.io.*;
import java.util.*;

class Interval{
    public int start;
    public int end;
    Interval(int s, int e){
        start = s;
        end = e;
    }
}

public class Solution {

    public boolean isAvail(int[][] meetings, int start, int end){
        boolean re;
        int[] s = new int[meetings.length];
        int[] e = new int[meetings.length];

        for(int i=0; i<s.length; i++){
            s[i] = meetings[i][0];
        }
        for(int i=0; i<e.length; i++){
            e[i] = meetings[i][1];
        }
        Arrays.sort(s);
        Arrays.sort(e);

        if(end <= s[0]) return true;
        if(start >= e[e.length-1]) return true;

        for(int i=0; i<s.length-1; i++{
            if(start >= e[i] && end <= s[i+1]) return true;
        }
        return false;
    }

    public ArrayList<Interval> find_available_time(List<int[][] schedules){
        ArrayList<Interval> re = new ArrayList<>();
        int L = 0;
        for(int[][] m : schedules){
            L += m.length;
        }
        int[] s = new int[L];
        int[] e = new int[L];

        for(int[][] m : schedules){
            for(int i=0; i<m.length; i++){
                s[i] = m[i][0];
                e[i] = m[i][1];
            }
        }
        Arrays.sort(s);
        Arrays.sort(e);
    }

}
        
