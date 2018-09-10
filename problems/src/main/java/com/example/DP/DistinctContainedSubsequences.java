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

Time Complexity : O(m*n)
Auxiliary Space : O(m*n)

    https://www.geeksforgeeks.org/count-distinct-occurrences-as-a-subsequence/

 */
public class DistinctContainedSubsequences {
    public int numDistinct(String S, String T) {
        int m = T.length(), n = S.length();
        // T can't appear as a subsequence in S
        if(m >n)
            return 0;
        // dp[i][j] stores the count of
        // occurrences of T(1..i) in S(1..j).
        int[][] dp = new int[m + 1][n + 1];
        // Initializing first column with
        // all 0s. An emptystring can't have
        // another string as suhsequence
        for (int i = 1; i <= m; i++)
            dp[i][0] = 0;
        // Initializing first row with all 1s.
        // An empty string is subsequence of all.
        for (int i = 0; i <= n; i++)
            dp[0][i] = 1;

        // Fill mat[][] in bottom up manner
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // If last characters don't match,
                // then value is same as the value
                // without last character in S.

                if (T.charAt(i-1) != S.charAt(j-1))
                    dp[i][j] = dp[i][j - 1];
                else
                    // Else value is obtained considering two cases.
                    // a) All substrings without last character in S
                    // b) All substrings without last characters in
                    // both.
                    // Remove last character of S and recur. +  // Remove last characters of S and T, and recur.
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
