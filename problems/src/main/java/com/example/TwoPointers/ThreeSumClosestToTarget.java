package com.example.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers.

Assume that there will only be one solution

Example:
given array S = {-1 2 1 -4},
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class ThreeSumClosestToTarget {
    public int threeSumClosest(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        int result = 0, min = Integer.MAX_VALUE;
        for(int i=0; i<a.size(); i++){
            int j= i+1;
            int k = a.size() -1;
            while (j<k){
                int sum = a.get(i) +a.get(j) + a.get(k);
                int diff = Math.abs(sum - b);
                if(diff == 0)
                    return sum;
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= b) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
