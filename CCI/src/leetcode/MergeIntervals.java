package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        MyComparator MyComp = new MyComparator();
    	Collections.sort(intervals, MyComp);
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            if (result.size() == 0) result.add(intervals.get(i));
            else {
                Interval i1 = result.get(result.size()-1);
                if (canMerge(i1, intervals.get(i))) {
                    result.remove(result.size()-1);
                    result.add(Merge(i1, intervals.get(i)));
                } else {
                    result.add(intervals.get(i));
                }
            }
        }
        return result;
    }
    
    public boolean canMerge(Interval i1, Interval i2) {
        if (i1.end >= i2.start) { // overlap
            return true;
        } else {
            return false;
        }
    }
    
    public Interval Merge(Interval i1, Interval i2) {
        Interval newi = new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
        return newi;
    }
    
    public static class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start > o2.start)
             {
                 return 1;
             }
            else if (o1.start < o2.start)
            {
                return -1;
            }
            return 0;    
        } 
    }
    
    /**
     * Definition for an interval.
     */
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    
}