package com.example.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Make sure the returned strings are lexicographically sorted.
 */
public class PhoneDigitsToString {
    public ArrayList<String> letterCombinations(String a) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "0");
        map.put(1, "1");
        ArrayList<String> result = new ArrayList<String>();

        if(a == null || a.length() == 0)
            return result;

        StringBuilder temp = new StringBuilder();
        getString(a, temp, result, map);

        return result;
    }

    private static void getString(String digits, StringBuilder temp, List<String> result, Map<Integer, String> map){
        if(digits.length() == 0){
            result.add(temp.toString());
            return;
        }
        Integer curr = Integer.valueOf(digits.substring(0,1));
        String letters = map.get(curr);
        for(int i=0;i<letters.length(); i++){
            temp.append(letters.charAt(i));
            getString(digits.substring(1), temp, result, map);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
