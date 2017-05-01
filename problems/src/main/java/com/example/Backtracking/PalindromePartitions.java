package com.example.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
 Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
*
*
*
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
 */
public class PalindromePartitions {

    //O(n^2)
    //http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
    public static List<String> palindromePartitioning(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null)
            return result;
        if (s.length() <= 1) {
            result.add(s);
            return result;
        }
        int length = s.length();
        int[][] table = new int[length][length];
        // l is length, i is index of left boundary, j is index of right boundary
        for (int l = 1; l <= length; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 1 || l == 2) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i + 1][j - 1];
                    }
                    if (table[i][j] == 1) {
                        result.add(s.substring(i, j + 1));
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }
        return result;
    }

    //O(n^3)
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(a == null || a.length() == 0)
            return result;

        ArrayList<String> partition = new ArrayList<>();
        addPalindrome(a, 0, partition, result);

        return result;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static void addPalindrome(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
        if(start == s.length()){
            ArrayList<String> temp = new ArrayList<>(partition);
            result.add(temp);
            return;
        }

        for(int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if(isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }
}
