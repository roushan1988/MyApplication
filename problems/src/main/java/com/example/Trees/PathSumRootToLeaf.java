package com.example.Trees;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all
the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PathSumRootToLeaf {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int hasPathSum(TreeNode a, int b) {
        if (a == null)
            return 0;
        if (a.val == b && (a.left == null && a.right == null))
            return 1;

        if(hasPathSum(a.left, b - a.val) == 1)
            return 1;
        if(hasPathSum(a.right, b - a.val) == 1)
            return 1;
        return 0;
    }
}
