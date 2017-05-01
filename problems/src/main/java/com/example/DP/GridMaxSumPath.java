package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/16/17.
 */
/*
A grid of m*n, max sum apth from top left to bot right. Every step move either right or down
Ttime complexity : O(mn), Space Complexity : O(m + n)
 */
public class GridMaxSumPath {

    public static void findBestPath2(int [][] matrix)
    {
        int [][] cost = new int[2][matrix[0].length];
        cost[0][0] = matrix[0][0];

        for(int i = 0; i < matrix.length; i++)
        {
            int iNext = 0;
            int iAt = 0;
            if(i % 2 == 0)
            {
                iNext = 1;
                iAt = 0;
            }
            else
            {
                iNext = 0;
                iAt = 1;
            }
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(i+1 < matrix.length && cost[iAt][j] + matrix[i+1][j] > cost[iNext][j])
                {
                    cost[iNext][j] = cost[iAt][j] + matrix[i+1][j] ;
                }
                if(j+1 < matrix.length && cost[iAt][j] + matrix[i][j+1] > cost[iAt][j+1])
                {
                    cost[iAt][j+1] = cost[iAt][j] + matrix[i][j+1] ;
                }
            }
        }
        if(matrix.length % 2 == 0) // n-1 would be odd
        {
            System.out.println("Max is " + cost[1][matrix[0].length-1]);
        }
        else // n-1 would be even
        {
            System.out.println("Max is " + cost[0][matrix[0].length-1]);
        }
    }
}
