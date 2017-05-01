package com.example.Trees;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree.
Example :

Input :
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

Return :
            1
           / \
          2   3
 */
public class ConstructTreeFromInorderAndPostOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if(inorder == null || inorder.size() == 0 || postorder == null || postorder.size() == 0)
            return null;
        return buildUtil(inorder, 0, inorder.size()-1, postorder, 0, postorder.size() -1);
    }

    private TreeNode buildUtil(ArrayList<Integer> inorder, int inStart, int inEnd,
                               ArrayList<Integer> postorder, int postStart, int postEnd){
        if (inStart > inEnd || postStart > postEnd)
            return null;
        int rootValue = postorder.get(postEnd);
        TreeNode root = new TreeNode(rootValue);
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder.get(i) == rootValue){
                k = i;
                break;
            }
        }
        root.left = buildUtil(inorder, inStart, k-1,
                           postorder, postStart, postStart + k - inStart - 1);
        root.right = buildUtil(inorder, k + 1, inEnd,
                                postorder, postStart + k- inStart, postEnd - 1);
        return root;
    }
}
