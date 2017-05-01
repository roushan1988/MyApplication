package com.example.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list
which is obviously an easier version of this question.
 */
public class ReverseASection {
    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
    public ListNode reverseBetween(ListNode a, int m, int n) {
        if(m==n)
            return a;
        int i=0;
        ListNode prev = null;
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode p = a;
        while(p != null){
            i++;
            if(i==m-1)
                prev = p;
            if(i == m)
                first.next = p;
            if(i==n){
                second.next = p.next;
                p.next = null;
            }
            p = p.next;
        }
        if(first.next == null)
            return a;
        ListNode p1 = first.next;
        ListNode p2 = p1.next;
        p1.next = second.next;
        ListNode temp ;
        while(p1!=null && p2!=null){
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        if(prev!=null)
            prev.next = p1;
        else
            return p1;

        return a;
    }
}
