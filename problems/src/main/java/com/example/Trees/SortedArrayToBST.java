package com.example.Trees;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example :


Given A : [1, 2, 3]
A height balanced BST  :

      2
    /   \
   1     3

 */
public class SortedArrayToBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return createBST(a, 0, a.size() - 1);
    }

    private TreeNode createBST(final List<Integer> a, int start, int end){
        if(end < start)
            return null;
        int mid  = (start + end)/2;
        TreeNode n = new TreeNode(a.get(mid));
        n.left = createBST(a, start, mid - 1);
        n.right = createBST(a, mid + 1, end);
        return n;
    }
}
