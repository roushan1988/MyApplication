package com.example.Trees;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class AllPathsSumRootToLeaf {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(root == null)
            return null;
        pathSum(root, sum, result, temp);
        return result;
    }
    public void pathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if(node == null)
            return;
        int currentVal = node.val;
        temp.add(currentVal);
        if(node.left == null && node.right == null){
            if(sum - currentVal == 0){
                result.add(new ArrayList<>(temp));
            }
        }
        pathSum(node.left, sum - node.val, result, temp);
        pathSum(node.right, sum - node.val, result, temp);
        temp.remove(temp.size() - 1);

    }
}
