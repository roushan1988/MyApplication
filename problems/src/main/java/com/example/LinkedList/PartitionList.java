package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode partition(ListNode a, int b) {
        if(a == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = a;

        ListNode p = a;
        ListNode p1 = fakeHead1;
        ListNode p2 = fakeHead2;

        while(p != null){
            if(p.val < b){
                p = p.next;
                p1 = p1.next;
            }else{
                p2.next = p;
                p1.next = p.next;
                p = p1.next;
                p2 = p2.next;
            }
        }

        p2.next = null;

        p1.next = fakeHead2.next;

        return fakeHead1.next;
    }
}
