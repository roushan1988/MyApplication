package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
There is a rod of length N lying on x-axis with its left end at x = 0 and right end at x = N.
Now, there are M weak points on this rod denoted by positive integer values(all less than N) A1, A2, …, AM.

You have to cut rod at all these weak points. You can perform these cuts in any order.
 After a cut, rod gets divided into two smaller sub-rods.
 Cost of making a cut is the length of the sub-rod in which you are making a cut.

Your aim is to minimise this cost. Return an array denoting the sequence in which you will make cuts. If two different sequences of cuts give same cost, return the lexicographically smallest.

Notes:
- Sequence a1, a2 ,…, an is lexicographically smaller than b1, b2 ,…, bm, if and only if at the first i where ai and bi differ, ai < bi, or if no such i found, then n < m.
- N can be upto 109.

For example,

N = 6
A = [1, 2, 5]

If we make cuts in order [1, 2, 5], let us see what total cost would be.
For first cut, the length of rod is 6.
For second cut, the length of sub-rod in which we are making cut is 5(since we already have made a cut at 1).
For third cut, the length of sub-rod in which we are making cut is 4(since we already have made a cut at 2).
So, total cost is 6 + 5 + 4.

Cut order          | Sum of cost
(lexicographically | of each cut
 sorted)           |
___________________|_______________
[1, 2, 5]          | 6 + 5 + 4 = 15
[1, 5, 2]          | 6 + 5 + 4 = 15
[2, 1, 5]          | 6 + 2 + 4 = 12
[2, 5, 1]          | 6 + 4 + 2 = 12
[5, 1, 2]          | 6 + 5 + 4 = 15
[5, 2, 1]          | 6 + 5 + 2 = 13


So, we return [2, 1, 5].

 */
public class RodCutting {
    public ArrayList<Integer> ar, ans;
    public long dp[][];
    public int bestIndexHolderGrid[][], n;

    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        B.add(0, 0);
        B.add(B.size(), A);

        n = B.size();
        ar = new ArrayList<>();
        ans = new ArrayList<>();
        dp = new long[n][n];
        bestIndexHolderGrid = new int[n][n];
        ar.clear();
        ar.addAll(B);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        rec(0, n -1);
        backPointerFromBestIndex(0, n -1);

        return ans;
    }

    public long rec(int l, int r){
        if (l +1 >= r)
            return 0;

        long ret = dp[l][r];
        int bestIndexToCutRodFromlTor = 0;
        if (ret != -1)
            return ret;

        ret = Long.MAX_VALUE;
        for (int i = l + 1; i < r; i++){
            long p = rec(l, i) + rec(i, r) + ar.get(r) - ar.get(l);
            if (p < ret){
                bestIndexToCutRodFromlTor = i;
                ret = p;
            }
        }
        bestIndexHolderGrid[l][r] = bestIndexToCutRodFromlTor;
        dp[l][r] = ret;
        return ret;
    }

    public void backPointerFromBestIndex(int l, int r){
        if (l + 1 >= r)
            return;
        ans.add(ar.get(bestIndexHolderGrid[l][r]));
        backPointerFromBestIndex(l, bestIndexHolderGrid[l][r]);
        backPointerFromBestIndex(bestIndexHolderGrid[l][r], r);
    }
}
