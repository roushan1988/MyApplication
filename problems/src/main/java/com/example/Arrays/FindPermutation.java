package com.example.Arrays;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given a positive integer n and a string s consisting only of letters D or I, you have to find
any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes
- Length of given string s will always equal to n - 1
- Your solution should run in linear time and space.

Example :

Input 1:

n = 3

s = ID

Return: [2, 3, 1]
 */
public class FindPermutation {
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int dCount = 0;
        int i=0, start = 1;
        while(i < B-1 ){
            if(A.charAt(i) == 'D')
                dCount ++;
            i++;
        }
        int currentHighest, currentLowest;
        start += dCount;
        currentHighest = start;
        currentLowest = start;
        result.add(start);
        for(int j = 0; j<B-1; j++){
            if(A.charAt(j) == 'I'){
                currentHighest ++;
                result.add(currentHighest);
            }else if(A.charAt(j) == 'D'){
                currentLowest --;
                result.add(currentLowest);
            }
        }
        return result;
    }
}
