package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */

public class DeleteDuplicatesFromSortedList {
    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode deleteDuplicates(ListNode a) {
        if(a == null || a.next == null)
            return a;
        ListNode p = a;
        while (p != null && p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else
                p = p.next;
        }
        return a;
    }
}
