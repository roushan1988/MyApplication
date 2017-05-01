package com.example.Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

Using recursion is not allowed.

 */
public class PreOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(a == null)
            return result;
        stack.push(a);
        while (!stack.isEmpty()){
            TreeNode popped = stack.pop();
            result.add(popped.val);
            if(popped.right != null)
                stack.push(popped.right);
            if(popped.left != null)
                stack.push(popped.left);
        }
        return result;
    }
}
