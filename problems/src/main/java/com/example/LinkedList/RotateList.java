package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
    public ListNode rotateRight(ListNode a, int b) {
        if (a == null || b == 0)
            return a;
        ListNode slow = a;
        ListNode fast = a;
        while (b > 0) {
            b--;
            fast = fast.next;
            if (fast == null)
                fast = a;
        }
        if (fast == null || slow == fast)
            return a;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = a;
        return newHead;
    }
}
