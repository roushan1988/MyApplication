package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.
 */
public class CountAndSay {
    public String countAndSay(int a) {
        if(a <= 0)
            return null;
        String result = "1";
        int i = 1;
        while(i < a){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 1; j < result.length(); j++){
                if(result.charAt(j) == result.charAt(j-1))
                    count++;
                else{
                    sb.append(count);
                    sb.append(result.charAt(j-1));
                    count  = 1;
                }

            }
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }
}
