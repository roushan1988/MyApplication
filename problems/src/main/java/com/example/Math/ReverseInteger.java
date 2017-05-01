package com.example.Math;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */
public class ReverseInteger {
    public int reverse(int a) {
        boolean flag = false;
        if (a < 0) {
            a = 0 - a;
            flag = true;
        }

        int reverse = 0;
        int p = a;

        while (p > 0) {
            int mod = p % 10;
            p = p / 10;
            if(reverse *10 /10 != reverse)
                return 0;
            reverse = reverse * 10 + mod;
        }
        if (flag) {
            reverse = 0 - reverse;
        }
        return reverse;
    }
}
