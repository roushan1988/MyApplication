package com.example.TwoPointers;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class SortByColor {
    public void sortColors(ArrayList<Integer> a) {
        int k = a.size()-1;
        int i = 0, j = 0;

        for(i=0; i<a.size();i++){
            if(a.get(i) != 0)
                break;
        }
        j = i;
        for(; i <= k; i++){
            if(a.get(i) == 0){
                int temp = a.get(i);
                a.set(i,a.get(j));
                a.set(j,temp);
                j++;
            }
            else if(a.get(i) == 2){
                int temp = a.get(i);
                a.set(i,a.get(k));
                a.set(k,temp);
                i--;
                k--;
            }
        }
    }
}
