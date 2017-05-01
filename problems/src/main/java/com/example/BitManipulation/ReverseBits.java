package com.example.BitManipulation;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000
=>        00000000000000000000000000000000
return 0

Example 2:

x = 3,

          00000000000000000000000000000011
=>        11000000000000000000000000000000
return 3221225472

Since java does not have unsigned int, use long
 */
public class ReverseBits {
    public long reverse(long a) {
        for (int i = 0; i < 16; i++) {
            a = swapBits(a, i, 32 - i - 1);
        }

        return a;
    }

    private static long swapBits(long n, int i, int j) {
        long a = (n >> i) & 1L;
        long b = (n >> j) & 1L;

        if ((a ^ b) != 0) {
            return n ^= (1L << i) | (1L << j);
        }
        return n;
    }
}
