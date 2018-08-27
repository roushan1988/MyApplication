package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */

public class DeleteDuplicates2 {
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode deleteDuplicates(ListNode a) {
        ListNode t = new ListNode(0);
        t.next = a;
        ListNode p = t;
        while (p.next != null && p.next.next != null){ //Loop to check one node at a time
            if(p.next.val == p.next.next.val){
                int duplicate  = p.next.val;
                while(p.next != null && p.next.val == duplicate) //Loop to jump over duplicates
                    p.next = p.next.next;
            }else
                p = p.next;
        }
        return t.next;
    }
}
