package com.example.Arrays;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

Do it in place.

Example

Given array A as

1 0 1
1 1 1
1 1 1
On returning, the array A should be :

0 0 0
1 0 1
1 0 1
Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 */
public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean[] zeroRows = new boolean[a.size()];
        boolean[] zeroCols = new boolean[a.get(0).size()];
        for(int row = 0; row < a.size(); row++){
            for(int col = 0; col < a.get(0).size(); col++){
                if(a.get(row).get(col) == 0){
                    zeroRows[row] = true;
                    zeroCols[col] = true;

                }
            }
        }

        for(int i=0;i<zeroRows.length;i++){
            if(zeroRows[i]){
                for(int col = 0; col < a.get(i).size(); col++)
                    a.get(i).set(col, 0);
            }
        }

        for(int i=0;i<zeroCols.length;i++){
            if(zeroCols[i]){
                for(int row = 0; row < a.size(); row++)
                    a.get(row).set(i, 0);
            }
        }
    }
}
