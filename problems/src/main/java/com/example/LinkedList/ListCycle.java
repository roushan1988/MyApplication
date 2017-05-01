package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input :

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3.
 */
public class ListCycle {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;

        boolean hasCycle = false;
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle) return null;

        else{
            fast = a;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
