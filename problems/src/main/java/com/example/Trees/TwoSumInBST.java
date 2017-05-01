package com.example.Trees;

import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes
- Your solution should run in linear time and not take memory more than O(height of T).
- Assume all values in BST are distinct.

Example :

Input 1:

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2:

T:        10
         / \
        9   20

K = 40
Return: 0
 */
public class TwoSumInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int t2Sum(TreeNode A, int B) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode curr1 = A, curr2 = A;

        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;

        while (true){
            while (!done1){
                if(curr1 != null){
                    s1.push(curr1);
                    curr1 = curr1.left;
                }else{
                    if(s1.isEmpty()){
                        done1 = true;
                    }else{
                        curr1 = s1.pop();
                        val1 = curr1.val;
                        done1 = true;
                        curr1 = curr1.right;
                    }
                }
            }

            while (!done2){
                if(curr2 != null){
                    s2.push(curr2);
                    curr2 = curr2.right;
                }else{
                    if(s2.isEmpty()){
                        done2 = true;
                    }else{
                        curr2 = s2.pop();
                        val2 = curr2.val;
                        done2 = true;
                        curr2 = curr2.left;
                    }
                }
            }

            if ((val1 != val2) && (val1 + val2) == B)
            {
                return 1;
            }

            else if ((val1 + val2) < B)
                done1 = false;
            else if ((val1 + val2) > B)
                done2 = false;
            if (val1 >= val2)
                return 0;
        }
    }
}
