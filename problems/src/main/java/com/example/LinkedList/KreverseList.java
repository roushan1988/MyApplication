package com.example.LinkedList;
/*
Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.
 */
public class KreverseList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < B && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            A.next = reverseList(next, B);

        // prev is now head of input list
        return prev;
    }
}
