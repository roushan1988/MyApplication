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

    https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/

Time Complexity: O(MN)
Auxiliary Space: O(MN)

 */
public class InterleavingString {
    public int isInterleave(String a, String b, String c) {
        // Let us create a 2D table to store solutions of
        // subproblems.  C[i][j] will be true if C[0..i+j-1]
        // is an interleaving of A[0..i-1] and B[0..j-1].
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        // two empty strings have an empty string
        // as interleaving
        dp[0][0] = true;
        // C can be an interleaving of A and B only of sum
        // of lengths of A & B is equal to length of C.
        if(c.length() != a.length() + b.length())
            return 0;
        // A is empty
        for(int i=1; i<= a.length(); i++)
            dp[i][0] = a.charAt(i-1) == c.charAt(i-1) ? true:false;
        // B is empty
        for(int i=1; i<= b.length(); i++)
            dp[0][i] = b.charAt(i-1) == c.charAt(i-1) ? true:false;

        for(int i=1; i<= a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                // Current character of C matches with current character of A,
                // but doesn't match with current character of B
                if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) != c.charAt(i+j-1))
                    dp[i][j] = dp[i-1][j];
                // Current character of C matches with current character of B
                // but doesn't match with current character of A
                else if (a.charAt(i-1) != c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1))
                    dp[i][j] = dp[i][j-1];
                // Current character of C matches with that of both A and B
                else if (a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1))
                    dp[i][j]=(dp[i-1][j] || dp[i][j-1]) ;
            }
        }
        return dp[a.length()][b.length()] ? 1: 0;
    }
}
