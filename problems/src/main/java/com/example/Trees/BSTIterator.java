package com.example.Trees;

import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity.
 */
public class BSTIterator {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while (p != null){
            stack.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode t = stack.pop();
        int res = t.val;
        t = t.right;
        while (t != null){
            stack.push(t);
            t = t.left;
        }
        return res;
    }
}
