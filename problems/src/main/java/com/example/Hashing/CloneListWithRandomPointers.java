package com.example.Hashing;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list.
The returned answer should not contain the same node as the original list, but a copy of them.
The pointers in the returned list should not link to any node in the original input list.
 */
public class CloneListWithRandomPointers {
    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            p = p.next;
        }
        return newHead;
    }
}
