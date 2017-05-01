package com.example.Greedy;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2.
 */
public class MostFrequentElement {
    public int majorityElement(final List<Integer> a) {
        return moreThanNdK(a, a.size(), 2);
    }

    private static class eleCount
    {
        int e;
        int c;
    };

    private int moreThanNdK(final List<Integer> a, int n, int k)
    {
        // k must be greater than 1 to get some output
        if (k < 2)
            return -1;

    /* Step 1: Create a temporary array (contains element
       and count) of size k-1. Initialize count of all
       elements as 0 */
        eleCount[] temp = new eleCount[k-1];

        for (int i=0; i<k-1; i++) {
            temp[i] = new eleCount();
            temp[i].c = 0;
        }

    /* Step 2: Process all elements of input array */
        for (int i = 0; i < n; i++)
        {
            int j;

        /* If arr[i] is already present in
           the element count array, then increment its count */
            for (j=0; j<k-1; j++)
            {
                if (temp[j].e == a.get(i))
                {
                    temp[j].c += 1;
                    break;
                }
            }

        /* If arr[i] is not present in temp[] */
            if (j == k-1)
            {
                int l;

            /* If there is position available in temp[], then place
              arr[i] in the first available position and set count as 1*/
                for (l=0; l<k-1; l++)
                {
                    if (temp[l].c == 0)
                    {
                        temp[l].e = a.get(i);
                        temp[l].c = 1;
                        break;
                    }
                }

            /* If all the position in the temp[] are filled, then
               decrease count of every element by 1 */
                if (l == k-1)
                    for (l=0; l<k-1; l++)
                        temp[l].c -= 1;
            }
        }

        for (int i=0; i<k-1; i++)
        {
            // Calculate actual count of elements
            int ac = 0;  // actual count
            for (int j=0; j<n; j++)
                if (a.get(j) == temp[i].e)
                    ac++;

            // If actual count is more than n/k, then print it
            if (ac > n/k)
                return temp[i].e;
        }
        return -1;
    }
}
