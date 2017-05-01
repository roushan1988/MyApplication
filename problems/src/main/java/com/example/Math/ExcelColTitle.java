package com.example.Math;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
 */
public class ExcelColTitle {
    public String convertToTitle(int a) {
        StringBuilder builder = new StringBuilder();
        while(a > 0){
            a--;
            char ch = (char) (a % 26 + 'A');
            a /= 26;
            builder.append(ch);
        }
        builder.reverse();
        return builder.toString();
    }
}
