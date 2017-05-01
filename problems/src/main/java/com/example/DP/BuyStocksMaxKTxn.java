package com.example.DP;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 1 2]
Output : 2

Explanation :
  Day 1 : Buy
  Day 2 : Sell
  Day 3 : Buy
  Day 4 : Sell
 */
public class BuyStocksMaxKTxn {
    public int maxProfit(final List<Integer> a) {
        return maxProfit(2, a);
    }


    //local[i][j] is maximum positive difference in prices uptil ith day

    public int maxProfit(int k, final List<Integer> a){
        if(a.size() < 2 || k <= 0)
            return 0;

        int[][] local = new int[a.size()][k+1];
        int[][] global = new int[a.size()][k+1];

        for (int i = 1; i < a.size(); i++) {
            int diff = a.get(i) - a.get(i-1);
            for (int j=1; j<=k; j++){
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[a.size()-1][k];
    }


// http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/

    int maxProfit(int price[], int n, int k)
    {
        // table to store results of subproblems
        // profit[t][i] stores maximum profit using atmost
        // t transactions up to day i (including day i)
        int[][] profit = new int[k+1][n+1];

        // For day 0, you can't earn money
        // irrespective of how many times you trade
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        // profit is 0 if we don't do any transation
        // (i.e. k =0)
        for (int j= 0; j <= n; j++)
            profit[0][j] = 0;

        // fill the table in bottom-up fashion
        for (int i = 1; i <= k; i++)
        {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++)
            {
                prevDiff = Math.max(prevDiff, profit[i-1][j-1] - price[j-1]);
                profit[i][j] = Math.max(profit[i][j-1], price[j] + prevDiff);
            }
        }

        return profit[k][n-1];
    }
}
