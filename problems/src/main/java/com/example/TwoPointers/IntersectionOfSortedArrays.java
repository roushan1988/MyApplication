package com.example.TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input :
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ),
 assume that elements that appear more than once in both arrays should be included multiple times in the final output.
 */
public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i=0, j=0;
        while (i<a.size() && j<b.size()){
            if(a.get(i) < b.get(j))
                i++;
            else if(b.get(j) < a.get(i))
                j++;
            else{
                result.add(a.get(i));
                i++;
                j++;
            }
        }
        return result;
    }
}
