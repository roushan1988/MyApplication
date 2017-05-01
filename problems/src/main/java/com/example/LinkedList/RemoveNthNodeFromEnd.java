package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */

public class RemoveNthNodeFromEnd {
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode removeNthFromEnd(ListNode a, int b) {
        if(a==null)
            return null;
        ListNode fast = a, slow = a;
        for(int i=0; i<b; i++) {
            fast = fast.next;
            if(fast == null) {
                a = a.next;
                return a;
            }
        }

        if(fast == null) {
            a = a.next;
            return a;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return a;
    }
}
