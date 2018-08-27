package com.example.TwoPointers;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input :
Array = {1 1 0 1 1 0 0 1 1 1 }
M = 1

Output :
[0, 1, 2, 3, 4]

If there are multiple possible solutions, return the sequence which has the minimum start index.
 */
public class MaxContiguous1Series {
    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int windowLeft = 0, windowRight = 0;
        int bestL = 0, bestWindow = 0;
        int zeroCount = 0;
        while (windowRight < a.size()){
            if (zeroCount <= b)
            {
                if (a.get(windowRight) == 0)
                    zeroCount++;
                windowRight++;
            }
            if (zeroCount > b)
            {
                if (a.get(windowLeft) == 0)
                    zeroCount--;
                windowLeft++;
            }
            if (windowRight-windowLeft > bestWindow)//Update bestWindow if found
            {
                bestWindow = windowRight-windowLeft;
                bestL = windowLeft;
            }
        }
        ArrayList<Integer> indices = new  ArrayList<>();
        for (int i=0; i<bestWindow; i++)
        {
            indices.add(bestL+i);
        }
        return indices;
    }
}
