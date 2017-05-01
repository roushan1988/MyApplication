package com.example.Trees;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree.
Example :

Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :
            1
           / \
          2   3
 */
public class ConstructTreeFromInorderAndPreorder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if(inorder == null || inorder.size() == 0 || preorder == null || preorder.size() == 0)
            return null;
        return buildUtil(inorder, 0, inorder.size()-1, preorder, 0, preorder.size() -1);
    }

    private TreeNode buildUtil(ArrayList<Integer> inorder, int inStart, int inEnd, ArrayList<Integer> preorder, int preStart, int preEnd){
        if (inStart > inEnd || preStart > preEnd)
            return null;
        int rootValue = preorder.get(preStart);
        TreeNode root = new TreeNode(rootValue);
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder.get(i) == rootValue){
                k = i;
                break;
            }
        }
        root.left = buildUtil(inorder, inStart, k-1, preorder, preStart + 1, preStart + k - inStart);
        root.right = buildUtil(inorder, k + 1, inEnd, preorder, preStart + k- inStart + 1, preEnd);
        return root;
    }
}
