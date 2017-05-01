package com.example.Greedy;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
 NOTE: Solution will fit in a 32-bit signed integer
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000

 */
public class MaxProductOf3Numbers {
    public int maxp3(ArrayList<Integer> a) {
        return maxProduct(a, a.size());
    }

    int maxProduct(ArrayList<Integer> a, int n)
    {
        // if size is less than 3, no triplet exists
        if (n < 3)
            return -1;

        // Initialize Maximum, second maximum and third
        // maximum element
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

        // Initialize Minimum and second mimimum element
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            // Update Maximum, second maximum and third
            // maximum element
            if (a.get(i) > maxA)
            {
                maxC = maxB;
                maxB = maxA;
                maxA = a.get(i);
            }

            // Update second maximum and third maximum element
            else if (a.get(i) > maxB)
            {
                maxC = maxB;
                maxB = a.get(i);
            }

            // Update third maximum element
            else if (a.get(i) > maxC)
                maxC = a.get(i);

            // Update Minimum and second mimimum element
            if (a.get(i) < minA)
            {
                minB = minA;
                minA = a.get(i);
            }

            // Update second mimimum element
            else if(a.get(i) < minB)
                minB = a.get(i);
        }
        return Math.max(minA * minB * maxA,
                maxA * maxB * maxC);
    }
}
