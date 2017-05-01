package com.example.Greedy;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Sample Input :

Ratings : [1 2]
Sample Output :

3
The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor.
So rating 2 candidate gets 2 candies. In total, 2+1 = 3 candies need to be given out.
 */
public class DistributeCandy {
    public int candy(ArrayList<Integer> ratings) {
        if(ratings == null || ratings.size() == 0)
            return 0;
        int[] candies = new int[ratings.size()];
        candies[0] = 1;

        for(int i = 1; i<ratings.size(); i++){
            if (ratings.get(i) > ratings.get(i-1)) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        int  count = candies[ratings.size()-1];

        for(int i = ratings.size()-2; i>=0; i--){
            int cur = 1;
            if (ratings.get(i) > ratings.get(i + 1)) {
                cur = candies[i + 1] + 1;
            }

            count += Math.max(cur, candies[i]);
            candies[i] = cur;
        }
        return count;
    }
}
