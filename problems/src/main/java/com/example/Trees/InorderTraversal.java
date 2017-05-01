package com.example.Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.
 */
public class InorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(a == null)
            return result;
        TreeNode node = a;
        while (node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
