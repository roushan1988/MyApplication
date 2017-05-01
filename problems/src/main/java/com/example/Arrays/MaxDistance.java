package com.example.Arrays;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2
for the pair (3, 4)
 */
public class MaxDistance {
    public int maximumGap(final List<Integer> a) {
        int maxDiff=-1, i, j;
        int leftMin[] = new int[a.size()];
        int rightMax[] = new int[a.size()];

        leftMin[0] = a.get(0);
        for(i=1; i<a.size(); i++){
            leftMin[i] = Math.min(a.get(i), leftMin[i-1]);
        }

        rightMax[a.size()-1] = a.get(a.size()-1);
        for(i=a.size()-2; i>=0; i--){
            rightMax[i] = Math.max(a.get(i), rightMax[i+1]);
        }

        i=0; j=0;
        while (i<a.size() && j<a.size()){
            if(leftMin[i] <= rightMax[j]){
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            }else{
                i++;
            }
        }
        return maxDiff;
    }
}
