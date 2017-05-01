package com.example.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array A of integers, find the index of values that satisfy A + B = C + D,
where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1

2) If there are more than one solutions,
   then return the tuple of values which are lexicographical smallest.

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)

If no solution is possible, return an empty list.
 */
public class EqualSumPairs {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer> > result = new  ArrayList<>();
        HashMap<Integer,pair> map = new HashMap<>();
        int n=a.size();

        for (int i=0; i<n; ++i)
        {
            for (int j=i+1; j<n; ++j)
            {
                int sum = a.get(i) + a.get(j);
                if (!map.containsKey(sum))
                    map.put(sum,new pair(i,j));

                else
                {
                    pair p = map.get(sum);
                    if(p.first != i && p.first != j && p.second != i && p.second != j){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(p.first);
                        temp.add(p.second);
                        temp.add(i);
                        temp.add(j);
                        result.add(temp);
                    }
                }
            }
        }
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int result = Integer.compare((int) a.get(0), (int) b.get(0));
                if (result == 0 ) {
                    result = Integer.compare((int) a.get(1), (int) b.get(1));
                    if(result == 0)
                        result = Integer.compare((int) a.get(2), (int) b.get(2));
                    if(result == 0)
                        result = Integer.compare((int) a.get(3), (int) b.get(3));
                }
                return result;
            }
        });
        if(result.size() == 0)
            return new ArrayList<Integer>();
        return result.get(0);
    }

    private static class pair
    {
        int first, second;
        pair(int f,int s)
        {
            first = f; second = s;
        }
    };
}

