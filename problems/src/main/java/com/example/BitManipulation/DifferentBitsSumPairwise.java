package com.example.BitManipulation;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively.
The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN.
Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

For example,

A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) +
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8
 */
public class DifferentBitsSumPairwise {
    public int cntBits(ArrayList<Integer> A) {
        long modulo = (long) Math.pow(10, 9) + 7;
        long result = 0, count, x=0;
        for(int i=0; i<Integer.SIZE; i++){
            count = 0;
            x = 1<< i;
            for(int j =0;j<A.size(); j++){
                if((x & A.get(j)) != 0)
                    count++;
            }
            result += Math.floorMod(count * (A.size() - count)*2, modulo);
        }
        return (int)Math.floorMod(result, modulo);
    }

    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> result = new ArrayList<>(A);
        for (int i=1; i<=A; i++)
        {
            // number divisible by 5, print 'Buzz'
            // in place of the number
            if (i%15==0)
                result.add("FizzBuzz"+"");


                // number divisible by 3, print 'Fizz'
                // in place of the number
            else if (i%3==0)
                result.add("Fizz"+"");

                // number divisible by 15(divisible by
                // both 3 & 5), print 'FizzBuzz' in
                // place of the number
            else if (i%5==0)
                result.add("Buzz"+"");

            else  // print the numbers
                result.add(i+"");
        }
        return result;
    }

}
