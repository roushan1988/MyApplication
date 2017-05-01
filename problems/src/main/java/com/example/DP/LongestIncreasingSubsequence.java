package com.example.DP;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Find the longest increasing subsequence of a given sequence / array.

In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible.
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.

Example :

Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output : 6
The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]

http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
http://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-using-dynamic-programming/
 */
public class LongestIncreasingSubsequence {
    public int lis(final List<Integer> a) {
        int[] subsequence   = new int[a.size()];
        int len =1;
        subsequence[0] = a.get(0);
        for (int i = 1; i < a.size(); i++)
        {
            if (a.get(i) < subsequence[0])
                subsequence[0] = a.get(i);

            else if (a.get(i) > subsequence[len-1])
                subsequence[len++] = a.get(i);

            else
                subsequence[findIndex(subsequence, -1, len-1, a.get(i))] = a.get(i);
        }
        return len;
    }

    static int findIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }

        return r;
    }
}
