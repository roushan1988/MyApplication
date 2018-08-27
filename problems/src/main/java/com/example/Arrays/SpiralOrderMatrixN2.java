package com.example.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:
 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class SpiralOrderMatrixN2 {

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int current = 1;
        // Start in the corner
        int x = 0, y = 0, dx = 1, dy = 0;

        int columnSize = a.size();
        int rowSize = a.get(0).size();
        int spiral[][]= new int[columnSize][rowSize];

        while (current <= columnSize*rowSize) {
            // Go in a straight line
            System.out.print(a.get(y).get(x) + " ");
            spiral[y][x] = current++;
            int nx = x + dx, ny = y + dy;

            // When you hit the edge...
            if (nx < 0 || nx == rowSize || ny < 0 || ny == columnSize || spiral[ny][nx] != 0) {
                // ...turn right
                int t = dy;
                dy = dx;
                dx = -t;
            }
            x += dx;
            y += dy;
        }



        return result;
    }

    //OR

    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int rowstart = 0, colStart = 0, rowEnd = a, colEnd = a;
        int val = 1;
        for (int i= 0;i<a;i++){
            ArrayList<Integer>row = new ArrayList<>();
            for(int j=0; j<a;j++)
                row.add(0);
            result.add(row);
        }

        while(rowstart < rowEnd && colStart < colEnd){
            for(int i = colStart;i < colEnd ; i++){
                result.get(rowstart).set(i, val++);
            }
            rowstart ++;

            for(int i = rowstart;i < rowEnd ; i++){
                result.get(i).set(colEnd -1, val++);
            }
            colEnd --;

            if(rowstart < rowEnd){
                for(int i = colEnd-1;i >= colStart ; i--){
                    result.get(rowEnd-1).set(i, val++);
                }
                rowEnd --;
            }

            if(colStart < colEnd){
                for(int i = rowEnd-1;i >= rowstart ; i--){
                    result.get(i).set(colStart, val++);
                }
                colStart++ ;
            }
        }
        return result;
    }

}
