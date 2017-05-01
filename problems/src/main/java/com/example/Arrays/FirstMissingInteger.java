package com.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> a) {
        Integer []arr = new Integer[a.size()];
        arr =  a.toArray(arr);

        int positiveStart = moveNegativeToLeft(arr);
        Integer []arr2 = new Integer[a.size() - positiveStart];
        //arr2 = a.subList(positiveStart, a.size()).toArray(arr2);
        arr2 = Arrays.copyOfRange(arr, positiveStart, arr.length);
        return changeSignsAndLocate(arr2);
    }

    private static int changeSignsAndLocate(Integer[] arr){
        for(int i=0; i<arr.length ; i++){
            int indexToChangeSign = Math.abs(arr[i]) -1;
            if(indexToChangeSign < arr.length && indexToChangeSign >= 0 && arr[indexToChangeSign] > 0){
                arr[indexToChangeSign] = -arr[indexToChangeSign];
            }
        }

        for(int i=0; i<arr.length ; i++){
            if(arr[i] > 0)
                return i+1;
        }

        return arr.length +1;
    }

    private static int moveNegativeToLeft(Integer[] arr){
        int j = 0;
        for(int i =0; i< arr.length ; i++){
            int temp;
            if(arr[i] <= 0){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }
}
