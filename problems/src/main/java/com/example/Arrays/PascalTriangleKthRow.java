package com.example.Arrays;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].
Note:Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleKthRow {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> result= new ArrayList<>();
        int C = 1;
        result.add(C);
        for(int i=1; i<=a; i++){
            C = C * (a-i+1)/i ;
            result.add(C);
        }
        return result;
    }
}
