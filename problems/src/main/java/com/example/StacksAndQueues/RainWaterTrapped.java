package com.example.StacksAndQueues;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/6/17.
 */
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Example :

Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class RainWaterTrapped {
    public int trap(final List<Integer> a) {
        int result = 0;

        int[] leftMax = new int[a.size()];
        int[] rightMax = new int[a.size()];

        int max = a.get(0);
        leftMax[0] = a.get(0);
        for(int i=1; i<a.size(); i++){
            if(a.get(i) < max){
                leftMax[i] = max;
            }else{
                leftMax[i] = a.get(i);
                max = a.get(i);
            }
        }
        max = a.get(a.size()-1);
        rightMax[a.size()-1] = max;
        for(int i=a.size()-2; i>=0; i--){
            if(a.get(i)<max){
                rightMax[i]=max;
            }else{
                rightMax[i]=a.get(i);
                max = a.get(i);
            }
        }

        for(int i=0; i<a.size(); i++){
            result+= Math.min(leftMax[i],rightMax[i])-a.get(i);
        }
        return result;
    }
}
