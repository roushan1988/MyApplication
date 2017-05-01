package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
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
        while (p.next != null && p.next.next != null){
            if(p.next.val == p.next.next.val){
                int duplicate  = p.next.val;
                while(p.next != null && p.next.val == duplicate)
                    p.next = p.next.next;
            }else
                p = p.next;
        }
        return t.next;
    }
}
