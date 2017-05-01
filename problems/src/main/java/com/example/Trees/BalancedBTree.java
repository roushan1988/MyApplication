package com.example.Trees;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input :
          1
         / \
        2   3

Return : True or 1

Input 2 :
         3
        /
       2
      /
     1

Return : False or 0
         Because for the root node, left subtree has depth 2 and right subtree has depth 0.
         Difference = 2 > 1.
 */
public class BalancedBTree {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int isBalanced(TreeNode a) {
        if(checkHeight(a) == -1)
            return 0;
        return 1;
    }

    private static int checkHeight(TreeNode a){
        if(a == null)
            return 0;
        int leftHeight = checkHeight(a.left);
        if(leftHeight == -1)
            return -1;

        int rightHeight = checkHeight(a.right);
        if(rightHeight == -1)
            return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) +1;
    }
}
