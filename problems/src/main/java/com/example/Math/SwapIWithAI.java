package com.example.Math;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
* All elements in the array are in the range [0, N-1]
* N * N does not overflow for a signed integer
 */
public class SwapIWithAI {
    public void arrange(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++){
            int newVal = a.get(i) + (a.get(a.get(i)) % a.size()) * a.size();
            a.set(i, newVal);
        }
        for (int i = 0; i < a.size(); i++){
            int newVal = a.get(i)/a.size() ;
            a.set(i, newVal);
        }
    }
}
