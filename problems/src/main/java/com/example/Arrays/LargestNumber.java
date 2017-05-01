package com.example.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(final List<Integer> a) {
        List<String> stringList = new ArrayList<>(a.size());
        for(Integer val : a){
            stringList.add(String.valueOf(val));
        }

        Collections.sort(stringList, new MyComparator());
        StringBuilder result = new StringBuilder();
        boolean allZero = true;
        for(String str : stringList){
            if(!str.equalsIgnoreCase("0"))
                allZero = false;
            result.append(str);
        }

        if(allZero)
            return "0";
        else
            return result.toString();
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s, String t1) {
            String sample1 = s.concat(t1);
            String sample2 = t1.concat(s);
            return sample2.compareTo(sample1);
        }
    }
}
