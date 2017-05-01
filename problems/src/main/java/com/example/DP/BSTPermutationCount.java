package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
You are given two positive integers A and B. For all permutations of [1, 2, …, A], we create a BST. Count how many of these have height B.

Notes:
1. Values of a permutation are sequentially inserted into the BST by general rules i.e in increasing order of indices.
2. Height of BST is maximum number of edges between root and a leaf.
3. Return answer modulo 109 + 7.
4. Expected time complexity is worst case O(N4).
5. 1 ≤ N ≤ 50

For example,

A = 3, B = 1

Two permutations [2, 1, 3] and [2, 3, 1] generate a BST of height 1.
In both cases the BST formed is

    2
   / \
  1   3


Another example,
A = 3, B = 2
Return 4.

Next question, can you do the problem in O(N3)?
 */
public class BSTPermutationCount {
}
