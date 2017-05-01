package com.example.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2)
 */
public class ThreeSumZero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a == null || a.size()<3)
            return result;

        for(int i=0; i<a.size(); i++){
            if(i==0 || a.get(i) > a.get(i-1)){
                int j= i+1;
                int k = a.size() -1;
                while (j<k){
                    if(a.get(i)+a.get(j)+a.get(k)==0){
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(a.get(i));
                        l.add(a.get(j));
                        l.add(a.get(k));
                        result.add(l);

                        j++;
                        k--;

                        while(j<k && a.get(j).equals(a.get(j-1)))
                            j++;
                        while(j<k && a.get(k).equals(a.get(k+1)))
                            k--;

                    }else if(a.get(i)+a.get(j)+a.get(k)<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
