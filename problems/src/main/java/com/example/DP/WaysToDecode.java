package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

Example :

Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
public class WaysToDecode {
    public int numDecodings(String a) {
        if(a==null || a.length()==0 || a.charAt(0)=='0')
            return 0;
        if(a.length()==1)
            return 1;

        int[] dp = new int[a.length()];
        dp[0]=1;
        if(Integer.parseInt(a.substring(0,2))>26){
            if(a.charAt(1)!='0'){
                dp[1]=1;
            }else{
                dp[1]=0;
            }
        }else{
            if(a.charAt(1)!='0'){
                dp[1]=2;
            }else{
                dp[1]=1;
            }
        }

        for(int i=2; i<a.length(); i++){
            if(a.charAt(i)!='0'){
                dp[i]+=dp[i-1];
            }

            int val = Integer.parseInt(a.substring(i-1, i+1));
            if(val<=26 && val >=10){
                dp[i]+=dp[i-2];
            }
        }

        return dp[a.length()-1];
    }
}
