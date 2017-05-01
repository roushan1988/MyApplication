package com.example.TwoPointers;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input :
    A : [1 3 5]
    k : 4
 Output : YES as 5 - 1 = 4
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.
 */
public class DiffK {
    public int diffPossible(ArrayList<Integer> a, int b) {
        int i=0, j=1;
        while (i<a.size() && j<a.size()){
            int diff = a.get(j) - a.get(i);
            if(diff == b && i!=j)
                return 1;
            else if(diff <b)
                j++;
            else
                i++;
        }
        return 0;
    }
}
