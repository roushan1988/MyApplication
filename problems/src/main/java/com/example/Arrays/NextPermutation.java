package com.example.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 Warning : DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION.
  Use of Library functions will disqualify your submission retroactively and will give yo
 */
// http://www.geeksforgeeks.org/lexicographically-previous-permutation-in-c/
public class NextPermutation {
    public void nextPermutation(ArrayList<Integer> a) {
        int i = a.size()-2;
        while (i>=0 && a.get(i) >= a.get(i+1)) // step 1: get first i s.t a[i] < a[i+1]
            i--;

        if(i >=0){
            int index = i+1;
            for(int j=a.size()-1; j>i; j--){  // step 2 : get the largest j s.t. a[j] > a[i]
                if(a.get(j)> a.get(i)){
                    index=j;
                    break;
                }
            }
            swap(a, index, i);                // step 3 : swap a[j] with a[i]
        }
        reverse(a, i+1, a.size()-1);         // step 4 : reverse the array starting at i-1

    }
    private static void reverse(ArrayList<Integer> a, int start, int end){
        while (start<end){
            swap(a, start++, end--);
        }
    }
    private static void swap(ArrayList<Integer> a, int first, int second){
        Collections.swap(a, first, second);
    }

    private static int binarySearch(ArrayList<Integer> a, int l, int r, int key){
        int index = -1;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(a.get(mid)<=key)
                r=mid-1;
            else
            {
                l=mid+1;
                if(index == -1 || a.get(index)<=a.get(mid))
                    index = mid;
            }
        }
        return index;
    }
}
