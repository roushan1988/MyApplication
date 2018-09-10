package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' : Matches any single character.
'*' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Examples :

isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "*") → 1
isMatch("aa", "a*") → 1
isMatch("ab", "?*") → 1
isMatch("aab", "c*a*b") → 0
Return 1/0 for this problem.

    https://www.geeksforgeeks.org/wildcard-pattern-matching/

    Better : https://www.geeksforgeeks.org/dynamic-programming-wildcard-pattern-matching-linear-time-constant-space/

 */
public class RegexMatch {
    public int isMatch(final String s, final String p) {
        int n = s.length(), m = p.length();
        if (m == 0)
            return (n == 0) ? 1 : 0;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j-1) == '*')
                    // Two cases if we see a '*'
                    // a) We ignore ‘*’ character and move
                    //    to next  character in the pattern,
                    //     i.e., ‘*’ indicates an empty sequence.
                    // b) '*' character matches with ith
                    //     character in input
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1))
                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                    dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = false;
            }
        }
        return dp[n][m] ? 1:0;
    }
}
