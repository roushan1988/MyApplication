package com.example.Arrays;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
 */
public class MaxConsecutiveGap {
    public int maximumGap(final List<Integer> a) {
        if(a == null || a.size() < 2){
            return 0;
        }

        int max = a.get(0);
        int min = a.get(0);
        for(int i=1; i<a.size(); i++){
            max = Math.max(max, a.get(i));
            min = Math.min(min, a.get(i));
        }

        Bucket[] buckets = new Bucket[a.size()+1];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new Bucket();
        }

        double interval = (double) a.size() / (max - min);
        for(int i=0; i<a.size(); i++){
            int index = (int) ((a.get(i) - min) * interval);

            if(buckets[index].low == -1){
                buckets[index].low = a.get(i);
                buckets[index].high = a.get(i);
            }else{
                buckets[index].low = Math.min(buckets[index].low, a.get(i));
                buckets[index].high = Math.max(buckets[index].high, a.get(i));
            }
        }

        int result = 0;
        int prev = buckets[0].high;
        for(int i=1; i<buckets.length; i++){
            if(buckets[i].low != -1){
                result = Math.max(result, buckets[i].low-prev);
                prev = buckets[i].high;
            }

        }

        return result;
    }
    static class Bucket{
        int low;
        int high;
        public Bucket(){
            low = -1;
            high = -1;
        }
    }
}
