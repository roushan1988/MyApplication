package com.example.Hashing;

import java.util.HashMap;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */
public class MinWindowToContainString {
    public String minWindow(String mainString, String subsequence) {
        if(subsequence==null || mainString== null || subsequence.length()>mainString.length())
            return "";
        String result = "";
        HashMap<Character, Integer> target = new HashMap<>();
        for(int i=0; i<subsequence.length(); i++){
            char c = subsequence.charAt(i);
            if(target.containsKey(c)){
                target.put(c,target.get(c)+1);
            }else{
                target.put(c,1);
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int minLen = mainString.length()+1;
        int count = 0;
        for(int i=0; i<mainString.length(); i++){
            char c = mainString.charAt(i);
            if(target.containsKey(c)){
                if(map.containsKey(c)){
                    if(map.get(c)<target.get(c)){
                        count++;
                    }
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                    count++;
                }
            }
            if(count == subsequence.length()){ //a soln possible
                char sc = mainString.charAt(left);
                while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) { //character at left should be ignored
                    if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                        map.put(sc, map.get(sc) - 1);
                    left++;
                    if(left >= mainString.length())
                        break;
                    else
                        sc = mainString.charAt(left);
                }

                if(left >= mainString.length())
                    break;

                if (i - left + 1 < minLen) {
                    result = mainString.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }
        return result;
    }
}
