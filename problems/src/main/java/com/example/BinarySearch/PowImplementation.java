package com.example.BinarySearch;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
 */
public class PowImplementation {
    public int pow(int x, int n, int d) {
        long result = 1, temp = x; boolean flag = false;
        if(x == 0)
            return 0;
        if(n <0)
            flag = true;
        if(n==0)
            return 1;
        while (n!=0){
            if(n%2 !=0)
                result = Math.floorMod(result * temp,d);
            temp = Math.floorMod(temp * temp,d);
            n = n/2;
            if(result > d)
                result = Math.floorMod(result,d);
        }
        if(flag)
            result = 1/result;
        return ((Long) result).intValue();
    }
}
