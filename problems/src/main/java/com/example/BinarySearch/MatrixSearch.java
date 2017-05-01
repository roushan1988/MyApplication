package com.example.BinarySearch;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 */
public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int n =a.size();
        int i = 0, j = a.get(0).size()-1;
        while ( i < n && j >= 0 )
        {
            if ( a.get(i).get(j) == b )
            {
                return 1;
            }
            if ( a.get(i).get(j) > b )
                j--;
            else
                i++;
        }

        return 0;
    }
}
