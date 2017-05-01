package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Some examples:

isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "a*") → 1
isMatch("aa", ".*") → 1
isMatch("ab", ".*") → 1
isMatch("aab", "c*a*b") → 1
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class Regex2 {
    public int isMatch(final String s, final String p) {
        if(s==null || p==null)
            return 0;
        int m = s.length(), n = p.length();
        boolean[][] match = new boolean[m+1][n+1];
        match[0][0] = true;
        for(int i=1; i<=m; i++)
            match[i][0] = false;
        for(int i=1; i<=n; i++){
            if(p.charAt(i-1) == '*'){
                match[0][i] = ((i-2 >= 0) ? match[0][i-2]:true);
            }else
                match[0][i] = false;
        }
        for(int i=1; i<= m; i++){
            for(int j=1; j<=n; j++){
                if(p.charAt(j-1) == '*'){
                    match[i][j] = match[i][j-2];
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
                        match[i][j] = match[i][j] || match[i-1][j];
                }else{
                    match[i][j] = (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') && match[i-1][j-1];
                }
            }
        }
        return match[m][n] ? 1:0;
    }
}
