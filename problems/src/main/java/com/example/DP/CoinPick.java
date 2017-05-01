package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/4/17.
 */
/*
There are N coins (Assume N is even) in a line.
Two players take turns to take a coin from one of the ends of the line until there are no more coins left.
 The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.

Example:

suppose that there are 4 coins which have value
1 2 3 4
now you are first so you pick 4
then in next term
next person picks 3 then
you pick 2 and
then next person picks 1
so total of your money is 4 + 2 = 6
next/opposite person will get 1 + 3 = 4
so maximum amount of value you can get is 6
 */

public class CoinPick {
    public int maxcoin(ArrayList<Integer> a) {
        int[][] dp = new int[a.size()][a.size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        int x, y, z;
        for (int gap = 0; gap < a.size(); ++gap)
        {
            for (int i = 0, j = gap; j < a.size(); ++i, ++j)
            {
                x = ((i+2) <= j) ? dp[i+2][j] : 0;
                y = ((i+1) <= (j-1)) ? dp[i+1][j-1] : 0;
                z = (i <= (j-2))? dp[i][j-2]: 0;

                dp[i][j] = Math.max(a.get(i) + Math.min(x, y), a.get(j) + Math.min(y, z));
            }
        }
        return dp[0][a.size()-1];
    }
}
