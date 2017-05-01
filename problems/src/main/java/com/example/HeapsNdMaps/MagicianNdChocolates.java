package com.example.HeapsNdMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given N bags, each bag contains Ai chocolates. There is a kid and a magician.
In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2)
chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7
 */
public class MagicianNdChocolates {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(B.size(), new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        for(int i=0; i<B.size(); i++){
            queue.add(B.get(i));
        }

        long result =0;
        for(int i=0; i<A; i++){
            int max = queue.poll();
            result = Math.floorMod(result + max, (long)Math.pow(10, 9) + 7);
            queue.add(max/2);
        }
        return (int)result;
    }
}
