package com.example.Graphs;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

 */
public class BlackShapesOrIslands {
    public int black(ArrayList<String> a) {
        char[][] grid = new char[a.size()][a.get(0).length()];
        int i=0;
        for(String str : a){
            for(int k=0; k<str.length(); k++)
                grid[i][k] = str.charAt(k);
            i++;
        }
        if(grid==null || grid.length==0||grid[0].length==0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count=0;
        for(i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='X'){
                    count++;
                    merge(grid, i, j);
                }
            }
        }

        return count;
    }

    public void merge(char[][] grid, int i, int j){
        int m=grid.length;
        int n=grid[0].length;

        if(i<0||i>=m||j<0||j>=n||grid[i][j]!='X')
            return;

        grid[i][j]='1';

        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }
}
