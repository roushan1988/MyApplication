package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
 */
public class Sort {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode sortList(ListNode a) {
        if (a == null || a.next == null)
            return a;
        int count = 0;
        ListNode p = a;
        while (p != null) {
            count++;
            p = p.next;
        }
        ListNode l = a, r = null;
        ListNode p2 = a;
        int countHalf = 0;
        while (p2 != null) {
            countHalf++;
            ListNode next = p2.next;
            if (countHalf == count/2) {
                p2.next = null;
                r = next;
            }
            p2 = next;
        }
        ListNode h1 = sortList(l);
        ListNode h2 = sortList(r);
        return merge(h1, h2);
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode p1 = l;
        ListNode p2 = r;

        ListNode mergedHead = new ListNode(0);
        ListNode pNew = mergedHead;

        while (p1 != null || p2 != null) {

            if (p1 == null) {
                pNew.next = new ListNode(p2.val);
                p2 = p2.next;
                pNew = pNew.next;
            } else if (p2 == null) {
                pNew.next = new ListNode(p1.val);
                p1 = p1.next;
                pNew = pNew.next;
            } else {
                if (p1.val < p2.val) {
                    pNew.next = new ListNode(p1.val);
                    p1 = p1.next;
                    pNew = pNew.next;
                } else if (p1.val == p2.val) {
                    pNew.next = new ListNode(p1.val);
                    pNew.next.next = new ListNode(p1.val);
                    pNew = pNew.next.next;
                    p1 = p1.next;
                    p2 = p2.next;

                } else {
                    pNew.next = new ListNode(p2.val);
                    p2 = p2.next;
                    pNew = pNew.next;
                }
            }
        }
        return mergedHead.next;
    }
}
