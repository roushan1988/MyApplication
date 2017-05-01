package com.example.Backtracking;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
 */
public class Parentheses {
    public ArrayList<String> generateParenthesis(int a) {
        ArrayList<String> result = new ArrayList<>();
        addParen(result, new StringBuilder(), a, a, 0);
        return result;
    }
    private static void addParen(ArrayList<String> result, StringBuilder temp, int leftRem, int rightRem, int positionCount){
        if(leftRem < 0 || rightRem < leftRem)
            return;
        if(leftRem == 0 && rightRem ==0) {
            result.add(temp.toString());
            return;
        }
        if(leftRem >0){
            temp.append("(");
            addParen(result, temp, leftRem-1, rightRem, positionCount+1);
            temp.deleteCharAt(temp.length()-1);
        }
        if(rightRem >0){
            temp.append(")");
            addParen(result, temp, leftRem, rightRem-1, positionCount+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
