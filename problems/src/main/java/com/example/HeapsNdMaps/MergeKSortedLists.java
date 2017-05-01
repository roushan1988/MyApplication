package com.example.HeapsNdMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
public class MergeKSortedLists {
    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if(a.size() == 0)
            return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(a.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for(ListNode listNode : a){
            if(listNode != null)
                priorityQueue.add(listNode);
        }
        ListNode head = new ListNode(0);

        ListNode p = head;
        while (!priorityQueue.isEmpty()){
            ListNode temp = priorityQueue.poll();
            p.next = temp;
            if(temp.next != null){
                priorityQueue.add(temp.next);
            }
            p = p.next;
        }
        return head.next;
    }
}
