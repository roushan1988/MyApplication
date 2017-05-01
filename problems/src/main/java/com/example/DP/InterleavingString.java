package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example,
Given:

s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class InterleavingString {
    public int isInterleave(String a, String b, String c) {
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        dp[0][0] = true;
        if(c.length() != a.length() + b.length())
            return 0;
        for(int i=1; i<= a.length(); i++)
            dp[i][0] = a.charAt(i-1) == c.charAt(i-1) ? true:false;

        for(int i=1; i<= b.length(); i++)
            dp[0][i] = b.charAt(i-1) == c.charAt(i-1) ? true:false;

        for(int i=1; i<= a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) != c.charAt(i+j-1))
                    dp[i][j] = dp[i-1][j];
                else if (a.charAt(i-1) != c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1))
                    dp[i][j] = dp[i][j-1];
                else if (a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1))
                    dp[i][j]=(dp[i-1][j] || dp[i][j-1]) ;
            }
        }
        return dp[a.length()][b.length()] ? 1: 0;
    }
}
