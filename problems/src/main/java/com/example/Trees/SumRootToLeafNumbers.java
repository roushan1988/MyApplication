package com.example.Trees;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 */
public class SumRootToLeafNumbers {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode a) {
        if(a == null)
            return 0;
        long sum = sumNumUtil(a, 0, 0);
        return (int)Math.floorMod(sum, 1003);
    }

    public long sumNumUtil(TreeNode node, long num, long sum){
        if(node == null)
            return sum;
        num = Math.floorMod(Math.floorMod(num * 10, 1003) + node.val, 1003);
        if(node.left == null && node.right == null){
            sum = Math.floorMod(sum + num, 1003);
            return sum;
        }
        sum = Math.floorMod(sumNumUtil(node.left, num, sum) + sumNumUtil(node.right, num, sum), 1003);
        return sum;
    }
}
