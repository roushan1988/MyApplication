package com.example.Math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
Look at the example for more details.

Example :

Input : 'aba'
Output : 2

The order permutations with letters 'a', 'a', and 'b' :
aab
aba
baa
The answer might not fit in an integer, so return your answer % 1000003

 NOTE: 1000003 is a prime number
NOTE: Assume the number of characters in string < 1000003
 */
public class SortedPermutationRankWithRepeats {
    public int findRank(String a) {
        char[] array = a.toCharArray();
        long rank = findRank2(array, 0, array.length-1);
        rank++;
        return ((Long)(rank%1000003)).intValue();
    }

    public static long findRank2(char[] input, int start, int end) {
        if(start==end){
            return 0;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=start; i<=end; i++){
            if(!set.add(input[i])){
                if(countMap.get(input[i])==null){
                    countMap.put(input[i], 1);
                }
                countMap.put(input[i], countMap.get(input[i])+1);
            }
        }
        long trimmedFactorial = 0;
        for(int i=start+1; i<=end; i++) {
            if(set.contains(input[i]) && input[start]>input[i]){
                set.remove(input[i]);
                trimmedFactorial = (trimmedFactorial + trimmedFactorial(input.length-start-1, countMap, input[i]))%1000003;
                trimmedFactorial %= 1000003;
            }
        }
        return (trimmedFactorial+findRank2(input, start+1, end))%1000003;
    }

    public static int trimmedFactorial(int input, Map<Character, Integer> map, Character character){
        if(input<2){
            return 1;
        }
        Long factorial1 = 1l;
        for(Character c: map.keySet()){
            int bi = 0;
            if(c.equals(character)){
                bi = map.get(c)-1;
            }else{
                bi = map.get(c);
            }
            while(bi>1){
                factorial1 *= bi;
                factorial1 = factorial1 % 1000003;
                bi--;
            }
        }
        Long x = 1000003 * factorial1;
        Long factorial = 1l;
        for(int i=2; i<=input; i++){
            factorial *= i;
//            factorial = factorial % 1000003;
//            factorial = factorial % factorial1;
            if(!x.equals(0l)) {
                factorial = factorial % x;
            }
        }
        if(factorial1>1){
            factorial = factorial/factorial1;
        }
        int result = ((Long)(factorial % 1000003)).intValue();
        return result;
    }
}
