package com.example.Math;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' :
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003
 */
public class SortedPermutationRank {
    public int findRank(String a) {
        char[] array = a.toCharArray();
        long rank = findRank(array, 0, array.length-1);
        rank++;
        return ((Long)(rank%1000003)).intValue();
    }

    public long findRank(char[] input, int start, int end) {
        if(start==end){
            return 0;
        }
        long charRank = 0;
        for(int i=start+1; i<=end; i++){
            if(input[start]>input[i]){
                charRank++;
            }
        }
        return (charRank*trimmedFactorial(input.length-start-1)+findRank(input, start+1, end))%1000003;
    }

    public int trimmedFactorial(int input){
        if(input<2){
            return 1;
        }
        int factorial = 1;
        for(int i=2; i<=input; i++){
            factorial *= i;
            factorial = factorial % 1000003;
        }
        return factorial;
    }
}
