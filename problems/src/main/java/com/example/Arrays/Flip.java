package com.example.Arrays;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN.
In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:
- Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].
http://www.geeksforgeeks.org/maximize-number-0s-flipping-subarray/
 */
public class Flip {
    // A Kadane's algorithm based solution to find maximum
    // number of 0s by flipping a subarray.
    public static int findMaxZeroCount(int arr[], int n)
    {
        // Initialize count of zeros and maximum difference
        // between count of 1s and 0s in a subarray
        int orig_zero_count = 0;

        // Initiale overall max diff for any subarray
        int max_diff = 0;

        // Initialize current diff
        int curr_max = 0;

        for (int i = 0; i < n; i ++)
        {
            // Count of zeros in original array (Not related
            // to Kadane's algorithm)
            if (arr[i] == 0)
                orig_zero_count ++;

            // Value to be considered for finding maximum sum
            int val = (arr[i] == 1)? 1 : -1;

            // Update current max and max_diff
            curr_max = Math.max(val, curr_max + val);
            max_diff = Math.max(max_diff, curr_max);
        }
        max_diff = Math.max(0, max_diff);

        return orig_zero_count + max_diff;
    }

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result  = new ArrayList<>(2);
        int ansL = -1, ansR = -1;
        int currentL = -1, currentR = -1;
        int currMax = 0, max = 0;
        int val;
        for(int i=0; i<A.length();i++){
            val = A.charAt(i) == '0' ? 1 : -1;
            if(/*val >= max && */val >= currMax + val){ //new subarray window starts
                currentL = i;
                currentR = i;
                currMax = val;
            }else {
                currMax = currMax + val;
            }

            if(max < currMax){
                currentR = i;
                ansL = currentL;
                ansR = currentR;
                max = currMax;
            }else if(max == currMax){

            }
        }
        if(max > 0){
            result.add(ansL+1);
            result.add(ansR+1);
        }
        return result;
    }
}
