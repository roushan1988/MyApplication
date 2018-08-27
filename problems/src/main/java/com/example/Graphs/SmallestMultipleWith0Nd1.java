package com.example.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only.

Since this multiple could be large, return it in form of a string.

Note:
- Returned string should not contain leading zeroes.

For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
For N = 2, 10 is the answer.

https://www.geeksforgeeks.org/find-the-smallest-binary-digit-multiple-of-given-number/

 */
public class SmallestMultipleWith0Nd1 {

    public String getMinimumMultipleOfBinaryDigit(int N)
    {
        Queue<String> q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();

        String t = "1";

        //  In starting push 1 into our queue
        q.offer(t);

        //  loop untill queue is not empty
        while (!q.isEmpty())
        {
            // Take the front number from queue.
            t = q.poll();

            // Find remainder of t with respect to N.
            int rem = mod(t, N);

            // if remainder is 0 then we have
            // found our solution
            if (rem == 0)
                return t;

                // If this remainder is not previously seen,
                // then push t0 and t1 in our queue
            else if(!visit.contains(rem))
            {
                visit.add(rem);
                q.offer(t + "0");
                q.offer(t + "1");
            }
        }
        return null;
    }

    // Method return t % N, where t is stored as
    // a string
    int mod(String t, int N)
    {
        int r = 0;
        for (int i = 0; i < t.length(); i++)
        {
            r = r * 10 + (t.charAt(i) - '0');
            r %= N;
        }
        return r;
    }

    public String multiple(int A) {
        int[]  val = new int[A], parent = new int[A];
        boolean[] marked = new boolean[A];
        int childNode;
        int START = 1;
        String ret="";

        Queue<Integer> queue = new LinkedList<>();

        int remainder=START%A;

        marked[remainder]=true;
        val[remainder]=START;

        queue.add(remainder);

        while (true){
            remainder = queue.poll();
            //p = remainder;
            if(remainder==0)
            {
                ret+=(char)(val[remainder]+'0');
                remainder = parent[remainder];
                while(remainder!=0)
                {
                    ret += (char)(val[remainder]+'0');
                    remainder = parent[remainder];
                }
                StringBuilder builder = new StringBuilder(ret);
                builder.reverse();
                ret = builder.toString();
                return ret;
            }
            childNode=(remainder*10)%A; // left child
            if(!marked[childNode]) {
                queue.add(childNode);
                marked[childNode] = true;
                parent[childNode] = remainder;
                val[childNode] = 0;
            }

            childNode=(remainder*10 + 1)%A; // right child
            if(!marked[childNode]) {
                queue.add(childNode);
                marked[childNode] = true;
                parent[childNode] = remainder;
                val[childNode] = 1;
            }
        }
    }
}
