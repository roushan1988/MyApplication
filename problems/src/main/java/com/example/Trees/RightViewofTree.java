package com.example.Trees;

public class RightViewofTree {

    class Node {

        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    static int  max_level = 0;

    void rightViewUtil(Node node, int level) {

        // Base Case
        if (node == null)
            return;

        // If this is the last Node of its level
        if (max_level < level) {
            System.out.print(node.data + " ");
            max_level = level;
        }

        // Recur for right subtree first, then left subtree
        rightViewUtil(node.right, level + 1);
        rightViewUtil(node.left, level + 1);
    }

    // A wrapper over rightViewUtil()
    void rightView(Node node) {

        rightViewUtil(node, 1);
    }
}
