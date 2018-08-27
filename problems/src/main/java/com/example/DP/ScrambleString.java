package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. Return 0/1 for this problem.
 */
public class
ScrambleString {
    public int isScramble(final String a, final String b) {
        if (a.length() != b.length())
            return 0;
        if (a.equals(b))
            return 1;

        int L = a.length();
        boolean[][][] scramble = new boolean[L][L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++)
                if (a.charAt(i) == b.charAt(j))
                    scramble[0][i][j] = true;
        }

        for (int k = 2; k <= L; k++) {
            for (int i = L - k; i >= 0; i--) {
                for (int j = L - k; j >= 0; j--) {
                    boolean canScramble = false;
                    for (int m = 1; m < k; m++) {
                        canScramble = (scramble[m - 1][i][j]
                                && scramble[k - m - 1][i + m][j + m])
                                || (scramble[m - 1][i][j + k -m]
                                && scramble[k - m - 1][i + m][j]);
                        if (canScramble)
                            break;
                    }
                    scramble[k - 1][i][j] = canScramble;
                }
            }
        }

        return scramble[L - 1][0][0] ?1:0;
    } 
}
