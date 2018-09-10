package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example :
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

If it is not possible to reach the end index, return -1.

    https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/

 */

public class MinJumps {
    public int jump(ArrayList<Integer> a) {
        if (a.size() <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (a.get(0) == 0)
            return -1;

        // initialization
        int maxReach = a.get(0);
        int step = a.get(0);
        int jump = 1;


        // Start traversing array
        for (int i = 1; i < a.size(); i++)
        {
            // Check if we have reached the end of the array
            if (i == a.size() - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i+a.get(i));

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0)
            {
                //  we must have used a jump
                jump++;

                //Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if(i>=maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }
}
