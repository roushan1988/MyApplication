package com.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
 */
public class MergeOverlappingIntervals {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval interval, Interval t1) {
            return interval.start - t1.start;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        Stack<Interval> s  = new Stack<>();
        s.push(intervals.get(0));
        Interval lastPushed;
        for(Interval interval : intervals){
            lastPushed = s.peek();
            if(lastPushed.end < interval.start){
                s.push(interval);
            } else if(lastPushed.end < interval.end) {
                lastPushed.end = interval.end;
                s.pop();
                s.push(lastPushed);
            }
        }
        Interval[] resArr = new Interval[s.size()];
        for(int i=s.size()-1; i>=0; i--){
            resArr[i] = s.pop();
        }
        return  new ArrayList<>(Arrays.asList(resArr));
    }
}
