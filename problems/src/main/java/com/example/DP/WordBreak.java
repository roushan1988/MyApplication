package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class WordBreak {
    public int wordBreak(String a, ArrayList<String> b) {
        boolean[] t = new boolean[a.length() + 1];
        t[0] = true;

        for(int i = 0; i < a.length(); i++){
            if(!t[i])
                continue;
            for(String word : b){
                int length = word.length();
                int end = i + length;
                if(end > a.length())
                    continue;
                if(t[end])
                    continue;
                if(a.substring(i, end).equals(word))
                    t[end] = true;
            }
        }
        return t[a.length()]?1:0;
    }
}
