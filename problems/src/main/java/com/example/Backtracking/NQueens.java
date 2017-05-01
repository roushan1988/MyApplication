package com.example.Backtracking;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        placeQueens(0, new Integer[a], result, a);
        return result;
    }

    private static void placeQueens(int row, Integer[] cols, ArrayList<ArrayList<String>> result, int a){
        if(row == a){
            result.add(getStringFromCols(cols));
        }else{
            for(int col =0; col < a; col++){
                if(checkValid(cols, row, col)){
                    cols[row] = col;
                    placeQueens(row+1, cols, result, a);
                }
            }
        }
    }

    private static ArrayList<String> getStringFromCols(Integer[] cols){
        ArrayList<String> result = new ArrayList<>(cols.length);
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<cols.length; i++){
            builder.setLength(0);
            for(int j=0; j<cols.length; j++){
                if(j==cols[i])
                    builder.append("Q");
                else
                    builder.append(".");
            }
            result.add(builder.toString());
        }
        return result;
    }

    private static boolean checkValid(Integer[] cols, int row1, int col1){
        for(int row2= 0; row2<row1; row2++){
            int col2 = cols[row2];
            if(col1 == col2)
                return false;
            int colDistance = Math.abs(col2-col1);
            if(row1-row2 == colDistance)
                return false;
        }
        return true;
    }
}
