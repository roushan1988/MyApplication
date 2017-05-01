package com.example.Arrays;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class MaxNonNegativeSubarray {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int size = a.size();
        long max_so_far = 0, max_ending_here = 0;
        ArrayList<Integer> maxTillNow = new ArrayList<>();
        ArrayList<Integer> max = new ArrayList<>();

        for (int i = 0; i < size; i++)
        {
            if(a.get(i) >= 0){
                maxTillNow.add(a.get(i));
                max_ending_here = max_ending_here + a.get(i);

            }else{
                if(max_so_far < max_ending_here || max.size() == 0){//first max segment
                    max_so_far = max_ending_here;
                    updateMax(maxTillNow, max);
                }

                else if(max_so_far == max_ending_here && max.size() < maxTillNow.size()){ // update to segment with higher length
                    max_so_far = max_ending_here;
                    updateMax(maxTillNow, max);
                }

                max_ending_here = 0;
                maxTillNow.clear();
            }

        }
        if(max_so_far < max_ending_here || max.size() == 0){
            updateMax(maxTillNow, max);
        }

        return max;
    }
    private static void updateMax(ArrayList<Integer> maxTillNow, ArrayList<Integer> max){
        max.clear();
        max.addAll(maxTillNow);
    }
}
