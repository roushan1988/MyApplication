package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */

public class Merge2SortedLists {
    private static class ListNode {
        public int val;
        public Merge2SortedLists.ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode p=head;
        ListNode p1 = a,  p2 = b;
        while(p1!=null && p2!=null){
            if(p1.val <p2.val) {
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1!=null){
            p.next = p1;
        }

        if(p2!=null){
            p.next = p2;
        }

        return head.next;
    }
}
