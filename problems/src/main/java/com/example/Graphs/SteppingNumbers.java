package com.example.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12
Return the numbers in sorted order.
 */
public class SteppingNumbers {
    public ArrayList<Integer> stepnum(int a, int b) {
        ArrayList<Integer> steppingNumbers = new ArrayList<>();
        Queue<Integer> bfsQ = new LinkedList<>();
        if(a == 0)
            steppingNumbers.add(a);
        for(int i=1; i<=9; i++){
            bfsQ.add(i);
        }
        int steppingNum = bfsQ.poll();
        while (steppingNum <= b){
            if(steppingNum >= a && steppingNum <= b)
                steppingNumbers.add(steppingNum);
            int lastDigit = steppingNum%10;
            int steppingNext1 = steppingNum*10 + lastDigit-1;
            int steppingNext2 = steppingNum*10 + lastDigit+1;
            if(lastDigit == 0)
                bfsQ.add(steppingNext2);
            else if(lastDigit ==9)
                bfsQ.add(steppingNext1);
            else{
                bfsQ.add(steppingNext1);
                bfsQ.add(steppingNext2);
            }
            steppingNum = bfsQ.poll();
        }
        Collections.sort(steppingNumbers);
        return steppingNumbers;
    }
}
