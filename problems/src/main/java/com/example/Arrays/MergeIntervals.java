package com.example.Arrays;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
 */
public class MergeIntervals {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        if(intervals.size() == 0){
            result.add(newInterval);
        }else if (newInterval.start > intervals.get(intervals.size()-1).end || newInterval.end < intervals.get(0).start)
        {
            if (newInterval.end < intervals.get(0).start) // new interval is placed at the start. its mutually exclusive
            {
                result.add(newInterval);
            }
            for (Interval interval : intervals)
            {
                result.add(interval); // add the other intervals, either new interval has already been added (start) or its to be addded at the end
            }
            if (newInterval.start > intervals.get(intervals.size() -1).end) // added at the end
            {
                result.add(newInterval);
            }
            return result;
        }
        else{ // If the new interval is to be in between the others
            for (int i = 0; i < intervals.size(); i++)
            {
                boolean overlaps = overlap(intervals.get(i), newInterval);
                if (!overlaps)
                {
                    //If it doesn't overlap with the ith interval, ith interval can be safely added to the list
                    //Further if if it lies between ith and i+1 th interval, the new interval can be added here
                    result.add(intervals.get(i));
                    if (i < intervals.size() - 1 && newInterval.start > intervals.get(i).end && newInterval.end < intervals.get(i+1).start)
                    {
                        result.add(newInterval);
                    }
                    continue; // Continue to add remaining intervals
                }
                //Following code executes if the new interval overlaps
                int st = i;
                while (i < intervals.size() && overlaps) //Check for consecutive intervals starting from st that overalap with the new one, a consolidated interval merging these would be finally added
                {
                    i++;
                    if (i == intervals.size())
                        overlaps = false;
                    else
                    {
                        overlaps = overlap(intervals.get(i), newInterval);
                    }
                }
                i--;
                Interval consolidatedInterval = new Interval(Math.min(newInterval.start, intervals.get(st).start), Math.max(newInterval.end, intervals.get(i).end));
                result.add(consolidatedInterval);
            }
            return result;
        }

        return result;
    }

    private boolean overlap(Interval a, Interval b)
    {
        if (Math.min(a.end, b.end) < Math.max(a.start, b.start))
            return false;
        return true;
    }
}

