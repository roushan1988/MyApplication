package com.example.Graphs;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
The cell itself does not count as an adjacent cell.
The same letter cell may be used more than once.

Example :

Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0

 */
public class WordSearchBoard {
    public int exist(ArrayList<String> a, String b) {
        int m = a.size();
        int n = a.get(0).length();
        char[][] grid = new char[m][n];
        int i=0;
        for(String str : a){
            for(int k=0; k<str.length(); k++)
                grid[i][k] = str.charAt(k);
            i++;
        }
        for(i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(checkNbrs(grid,b,i,j)){
                    return 1;
                }
            }
        }

        return 0;
    }

    public static boolean checkNbrs(char[][] grid, String word, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }
        if(dfs(grid, word, i-1, j, 0)
                ||dfs(grid, word, i+1, j, 0)
                ||dfs(grid, word, i, j-1, 0)
                ||dfs(grid, word, i, j+1, 0))
            return true;
        return false;
    }

    public static boolean dfs(char[][] grid, String word, int i, int j, int k){
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }
        if(grid[i][j] == word.charAt(k)){
            if(k==word.length()-1){
                return true;
            }else if(dfs(grid, word, i-1, j, k+1)
                    ||dfs(grid, word, i+1, j, k+1)
                    ||dfs(grid, word, i, j-1, k+1)
                    ||dfs(grid, word, i, j+1, k+1)){
                return true;
            }
        }
        return false;
    }
}
