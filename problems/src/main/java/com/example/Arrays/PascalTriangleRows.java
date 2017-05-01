package com.example.Arrays;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
 */
public class PascalTriangleRows {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int row = 0; row< a; row++){
            result.add(getRow(row));
        }
        return result;
    }

    private static ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> result= new ArrayList<>();
        int C = 1;
        result.add(C);
        for(int i=1; i<=a; i++){
            C = C * (a-i+1)/i ;
            result.add(C);
        }
        return result;
    }
}
