package com.example.DP;

import java.util.List;

/*
Subsequence first increases then decreases
 */
public class LongestBitonicSequence {
    // https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
 /* lbs() returns the length of the Longest Bitonic Subsequence in
    arr[] of size n. The function mainly creates two temporary arrays
    lis[] and lds[] and returns the maximum lis[i] + lds[i] - 1.

    lis[i] ==> Longest Increasing subsequence ending with arr[i]
    lds[i] ==> Longest decreasing subsequence starting with arr[i]
    */

 /*
 Time Complexity here is O(n^2), O(nLogn) possible
  */
    public int longestSubsequenceLength(final List<Integer> A) {
        int i, j;

        /* Allocate memory for LIS[] and initialize LIS values as 1 for
            all indexes */
        int n = A.size();
        if(n == 0)
            return 0;
        int[] lis = new int[n];
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute LIS values from left to right */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (A.get(i) > A.get(j) && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Allocate memory for lds and initialize LDS values for
            all indexes */
        int[] lds = new int [n];
        for (i = 0; i < n; i++)
            lds[i] = 1;

        /* Compute LDS values from right to left */
        for (i = n-2; i >= 0; i--)
            for (j = n-1; j > i; j--)
                if (A.get(i) > A.get(j) && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;


        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = lis[0] + lds[0] - 1;
        for (i = 1; i < n; i++)
            if (lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;

        return max;
    }


}
