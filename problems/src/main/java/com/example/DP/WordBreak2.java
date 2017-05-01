package com.example.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given

s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is
 [ "cats and dog", "cat sand dog" ]

Make sure the strings are sorted in your result.
 */

// http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
public class WordBreak2 {
    public ArrayList<String> wordBreak(String a, ArrayList<String> b) {
        ArrayList<String>[] dp = new ArrayList[a.length() + 1];
        dp[0] = new ArrayList<>();
        for(int i = 0; i <= a.length(); i++){
            if(dp[i] == null)
                continue;
            for(String word : b){
                int length = word.length();
                int end = i + length;

                if(end > a.length())
                    continue;
                if(a.substring(i, end).equals(word)){
                    if(dp[end] == null)
                        dp[end] = new ArrayList<>();
                    dp[end].add(word);
                }
            }
        }
        ArrayList<String> result2 = new ArrayList<>();
        HashSet<String> result = new HashSet<>();
        if(dp[a.length()] == null)
            return result2;
        ArrayList<String> temp = new ArrayList<>();
        dfs(dp, a.length(), result, temp);

        for(String s : result)
            result2.add(s);
        Collections.sort(result2);
        return result2;
    }

    public static void dfs(ArrayList<String>[] dp, int end, HashSet<String> result, ArrayList<String> temp){
        if(end <= 0){
            String path = temp.get(temp.size() - 1);
            for(int i = temp.size() - 2; i >=0; i--)
                path +=  " " + temp.get(i);
            result.add(path);
            return;
        }

        for(String str : dp[end]){
            temp.add(str);
            dfs(dp, end - str.length(), result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
