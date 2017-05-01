package com.example.BitManipulation;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3
 */
public class SingleNumberOthersTwice {
    public int singleNumber(final List<Integer> a) {
        int result = 0;
        int x = 0, sum;
        for (int i=0; i< Integer.SIZE; i++){
            x = 1<<i;
            sum = 0;
            for(int j=0;j<a.size(); j++){
                if ((a.get(j) & x) != 0)
                    sum++;
            }
            if (sum % 2 != 0)
                result |= x;
        }
        return result;
    }
}
