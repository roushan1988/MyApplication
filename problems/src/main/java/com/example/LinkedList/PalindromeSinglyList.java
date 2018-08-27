package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 *
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

 Notes:

 Expected solution is linear in time and constant in space.
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
        //slow should be the center of the list now
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
