package com.example.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
Considering each array element Ai as the edge length of some line segment,
count the number of triangles which you can form using these array values.

Notes:

You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter.
Any triangle formed should have a positive area.

Return answer modulo 10^9 + 7.

For example,

A = [1, 1, 1, 2, 2]

Return: 4
 */
public class TriangleCount {
    public int nTriang(ArrayList<Integer> A) {
        Collections.sort(A);
        long count = 0;
        for (int i = 0; i < A.size()-2; ++i)
        {
            int k = i + 2;
            for (int j = i+1; j < A.size(); ++j)
            {
                while (k < A.size() && A.get(i) + A.get(j) > A.get(k))
                    ++k;
                count += k - j - 1;
            }
        }
        count = Math.floorMod(count, (long)Math.pow(10, 9)+7);
        return (int)count;
    }
}
