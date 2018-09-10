package com.example.DP;

import java.util.HashMap;
import java.util.Map;

/*

https://www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/

https://www.geeksforgeeks.org/longest-arithmetic-progression-with-the-given-common-difference/

For each element calculate the length of the longest AP it could form and print the maximum among them. It involves O(n2) time complexity.

An efficient approach is to use Hashing.

Create a map where the key is the starting element of an AP and its value is the number of elements in that AP.
 The idea is to update the value at key ‘a'(which is at index i and whose starting element is not yet there in the map) by 1
 whenever the element at index j(>i) could be in the AP of ‘a'(as the starting element).

Then we print the maximum value among all values in the map.
 */
public class LongestArithmeticProgression {
    static int maxlenAP(int a[],
                        int n, int d) {
        // key=starting element of an AP,
        // value=length of AP
        HashMap<Integer, Integer> m =
                new HashMap<Integer, Integer>();

        // since the length of longest
        // AP is at least one i.e.
        // the number itself.
        int maxt = 1;

        // if element a[i]'s starting
        // element(i.e., a[i]-i*d)
        // is not in map then its value
        // is 1 else there already
        // exists a starting element of
        // an AP of which a[i] can be
        // a part.
        for (int i = 0; i < n; i++) {
            if (m.containsKey(a[i] - i * d)) {
                int freq = m.get(a[i] - i * d);
                freq++;
                m.put(a[i] - i * d, freq);
            } else {
                m.put(a[i] - i * d, 1);
            }
        }

        // auto operator stores the key,
        // value pair type from the map.
        for (Map.Entry<Integer, Integer> val : m.entrySet()) {
            if (maxt < val.getValue())
                maxt = val.getValue();
        }
        return maxt;
    }
}
