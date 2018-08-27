package com.example.Graphs;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

https://www.geeksforgeeks.org/find-number-of-islands/

 */
public class BlackShapesOrIslands {

    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    int countIslands(int M[][])
    {
        int ROW = M.length;
        int COL = M[0].length;
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];


        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j]==1 && !visited[i][j]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    void DFS(int M[][], int row, int col, boolean visited[][])
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
        int ROW = M.length;
        int COL = M[0].length;
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (M[row][col]==1 && !visited[row][col]);
    }

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
