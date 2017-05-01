package com.example.TwoPointers;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() <= 2)
            return a.size();
        int prev =1, current = 2;
        while (current < a.size()) {
            if (a.get(current).equals(a.get(prev)) && a.get(current).equals(a.get(prev -1))) {
                current++;
            } else {
                prev++;
                a.set(prev, a.get(current)) ;
                current++;
            }
        }

        return prev + 1;
    }
}
