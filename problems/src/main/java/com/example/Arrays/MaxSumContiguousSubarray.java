package com.example.Arrays;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.
 */
public class MaxSumContiguousSubarray {
    public int maxSubArray(final List<Integer> a) {
        int max_so_far = a.get(0);
        int curr_max = a.get(0);

        for (int i = 1; i < a.size(); i++)
        {
            curr_max = Math.max(a.get(i), curr_max+a.get(i));
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
}
