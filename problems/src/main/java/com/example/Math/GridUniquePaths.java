package com.example.Math;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
A robot is located at the top-left corner of an A x B grid
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
              OR  : (0, 0) -> (1, 0) -> (1, 1)
 */
public class GridUniquePaths {
    public int uniquePaths(int a, int b) {
        long result = 1;
        for (int i = b; i < (a + b - 1); i++) {
            result *= i;
            result /= (i - b + 1);
        }
        return (int)result;
    }
}
