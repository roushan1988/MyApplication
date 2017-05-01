package com.example.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
 */
public class TwoSum {
    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        for(int i = 0; i < a.size(); i++){
            if(map.containsKey(a.get(i))){
                int index = map.get(a.get(i));
                result.set(0, index + 1);
                result.set(1, i + 1);
                break;
            }
            else if(!map.containsKey(b - a.get(i))){
                map.put(b - a.get(i), i);
            }
        }
        if(result.get(0) == 0 && result.get(1) == 0)
            return new ArrayList<>();
        return result;
    }
}
