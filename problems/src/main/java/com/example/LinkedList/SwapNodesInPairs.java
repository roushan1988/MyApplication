package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode swapPairs(ListNode a) {
        if(a == null || a.next == null)
            return a;
        ListNode h = new ListNode(0);
        h.next = a;
        ListNode p = h;
        while (p.next != null && p.next.next != null){
            ListNode t1 = p;
            p = p.next;
            t1.next = p.next;

            ListNode t2 = p.next.next;
            p.next.next = p;
            p.next = t2;
        }
        return h.next;
    }
}
