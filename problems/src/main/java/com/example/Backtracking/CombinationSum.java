package com.example.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers
sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example,
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        if(a == null || a.size() == 0)
            return result;
        Collections.sort(a);
        HashSet<ArrayList<Integer>> set = new  HashSet<>();
        helper(result, curr, 0, b, a, set);
        return result;
    }

    private static void helper(ArrayList<ArrayList<Integer>> result, List<Integer> curr, int start, int target, ArrayList<Integer> candidates, HashSet<ArrayList<Integer>> set) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(curr);
            if (!set.contains(temp)) {
                set.add(temp);
                result.add(temp);
            }
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            if (target < candidates.get(i))
                return;
            curr.add(candidates.get(i));
            helper(result, curr, i, target - candidates.get(i), candidates, set); // and use next element only
            curr.remove(curr.size() - 1);
        }
    }
}
