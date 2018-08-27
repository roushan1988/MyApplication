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
https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list/
 */
public class FlattenBTreeToList {
    public TreeNode flattenWithStack(TreeNode a) {
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

    // Function to convert binary tree into
// linked list by altering the right node
// and making left node point to NULL
    void flatten(TreeNode root)
    {
        // base condition- return if root is NULL
        // or if it is a leaf node
        if (root == null || root.left == null &&
                root.right == null) {
            return;
        }

        // if root->left exists then we have
        // to make it root->right
        if (root.left != null) {

            // move left recursively
            flatten(root.left);

            // store the node root->right
            TreeNode tmpRight = root.right;
            root.right = root.left;
            root.left = null;

            // find the position to insert
            // the stored value
            TreeNode t = root.right;
            while (t.right != null) {
                t = t.right;
            }

            // insert the stored value
            t.right = tmpRight;
        }

        // now call the same function
        // for root->right
        flatten(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
