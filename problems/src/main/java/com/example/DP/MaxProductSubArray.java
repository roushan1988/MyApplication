package com.example.DP;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]
Return : 6

Possible with [2, 3]
 */
public class MaxProductSubArray {
    public int maxProduct(final List<Integer> a) {
        int[] max = new int[a.size()];
        int[] min = new int[a.size()];

        max[0] = min[0] = a.get(0);
        int result = a.get(0);

        for(int i=1; i<a.size(); i++){
            if(a.get(i)>0){
                max[i]=Math.max(a.get(i), max[i-1]*a.get(i));
                min[i]=Math.min(a.get(i), min[i-1]*a.get(i));
            }else{
                max[i]=Math.max(a.get(i), min[i-1]*a.get(i));
                min[i]=Math.min(a.get(i), max[i-1]*a.get(i));
            }
            result = Math.max(result, max[i]);
        }
        return  result;
    }
}
