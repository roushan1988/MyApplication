package com.example.Graphs;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */

/*
 * How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N ?
 Note : repetition of number is allowed.

 Example:

 N = 4
 Fibonacci numbers : 1 1 2 3 5 .... so on
 here 2 + 2 = 4
 so minimum numbers will be 2
 */


public class FibSum {
    public int fibsum(int a) {
        if(a == 1)
            return 1;
        int f1 = 1;
        int f2 = 1;
        int c = 1;
        ArrayList<Integer> fibNums = new ArrayList<>();
        fibNums.add(1);
        fibNums.add(1);
        while(true){
            c = f1 + f2;
            if(c <= a)
                fibNums.add(c);
            else
                break;
            f1 = f2;
            f2 = c;
        }
        int count = 0;
        int num = a;
        int index = fibNums.size() - 1;
        while(num > 0){
            int fib = fibNums.get(index);
            if(num >= fib){
                count += (num/fib);
                num %= fib;
            }
            index--;
        }
        return count;
    }
}
