package com.example.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

 Food for thought :
* Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.

You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3]

Output:[3, 4]

A = 3, B = 4
*/

public class RepeatNdMissing {
    static void printTwoElements(int arr[], int size)
    {
        int i;
        System.out.print("The repeating element is ");

        for(i = 0; i < size; i++)
        {
            if(arr[Math.abs(arr[i])-1] > 0)
                arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
            else
                System.out.println(Math.abs(arr[i]));
        }

        System.out.print("And the missing element is ");
        for(i = 0; i < size; i++)
        {
            if(arr[i] > 0)
                System.out.println(i + 1);
        }
    }

    //XOR

    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> ret = new ArrayList<>();
        int xor = 0, x = 0, y = 0;
        for(int i=0; i<a.size(); i++) {
            xor ^= a.get(i);
        }
        for(int i=1; i<=a.size(); i++) {
            xor ^= i;
        }
        //Evaluating the rightmost set bit
        int setBit = xor & ~(xor-1);
        for(int i=0; i<a.size(); i++) {
            if((a.get(i) & setBit) != 0) {
                x ^= a.get(i);
            } else {
                y ^= a.get(i);
            }
        }
        for(int i=1; i<=a.size(); i++) {
            if((i & setBit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        for(int i=0; i<a.size(); i++) {
            if(a.get(i) == x) {
                ret.add(x);
                ret.add(y);
                return ret;
            }

            if(a.get(i) == y) {
                ret.add(y);
                ret.add(x);
                return ret;
            }
        }

        return ret;
    }
}
