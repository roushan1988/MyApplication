package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20
 */
public class RomanToInt {
    public int romanToInt(String a) {
        int result = 0;

        for(int i = 0; i < a.length(); i++){
            if(i>0 && getIntValue(a.charAt(i)) > getIntValue(a.charAt(i-1)))
                result = result + getIntValue(a.charAt(i)) - 2 *getIntValue(a.charAt(i-1));
            else
                result += getIntValue(a.charAt(i));
        }
        return result;
    }

    private static int getIntValue(char c){
        switch(c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
