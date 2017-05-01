package com.example.Math;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d]

If a < c OR a==c AND b < d.
 */
public class PrimesSummingToNumber {
    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=2; i<=a/2; i++){
            if(isPrime(i)&&isPrime(a-i)){
                result.add(i);
                result.add(a-i);
                return result;
            }
        }
        return result;
    }

    private static boolean isPrime(int A) {
        if(Math.abs(A)<2) return false;
        int upperLimit = (int)(Math.sqrt(A));
        for (int p = 2; p*p <= A; p++) {
            if (p < A && A % p == 0) return false;
        }
        return true;
    }
}
