package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence that is identical to the sequence T.

 Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none ) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
Example :
 S = "rabbbit" T = "rabbit"

Return 3. And the formations as follows:

S1= "ra_bbit"
S2= "rab_bit"
S3="rabb_it"
"_" marks the removed character.
 */
public class DistinctContainedSubsequences {
    public int numDistinct(String S, String T) {
        int m = T.length(), n = S.length();
        if(m >n)
            return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = 0;

        for (int i = 0; i <= n; i++)
            dp[0][i] = 1;

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (T.charAt(i-1) != S.charAt(j-1))
                    dp[i][j] = dp[i][j - 1];
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
