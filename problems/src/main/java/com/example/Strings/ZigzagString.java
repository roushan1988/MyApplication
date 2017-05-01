package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.
 */
public class ZigzagString {
    public String convert(String a, int b) {
        if(b == 1)
            return a;
        StringBuilder result = new StringBuilder();
        int n = 2*(b - 1);
        for(int i = 0; i < b; i++){
            int cur = i;
            while(cur < a.length()){
                result.append(a.charAt(cur));
                cur += n;
                if(i > 0 && i < b - 1 && (cur-i-i) < a.length()){
                    result.append(a.charAt(cur - i - i));
                }
            }
        }
        return result.toString();
    }
}
