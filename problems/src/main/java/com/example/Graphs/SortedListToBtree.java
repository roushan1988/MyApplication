package com.example.Graphs;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */

public class SortedListToBtree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class ListNode {
             public int val;
             public ListNode next;
             ListNode(int x) { val = x; next = null; }
    }

    public TreeNode sortedListToBST(ListNode a) {
        ArrayList<Integer> result = utility(a);
        return sortedListToBST(result, 0, result.size()-1);
    }

    public TreeNode sortedListToBST(ArrayList<Integer> a, int start, int end) {
        if(end < start)
            return null;
        int mid = (start + end)/2;
        TreeNode n = new TreeNode(a.get(mid));
        n.left = sortedListToBST(a, start, mid-1);
        n.right =  sortedListToBST(a, mid+1, end);
        return n;
    }

    private ArrayList<Integer> utility(ListNode start){
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = start;
        while (temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        return arr;
    }
}
