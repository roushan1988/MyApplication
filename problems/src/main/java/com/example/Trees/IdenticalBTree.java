package com.example.Trees;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :

   1       1
  / \     / \
 2   3   2   3

Output :
  1 or True
 */
public class IdenticalBTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return 1;
        if (a != null && b != null)
            return (a.val == b.val
                    && isSameTree(a.left, b.left) == 1
                    && isSameTree(a.right, b.right) == 1 ? 1 : 0);

        return 0;
    }

}
