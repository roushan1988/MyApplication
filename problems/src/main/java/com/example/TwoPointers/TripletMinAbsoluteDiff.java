package com.example.TwoPointers;

import java.util.ArrayList;

public class TripletMinAbsoluteDiff {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        // To store resultant three numbers
        int res_min=0, res_max=0, res_mid=0;

        // pointers to A, B, C
        // respectively
        int i = 0, j = 0, k = 0;

        // Loop until one array reaches to its end
        // Find the smallest difference.
        int diff = Integer.MAX_VALUE;

        while (i < A.size() && j < B.size() && k < C.size())
        {
            int sum = A.get(i) + B.get(j) + C.get(k);

            // maximum number
            int max = Math.max(Math.max(A.get(i), B.get(j)), C.get(k));

            // Find minimum and increment its index.
            int min = Math.min(Math.min(A.get(i), B.get(j)), C.get(k));
            if (min == A.get(i))
                i++;
            else if (min == B.get(j))
                j++;
            else
                k++;

            // comparing new difference with the
            // previous one and updating accordingly
            if (diff > (max - min))
            {
                diff = max - min;
                res_max = max;
                res_mid = sum - (max + min);
                res_min = min;
            }
        }

        return diff;
    }

}
