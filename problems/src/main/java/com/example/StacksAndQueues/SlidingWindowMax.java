package com.example.StacksAndQueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/6/17.
 */

public class SlidingWindowMax {
    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(a == null || a.isEmpty())
            return result;
        LinkedList<Integer> dequeue = new LinkedList<Integer>();
        for(int i=0; i<a.size(); i++){
            if(!dequeue.isEmpty() && dequeue.peekFirst() == i-b)
                dequeue.removeFirst();

            while (!dequeue.isEmpty() && a.get(dequeue.peekLast()) < a.get(i))
                dequeue.removeLast();

            dequeue.addLast(i);
            if(i+1 >= b)
                result.add(i+1-b, a.get(dequeue.peek()));
        }
        if(result.isEmpty() && !dequeue.isEmpty())
            result.add(a.get(dequeue.peek()));
        return result;
    }
}
