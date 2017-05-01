package com.example.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, return it in form of a string.

Note:
- Returned string should not contain leading zeroes.

 */
public class SmallestMultipleWith0Nd1 {
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
