package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */

public class PalindromeSinglyList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public int lPalin(ListNode A) {
        if(A == null || A.next==null)
            return 1;

        ListNode fast = A;
        ListNode slow = A;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode prev = secondHead;
        ListNode curr = prev.next;

        while(prev!=null && curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        secondHead.next = null;

        ListNode p = (curr==null ? prev:curr);
        ListNode q = A;
        while(p!=null){
            if(p.val != q.val)
                return 0;

            p = p.next;
            q = q.next;

        }

        return 1;
    }
}
