package com.example.Hashing;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array A of integers and another non negative integer k,
find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
 */
public class DiffK {
    public int diffPossible(final List<Integer> a, int b) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < a.size(); i++){
            Integer diff1 = b + a.get(i), diff2 = a.get(i) -b;
            if(hash.containsKey(diff1) || hash.containsKey(diff2)){
                return 1;
            }
            hash.put(a.get(i), i);
        }
        return 0;
    }
}
