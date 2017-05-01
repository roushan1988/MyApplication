package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
 */
public class AtoI {
    public int atoi(final String a) {
        if(a == null || a.length() == 0)
            return 0;
        String trimmedA = a.trim();
        double result = 0;
        int flag = 0;
        int i = 0;
        if(trimmedA.charAt(0) == '-'){
            flag = 1;
            i++;
        }
        else if(trimmedA.charAt(0) == '+')
        {
            i++;
        }
        while(i < trimmedA.length() && trimmedA.charAt(i) >= '0' && trimmedA.charAt(i) <= '9'){
            result = result*10 + (trimmedA.charAt(i) - '0');
            i++;
        }
        if(flag == 1)
            result = -result;
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;
    }
}
