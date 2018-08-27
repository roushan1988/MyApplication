package com.example.Trees;

import java.util.ArrayList;
/*
https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
 */
public class VerticalOrderTraversal {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

    class Values
    {
        int max, min;
    }

    Values val = new Values();
    // A utility function to find min and max distances with respect
    // to root.
    void findMinMax(TreeNode node,Values min, Values max, int hd)
    {
        // Base case
        if (node == null)
            return;

        // Update min and max
        if (hd < min.min)
            min.min = hd;
        else if (hd > max.max)
            max.max = hd;

        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }

    // A utility function to print all nodes on a given line_no.
    // hd is horizontal distance of current node with respect to root.
    void printVerticalLine(TreeNode node, int line_no, int hd, ArrayList<Integer> row)
    {
        // Base case
        if (node == null)
            return;

        // If this node is on the given line number
        if (hd == line_no)
            row.add(node.val);

        // Recur for left and right subtrees
        printVerticalLine(node.left, line_no, hd - 1, row);
        printVerticalLine(node.right, line_no, hd + 1, row);
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Find min and max distances with resepect to root
        findMinMax(A, val, val, 0);

        // Iterate through all possible vertical lines starting
        // from the leftmost line and print nodes line by line
        ArrayList<Integer> row ;
        for (int line_no = val.min; line_no <= val.max; line_no++)
        {
            row = new ArrayList<>();
            printVerticalLine(A, line_no, 0, row);
            result.add(row);
        }
        return result;
    }
}
