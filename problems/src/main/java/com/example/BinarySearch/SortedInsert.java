package com.example.BinarySearch;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */
public class SortedInsert {
    public int searchInsert(ArrayList<Integer> a, int b) {
        return searchInsert(a, b, 0, a.size()-1);
    }

    private static int searchInsert(ArrayList<Integer> A, int B, int start, int end){
        int mid = (start + end )/ 2;
        if(B == A.get(mid)) {
            return mid;
        }
        else if(B < A.get(mid)) {
            return start < mid ? searchInsert(A,B,start,mid-1):start;
        }
        else {
            return end > mid ? searchInsert(A,B,mid+1,end):(end+1);
        }
    }
}
