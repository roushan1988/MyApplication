package com.example.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
 */
public class SubsetsOfASet {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(a);
        int max = 1<<a.size();
        for(int i=0; i<max; i++){
            result.add(convertIntToSubset(i, a));
        }
        Collections.sort(result,new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
        return result;
    }

    private static ArrayList<Integer> convertIntToSubset(int n, ArrayList<Integer> a){
        ArrayList<Integer>subset = new ArrayList<>();
        int index = 0;
        for(int i=n; i>0; i >>= 1){
            if((i & 1) == 1){
                subset.add(a.get(index));
            }
            index++;
        }
        Collections.sort(subset);
        return subset;
    }
}
