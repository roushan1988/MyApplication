package com.example.Trees;

import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input :
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST
 */
public class KthSmallestInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while (p!= null){
            stack.push(p);
            p = p.left;
        }
        int i=0;
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            i++;
            if(i == k)
                return t.val;
            TreeNode r = t.right;
            while (r!= null){
                stack.push(r);
                r = r.left;
            }
        }
        return -1;
    }
}
