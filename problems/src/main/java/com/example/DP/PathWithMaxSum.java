package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class PathWithMaxSum {

    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode a) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateMax(a, max);
        return max[0];
    }
    private int calculateMax(TreeNode node, int[] max){
        if(node == null)
            return 0;
        int left = calculateMax(node.left, max);
        int right = calculateMax(node.right, max);
        int current = Math.max(node.val, Math.max(left+ node.val, right + node.val));
        max[0] =  Math.max(max[0], Math.max(current, node.val + left + right));
        return current;
    }
}
