package com.example.Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree, return the postorder traversal of its nodes’ values.

Example :

Given binary tree

   1
    \
     2
    /
   3
return [3,2,1].

Using recursion is not allowed.
 */
public class PostOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = a;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                if(root.right != null)
                    stack.push(root.right);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                if(root != null && !stack.isEmpty() && stack.peek() == root.right){
                    TreeNode rightNode = stack.pop();
                    stack.push(root);
                    root = rightNode;
                }else{
                    result.add(root.val);
                    root = null;
                }
            }
        }
        return result;
    }
}
