package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).


 */
public class MinSumPathInTriangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int lastRowSize = a.get(a.size()-1).size();
        int[]adjacentSum = new int[lastRowSize];

        for(int i=0;i<lastRowSize; i++)
            adjacentSum[i] = a.get(a.size()-1).get(i);

        for(int row= a.size()-2; row>=0; row--){
            for(int j=0; j<a.get(row).size(); j++){
                adjacentSum[j] = a.get(row).get(j) + Math.min(adjacentSum[j], adjacentSum[j+1]);
            }
        }
        return adjacentSum[0];
    }
}
