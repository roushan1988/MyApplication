package com.example.Trees;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree, find its maximum depth.

The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node.
Example :

         1
        /
       2
max depth = 2.
 */
public class MaxDepthOfBTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode a) {
        if(a == null)
            return 0;
        return Math.max(maxDepth(a.left), maxDepth(a.right)) + 1;
    }
}
