package com.example.DP;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Example :

Input : [1 2]
Return :  1
 */
public class BuyStocksOneTxn {
    public int maxProfit(final List<Integer> a) {
        if(a==null||a.size()<=1)
            return 0;

        int min=a.get(0);
        int result=0;

        for(int i=1; i<a.size(); i++){
            result = Math.max(result, a.get(i)-min);
            min = Math.min(min, a.get(i));
        }

        return result;
    }
}
