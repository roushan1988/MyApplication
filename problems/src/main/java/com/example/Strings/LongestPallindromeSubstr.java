package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"
 */
public class LongestPallindromeSubstr {
    public String longestPalindrome(String a) {
        int C = 1;
        int R = 2, iLeftMirror;
        int n = 2 * a.length() +1;
        int[] L = new int[n];
        L[0] = 0;
        L[1] = 1;
        int maxLPSCenter = 0, maxLPSLength = 1;
        for(int i=2;i<n; i++){
            L[i] = 0;
            iLeftMirror = 2*C - i;
            if(i < R)
                L[i] = Math.min(L[iLeftMirror], R-i);
            while ( ((i + L[i]) < n - 1 && (i - L[i]) > 0) &&
                    ( ((i + L[i] + 1) % 2 == 0) ||
                            (a.charAt((i + L[i] + 1)/2) == a.charAt((i - L[i] - 1)/2) )))
            {
                L[i]++;
            }

            if(L[i] > maxLPSLength){
                maxLPSCenter = i;
                maxLPSLength = L[i];
            }

            if(i + L[i] > R){
                C = i;
                R = i + L[i];
            }

        }
        int start = (maxLPSCenter - maxLPSLength)/2;
        int end = start + maxLPSLength;
        return a.substring(start, end);
    }
}
