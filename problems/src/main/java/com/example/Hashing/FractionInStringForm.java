package com.example.Hashing;

import java.util.HashMap;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class FractionInStringForm {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        if(denominator == 0)
            return "";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder builder = new StringBuilder();
        if ((numerator < 0) && (denominator > 0) || (numerator > 0) && (denominator < 0)) {
            builder.append("-");
        }
        long tempNumerator = Math.abs((long)numerator);
        long tempDenominator = Math.abs((long)denominator);
        long res = tempNumerator/tempDenominator;
        builder.append(String.valueOf(res));
        long remainder = (tempNumerator % tempDenominator) * 10;
        if(remainder == 0)
            return builder.toString();
        builder.append('.');
        while(remainder != 0){
            if(map.containsKey(remainder)){
                int beg = map.get(remainder);
                builder.insert(beg, '(');
                builder.append(')');
                return builder.toString();
            }
            map.put(remainder, builder.length());
            res = remainder/tempDenominator;
            builder.append(String.valueOf(res));
            remainder = (remainder % tempDenominator) * 10;
        }
        return builder.toString();
    }
}
