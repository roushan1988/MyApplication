package com.example.Trees;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an inorder traversal of a cartesian tree, construct the tree.

Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
Note: You may assume that duplicates do not exist in the tree.
Example :

Input : [1 2 3]

Return :
          3
         /
        2
       /
      1
 */

//O(n) http://www.geeksforgeeks.org/cartesian-tree/

public class CartesianTreeInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(ArrayList<Integer> a) {
        if(a == null || a.size() == 0)
            return null;
        TreeNode root = buildTree(a, 0, a.size() -1 );
        return root;
    }

    public TreeNode buildTree(ArrayList<Integer> a, int start, int end){
        if(start > end)
            return null;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=start; i<= end; i++){
            if(max < a.get(i)){
                max = a.get(i);
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(a, start, maxIndex-1);
        root.right = buildTree(a, maxIndex+1, end);
        return root;
    }

}
