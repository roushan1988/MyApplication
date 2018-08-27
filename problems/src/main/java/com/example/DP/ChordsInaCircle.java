package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given a number N, return number of ways you can draw N chords in a circle with 2*N points such that no 2 chords intersect.
Two ways are different if there exists a chord which is present in one way and not in other.

For example,

N=2
If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:
{(1-2), (3-4)} and {(1-4), (2-3)}

So, we return 2.
Notes:

1 ≤ N ≤ 1000
Return answer modulo 109+7.

https://www.geeksforgeeks.org/count-ways-divide-circle-using-n-non-intersecting-chords/

 */
public class ChordsInaCircle {
    public int chordCnt(int A) {
        if(A == 0)
            return 1;
        long[] table = new long[A + 1];
        table[0] = 1;
        table[1] = 1;
        for(int i = 2; i <= A; i++) {
            for(int j = 0; j < i; j++) {

                table[i] = table[i] + table[j] * table[i - 1 - j];
                //table[i] = Math.floorMod(table[i] + Math.floorMod(table[j] * table[i - 1 - j], (long)Math.pow(10, 9) + 7), (long)Math.pow(10, 9) + 7);
            }
        }
        return (int)table[A];
    }
}
