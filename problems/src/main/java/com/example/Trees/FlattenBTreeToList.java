package com.example.Trees;

import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
 */
public class FlattenBTreeToList {
    public TreeNode flatten(TreeNode a) {
        TreeNode result = new TreeNode(0);
        TreeNode node = result;
        if(a== null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(a);
        while (!stack.isEmpty()){
            TreeNode popped = stack.pop();
            node.right = popped;
            node.left = null;
            node = node.right;

            if(popped.right != null){
                stack.push(popped.right);
            }
            if(popped.left != null)
                stack.push(popped.left);
        }

        return result.right;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
