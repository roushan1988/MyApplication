package com.example.Math;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120
Number of trailing zeros = 1
So, return 1
 */
public class TrailingZerosInFactorial {
    public int trailingZeroes(int a) {
        int count = 0;
        if(a < 0)
            return -1;

        for(int i = 5; a/i >0; i*=5)
            count += a/i;
        return count;
    }
}
