package com.example.BitManipulation;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4
 */
public class SingleNumberOthersThrice {
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
            if (sum % 3 != 0)
                result |= x;
        }
        return result;
    }
}
