package com.example.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
 */
public class SubstringsInConcatenatedForm {
    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(b.size() == 0 || a == null || b == null || a.length() == 0)
            return result;
        int length = a.length();
        int num = b.size() * b.get(0).length();
        int strLength = b.get(0).length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < b.size(); i++){
            if(map.containsKey(b.get(i)))
                map.put(b.get(i), map.get(b.get(i)) +  1);
            else
                map.put(b.get(i), 1);
        }

        for(int i = 0; i <= length - num; i++){
            HashMap<String, Integer> tempMap = (HashMap<String, Integer>)map.clone();
            for(int j = 0; j < b.size(); j++){
                String str = a.substring(i + j * strLength, i + (j + 1) * strLength);
                if(!tempMap.containsKey(str)){
                    break;
                }else if(tempMap.get(str) > 1){
                    tempMap.put(str, tempMap.get(str) -  1);
                }else if(tempMap.get(str) == 1){
                    tempMap.remove(str);
                }
            }
            if(tempMap.isEmpty())
                result.add(i);
        }
        return result;
    }
}
