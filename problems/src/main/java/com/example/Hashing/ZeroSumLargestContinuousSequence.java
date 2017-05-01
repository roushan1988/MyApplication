package com.example.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
public class ZeroSumLargestContinuousSequence {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLength  = Integer.MIN_VALUE;
        for(int i = 0; i < a.size(); i++){
            sum += a.get(i);

            if(map.get(sum) != null){
                if(maxLength < (i - map.get(sum))){
                    start = map.get(sum) + 1;
                    end = i;
                    maxLength = i - map.get(sum);
                }
            }
            else
                map.put(sum, i);
        }
        if(start >= 0 && end >= 0){
            for(int i = start; i <= end; i++){
                result.add(a.get(i));
            }
        }
        return result;
    }
}
