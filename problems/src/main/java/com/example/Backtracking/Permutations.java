package com.example.Backtracking;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        return getPerms(a);
    }

    private static ArrayList<ArrayList<Integer>> getPerms(ArrayList<Integer> a){
        if(a== null)
            return null;
        ArrayList<ArrayList<Integer>> perms = new ArrayList<>();
        if(a.size() == 0){
            perms.add(new ArrayList<Integer>());
            return perms;
        }
        int first = a.get(0);
        ArrayList<Integer> remainder = new ArrayList<>(a.subList(1, a.size()));
        ArrayList<ArrayList<Integer>> tempList = getPerms(remainder);
        for(ArrayList<Integer> tempSublist : tempList){
            for(int i=0; i<=tempSublist.size(); i++){
                perms.add(insertDigitAt(tempSublist, first, i));
            }
        }
        return perms;
    }

    private static ArrayList<Integer> insertDigitAt(ArrayList<Integer> permu, int digit, int pos){
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> part1, part2 ;

        part1 = new ArrayList<>(permu.subList(0, pos));
        part2 = new ArrayList<>(permu.subList(pos, permu.size()));
        result.addAll(part1);
        result.add(digit);
        result.addAll(part2);
        return result;
    }
}
