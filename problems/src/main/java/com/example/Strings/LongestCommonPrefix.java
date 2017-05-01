package com.example.Strings;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> a) {
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < a.size(); i++){
            if(minLen > a.get(i).length())
                minLen = a.get(i).length();
        }
        if(minLen == 0)
            return "";
        for(int j = 0; j < minLen; j++){
            char prev = '0';
            for(int i = 0; i < a.size(); i++){
                if(i == 0){
                    prev = a.get(i).charAt(j);
                    continue;
                }
                if(a.get(i).charAt(j) != prev)
                    return a.get(i).substring(0, j);
            }
        }
        return a.get(0).substring(0, minLen);
    }
}
