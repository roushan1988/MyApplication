package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example :
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.
 */
public class EditDistance {
    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }

        for(int i=1; i<=m; i++)
            dp[i][0] = i; //i deletes

        for(int i=1; i<=n; i++)
            dp[0][i] = i; // i inserts

        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                int replace = 0, insert = 0, delete = 0;
                delete = dp[i][j+1] + 1;
                insert = dp[i+1][j] + 1;
                if(a.charAt(i) == b.charAt(j))
                    replace = dp[i][j];
                else
                    replace = dp[i][j] + 1;
                dp[i+1][j+1] = Math.min(replace, Math.min(insert, delete));
            }
        }
        return dp[m][n];
    }
}
