package leetcode;

import leetcode.MergeIntervals.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        MyComparator MyComp = new MyComparator();
        Collections.sort(intervals, MyComp);
        int begin = 0;
        int end = 0;
        boolean f1 = false;
        boolean f2 = false;
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0 && newInterval.start < intervals.get(i).start) {
                //begin = -1;
                f1 = true;
            } else if (newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end) { // the begin of the overlap
                begin = i;
                f1 = true;
            } else if (i < intervals.size()-1 && newInterval.start > intervals.get(i).end && newInterval.start < intervals.get(i+1).start) {
                begin = i+1;
                f1 = true;
            } else if (i == intervals.size()-1 && newInterval.start > intervals.get(i).end) {
                begin = i;
                f1 = true;
            }
            
            if (i == 0 && newInterval.start < intervals.get(i).start) {
                f2 = true;
            } else if (newInterval.end >= intervals.get(i).start && newInterval.end >= intervals.get(i).end) { // the end of the overlap
                end = i;
                f2 = true;
            } else if (i < intervals.size()-1 && newInterval.end > intervals.get(i).end && newInterval.end < intervals.get(i+1).start) { // the end of the overlap
                end = i+1;
                f2 = true;
            } else if (i == intervals.size()-1 && newInterval.start > intervals.get(i).end) {
                end = i;
                f2 = true;
            }
            if (f1&&f2) {
                break;
            }
        }
        ArrayList<Interval> merge = new ArrayList<Interval>();
        merge.add(newInterval);
        for (int i = begin; i <= end; i++) {
            if (canMerge(newInterval, intervals.get(i))) {
                Interval m = Merge(merge.get(merge.size()-1), intervals.get(i));
                merge.remove(merge.size()-1);
                merge.add(m);
            }
        }
        if (!canMerge(merge.get(0), intervals.get(0))) merge.add(intervals.get(0));
        if (!canMerge(merge.get(0), intervals.get(intervals.size()-1))) merge.add(intervals.get(intervals.size()-1));
        int i = 0;
        while (i < end - begin) {
            intervals.remove(begin);
            i++;
        }
        intervals.addAll(merge);
        return intervals;
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
    
    private class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start < o2.start) {
                return -1;
            } else if (o1.start > o2.start) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}