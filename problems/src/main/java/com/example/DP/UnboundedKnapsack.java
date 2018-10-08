package com.example.DP;

import java.util.ArrayList;
import java.util.List;

public class UnboundedKnapsack {

    // Returns the maximum value with knapsack
    // of W capacity

    public static void main(String[] args) throws Exception {
        int maxCost = 50;
        List<Integer>bundleCost = new ArrayList<>();
        bundleCost.add(12);
      //  bundleCost.add(20);
        List<Integer>bundleQty = new ArrayList<>();
        bundleQty.add(20);
        //bundleQty.add(19);

        System.out.print(unboundedKnapsack(maxCost, bundleQty, bundleCost));
    }
    private static int unboundedKnapsack(int W, List<Integer> bundleQty, List<Integer> bundleCost) {

        int bundleLength = bundleCost.size();
        // dp[i] is going to store maximum value
        // with knapsack capacity i.
        int dp[] = new int[W + 1];

        // Fill dp[] using above recursive formula
        for(int i = 0; i <= W; i++){
            for(int j = 0; j < bundleLength; j++){
                if(bundleCost.get(j) <= i){
                    dp[i] = Math.max(dp[i], dp[i - bundleCost.get(j)] +
                            bundleQty.get(j));
                }
            }
        }
        return dp[W];
    }
}
