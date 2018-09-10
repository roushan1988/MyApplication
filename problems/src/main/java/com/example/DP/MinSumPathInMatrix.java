package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
Example :

Input :

    [  1 3 2
       4 3 1
       5 6 1
    ]

Output : 8
     1 -> 3 -> 2 -> 1 -> 1

     https://www.geeksforgeeks.org/min-cost-path-dp-6/
 */
public class MinSumPathInMatrix {
    public int minPathSum(ArrayList<ArrayList<Integer>> a) {
        if(a == null || a.size()==0)
            return 0;
        int m = a.size();
        int n = a.get(0).size();

        int[][] dp = new int[m][n];
        dp[0][0] = a.get(0).get(0);

        /* Initialize first column of total cost(tc) array */
        for(int i=1; i<n; i++){
            dp[0][i] = dp[0][i-1] + a.get(0).get(i);
        }
        /* Initialize first row of tc array */
        for(int j=1; j<m; j++){
            dp[j][0] = dp[j-1][0] + a.get(j).get(0);
        }
        /* Construct rest of the tc array */
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i][j-1] + a.get(i).get(j);
                }else{
                    dp[i][j] = dp[i-1][j] + a.get(i).get(j);
                }
            }
        }

        return dp[m-1][n-1];
    }
}
