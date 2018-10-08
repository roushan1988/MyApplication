package com.example.Trees;


/*
Given n appointments, find all conflicting appointments.

Examples:

Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}}
Output: Following are conflicting intervals
[3,7] Conflicts with [1,5]
[2,6] Conflicts with [1,5]
[5,6] Conflicts with [3,7]
[4,100] Conflicts with [1,5]
An appointment is conflicting, if it conflicts with any of the previous appointments in array.

 */
public class ConflictingAppointments {
    // Structure to represent an interval
    class Interval
    {
        int low, high;
    };

    // Structure to represent a node in Interval Search Tree
    class ITNode
    {
        Interval i;  // 'i' could also be a normal variable
        int max;
        ITNode left, right;
    };

// A utility function to create a new Interval Search Tree Node
    ITNode newNode(Interval i)
    {
        ITNode temp = new ITNode();
        temp.i = i;
        temp.max = i.high;
        temp.left = temp.right = null;
        return temp;
    }

    // A utility function to insert a new Interval Search Tree
// Node. This is similar to BST Insert.  Here the low value
//  of interval is used tomaintain BST property
    ITNode insert(ITNode root, Interval i)
    {
        // Base case: Tree is empty, new node becomes root
        if (root == null)
            return newNode(i);

        // Get low value of interval at root
        int l = root.i.low;

        // If root's low value is smaller, then new interval
        //  goes to left subtree
        if (i.low < l)
            root.left = insert(root.left, i);

            // Else, new node goes to right subtree.
        else
            root.right = insert(root.right, i);

        // Update the max value of this ancestor if needed
        if (root.max < i.high)
            root.max = i.high;

        return root;
    }

    // A utility function to check if given two intervals overlap
    boolean doOVerlap(Interval i1, Interval i2)
    {
        if (i1.low < i2.high && i2.low < i1.high)
            return true;
        return false;
    }

    // The main function that searches a given interval i
    // in a given Interval Tree.
    Interval overlapSearch(ITNode root, Interval i)
    {
        // Base Case, tree is empty
        if (root == null) return null;

        // If given interval overlaps with root
        if (doOVerlap((root.i), i))
        return root.i;

        // If left child of root is present and max of left child
        // is greater than or equal to given interval, then i may
        // overlap with an interval is left subtree
        if (root.left != null && root.left.max >= i.low)
            return overlapSearch(root.left, i);

        // Else interval can only overlap with right subtree
        return overlapSearch(root.right, i);
    }

    // This function prints all conflicting appointments in a given
// array of apointments.
    void printConflicting(Interval appt[], int n)
    {
        // Create an empty Interval Search Tree, add first
        // appointment
        ITNode root = null;
        root = insert(root, appt[0]);

        // Process rest of the intervals
        for (int i=1; i<n; i++)
        {
            // If current appointment conflicts with any of the
            // existing intervals, print it
            Interval res = overlapSearch(root, appt[i]);

            if (res != null)
                System.out.print("[" + appt[i].low + "," + appt[i].high + "] Conflicts with [" + res.low  + "," + res.high + "]\n");

            // Insert this appointment
            root = insert(root, appt[i]);
        }
    }
}
