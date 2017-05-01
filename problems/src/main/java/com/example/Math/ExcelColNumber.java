package com.example.Math;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1

    B -> 2

    C -> 3

    ...

    Z -> 26

    AA -> 27

    AB -> 28
 */
public class ExcelColNumber {
    public int titleToNumber(String a) {
        int result = 0;
        int length = a.length();
        for(int i=0; i<a.length(); i++){
            int value = (int)a.charAt(i);
            result += Math.pow(26, --length)*(value-64);
        }
        return result;
    }
}
