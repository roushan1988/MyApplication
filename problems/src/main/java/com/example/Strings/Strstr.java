package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Strstr {
    public int strStr(final String haystack, final String needle) {
        if(haystack.isEmpty() || needle.isEmpty())
            return -1;
        if(haystack == null || needle == null)
            return -1;
        int i, j;
        int n = needle.length();
        int h = haystack.length();

        for(i = 0, j = 0; i < h && j < n; i++){
            if(haystack.charAt(i) == needle.charAt(j))
                j++;
            else{
                i = i - j;
                j = 0;
            }
        }
        if(j == n)
            return i - n;
        else
            return -1;
    }
}
