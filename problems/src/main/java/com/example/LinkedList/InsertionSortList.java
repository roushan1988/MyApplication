package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */

public class InsertionSortList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode insertionSortList(ListNode a) {
        if (a == null || a.next == null)
            return a;
        ListNode newHead = new ListNode(a.val);
        ListNode pointer = a.next;
        while (pointer != null) {
            ListNode innerPointer = newHead;
            ListNode next = pointer.next;
            if (pointer.val <= newHead.val) {
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            }else{
                while (innerPointer.next != null) {

                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
                        ListNode oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }

                    innerPointer = innerPointer.next;
                }
                if (innerPointer.next == null && pointer.val > innerPointer.val) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }
            pointer = next;
        }
        return newHead;
    }
}
