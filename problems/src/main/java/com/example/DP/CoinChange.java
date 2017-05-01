package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).


 */
public class CoinChange {
    public int coinchange2(ArrayList<Integer> a, int b) {
        long[] table = new long[b+1];

        table[0] = 1;
        for (int i=0; i<a.size(); i++)
            for (int j=a.get(i); j<=b; j++)
                table[j] = Math.floorMod(table[j] +  table[j-a.get(i)], 1000007);

        return (int)table[b];
    }
}
