package com.example.Trees;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

 Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
Example :


Input :
         1
        / \
       2   3

Output :
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST
 */
public class RecoverSwappedBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ArrayList<Integer> recoverTree(TreeNode a) {
        recoverTreeHelper(a);
        result.add(first.val);
        result.add(second.val);
        Collections.sort(result);
        return result;
    }

    ArrayList<Integer> result = new ArrayList<Integer>();
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTreeHelper(TreeNode node) {
        if(node == null){
            return;
        }
        else{
            recoverTreeHelper(node.left);
            if(pre == null)
                pre = node;
            else{
                if(pre.val > node.val){
                    if(first == null){
                        first = pre;
                    }
                    second = node;
                }
                pre = node;
            }
            recoverTreeHelper(node.right);
        }
    }
}
