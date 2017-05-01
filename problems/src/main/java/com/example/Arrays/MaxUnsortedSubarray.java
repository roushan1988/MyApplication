package com.example.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.
 */
public class MaxUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int n = A.size();
        int s = 0, e = n-1, i, max, min;

        ArrayList<Integer> result = new ArrayList<>();
        for (s = 0; s < n-1; s++)
        {
            if (A.get(s) > A.get(s+1))
                break;
        }
        if (s == n-1)
        {
            result.add(-1);
            return result;
        }

        for(e = n - 1; e > s; e--)
        {
            if(A.get(e) < A.get(e-1))
                break;
        }

        min = Collections.min(A.subList(s+1, e + 1));
        for(i=0;i<=s;i++)
        {
            if(min<A.get(i))
                break;
        }
        result.add(i);

        max = Collections.max(A.subList(s, e));
        for(i=n-1;i>e;i--)
        {
            if(max>A.get(i))
                break;
        }
        result.add(i);
        return result;
    }
}
