package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class Reorder {
    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
     }
    private static void reorder(ListNode a){
        if (a != null && a.next != null) {

            ListNode slow = a;
            ListNode fast = a;

            while (fast != null && fast.next != null && fast.next.next!= null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode second = slow.next;
            slow.next = null;

            second = reverseOrder(second);

            ListNode p1 = a;
            ListNode p2 = second;

            while (p2 != null) {
                ListNode temp1 = p1.next;
                ListNode temp2 = p2.next;

                p1.next = p2;
                p2.next = temp1;

                p1 = temp1;
                p2 = temp2;
            }
        }
    }

    private static ListNode reverseOrder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        head.next = null;
        return pre;
    }
}
