package com.example.DP;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to accommodate the horses into the stables in such a way that the following conditions are satisfied:

You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put horse 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
No stable should be empty and no horse should be left unaccommodated.
Take the product (number of white horses * number of black horses) for each stable and take the sum of all these products. This value should be the minimum among all possible accommodation arrangements
Example:


Input: {WWWB} , K = 2
Output: 0

Explanation:
We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
for first choice we will get 1*0 + 2*1 = 2.
for second choice we will get 2*0 + 1*1 = 1.
for third choice we will get 3*0 + 0*1 = 0.

Of the 3 choices, the third choice is the best option.

 */
public class HorsesInStable {
    public int arrange(String a, int b) {
        if(a == null || a.length() < b)
            return -1;
        int[][] dp = new int[a.length() + 1][b+1];

        for(int i = 1; i <= a.length(); i++){
            dp[i][1] = product(a, 0, i - 1);
        }

        for(int i = 2; i <= b; i++){
            for(int j = i; j <= a.length(); j++){
                int min = Integer.MAX_VALUE;
                for(int k = i - 1; k <= j - 1; k++){
                    dp[j][i] =  Math.min((dp[k][i - 1] + product(a, k, j - 1)), min);
                    min = dp[j][i];
                }
            }
        }
        return dp[a.length()][b];
    }

    public int product(String A, int start, int end){
        int W = 0, B = 0;
        for(int i = start; i <= end; i++){
            if(A.charAt(i) == 'W') W++;
            else if(A.charAt(i) == 'B') B++;
        }
        return W * B;
    }
}
