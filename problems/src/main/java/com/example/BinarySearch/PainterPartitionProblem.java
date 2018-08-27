package com.example.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board
Output:
     return minimum time to paint all boards % 10000003
Example

Input :
  K : 2
  T : 5
  L : [1, 10]
Output : 50

https://articles.leetcode.com/the-painters-partition-problem-part-ii/

 */
public class PainterPartitionProblem {
    public int paint(int a, int b, ArrayList<Integer> c) {
        return  (new Long(Math.floorMod(painterPartition(c, a) * b, 10000003))).intValue();
    }

    private static long painterPartition(ArrayList<Integer> a, int k) {
        Integer[] arr = a.toArray(new Integer[a.size()]);
        Long[] b = cumulativeSum(arr);
        long hi , lo ;
        lo = Collections.max(a);
        hi = b[b.length-1];

        while (lo < hi) {
            long mid = lo + (hi-lo)/2;
            int requiredPainters = requiredPainters(arr, mid);
            if (requiredPainters <= k)
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }

    private static int requiredPainters(Integer[] a, long maxLengthPerPainter){
        long totalPainted = 0;
        int numPainters = 1;
        for(int i=0; i<a.length; i++){
            totalPainted+=a[i];
            if(totalPainted >maxLengthPerPainter){
                numPainters++;
                totalPainted = a[i];
            }
        }
        return numPainters;
    }

    private static Long[] cumulativeSum(Integer[] a){
        Long[] b = new Long[a.length];
        b[0] = (long)a[0];
        for(int i=1;i<a.length;i++)
            b[i] = a[i] + b[i-1];
        return b;
    }
}
