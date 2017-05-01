package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */

public class Stairs {
    static long[] f;
    public int climbStairs(int a) {
        f = new long[a+2];
        return (int) fib(a+1);
    }

    static long fib(int n)
    {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return (f[n] = 1);
        if (f[n] != 0)
            return f[n];

        int k = ((n & 1) != 0)? (n+1)/2 : n/2;
                                //odd                                 even
        f[n] = ((n & 1) != 0)? (fib(k)* fib(k) + fib(k-1)* fib(k-1)) : (2* fib(k-1) + fib(k))* fib(k);

        return f[n];
    }
}
