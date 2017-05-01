package com.example.Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]
 */
public class ZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result =  new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        ArrayList<Integer> s1List, s2List;
        s1.push(a);

        while (!s1.isEmpty() || !s2.isEmpty()){
            s1List = new ArrayList<>();
            while (!s1.isEmpty()){
                TreeNode temp = s1.pop();
                s1List.add(temp.val);
                if(temp.left != null)
                    s2.push(temp.left);
                if(temp.right != null)
                    s2.push(temp.right);
            }
            if(s1List.size() > 0)
                result.add(s1List);

            s2List = new ArrayList<>();
            while (!s2.isEmpty()){
                TreeNode temp = s2.pop();
                s2List.add(temp.val);
                if(temp.right != null)
                    s1.push(temp.right);
                if(temp.left != null)
                    s1.push(temp.left);
            }
            if(s2List.size() > 0)
                result.add(s2List);
        }
        return result;
    }
}
