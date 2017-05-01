package com.example.Arrays;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time
using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
 */
public class DuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
        if(a.size()<1)
            return -1;
        int i; int n = a.size()-1;
        boolean[] bool = new boolean[n];
        Integer[] inputArr = new Integer[a.size()]/*= {3,4,1,4,1}*/;
        inputArr = a.toArray(inputArr);
        for(i=0; i<inputArr.length; i++){
            int position = inputArr[i] -1;
            if(!bool[position])
                bool[position] = true;
            else {
                return inputArr[i];
            }
        }

        return -1;
    }
}
