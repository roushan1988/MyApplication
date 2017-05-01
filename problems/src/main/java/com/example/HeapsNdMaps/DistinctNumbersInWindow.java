package com.example.HeapsNdMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:
- If K > N, return empty array.

For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
 */
public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> valToCountMap = new HashMap<>();
        int distinctCount = 0;
        for (int i = 0; i < B; i++)
        {
            if (valToCountMap.get(A.get(i)) == null)
            {
                valToCountMap.put(A.get(i), 1);
                distinctCount++;
            }
            else
            {
                int count = valToCountMap.get(A.get(i));
                valToCountMap.put(A.get(i), count+1);
            }
        }
        result.add(distinctCount);
        for (int i = B; i < A.size(); i++)
        {

            if (valToCountMap.get(A.get(i-B)) == 1)
            {
                valToCountMap.remove(A.get(i-B));
                distinctCount--;
            }
            else
            {
                int count = valToCountMap.get(A.get(i-B));
                valToCountMap.put(A.get(i-B), count-1);
            }

            if (valToCountMap.get(A.get(i)) == null)
            {
                valToCountMap.put(A.get(i), 1);
                distinctCount++;
            }
            else
            {
                int count = valToCountMap.get(A.get(i));
                valToCountMap.put(A.get(i), count+1);
            }

            result.add(distinctCount);
        }

        return result;
    }
}
