package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

Example :

Given A = 3, there are a total of 5 unique BST’s.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBSTs {
    public int numTrees(int a) {
        int[] count = new int[a + 1];

        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= a; i++) {
            for (int j = 0; j <= i - 1; j++) {
                count[i] = count[i] + count[j] * count[i - j - 1];
            }
        }

        return count[a];
    }
}
