package com.example.Strings;

import java.util.ArrayList;
import java.util.List;
// https://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
public class AppendMinCharForPalindrome {

    public int solve(String A) {
        if(A == null || A.length() == 0)
            return 0;
        StringBuilder Abuilder = new StringBuilder(A);
        StringBuilder builder = new StringBuilder(A);
        builder.append('*').append(Abuilder.reverse());
        int[] lps = computeLPS(builder.toString());
        return A.length() - lps[lps.length-1];
    }


    private int[] computeLPS(String text){
        int[] lps = new int[text.length()];
        int len = 0, i=1;
        lps[0] = 0;
        while(i<text.length()){
            if(text.charAt(i) == text.charAt(len)){
                lps[i] = ++len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
