package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return 1 ( true ).

A = [3,2,1,0,4], return 0 ( false ).
 */
public class JumpGame {
    public int canJump(ArrayList<Integer> a) {
        int next = a.size() - 1;
        for(int i = a.size() - 2; i >= 0; i--){
            if(a.get(i) >= next - i) //means next is reachable from i
                next = i; // now check for new next (move backPointerFromBestIndex)
        }
        return next == 0 ? 1 : 0;
    }
}
