package com.example.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])
 */
public class MaxPointsOnStraightLine {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int maxPoints = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        if(a.size() != b.size() || a.size() == 0 || a == null || b.size() == 0 || b == null)
            return maxPoints;
        if(a.size() == 1 && b.size() == 1)
            return 1;
        for(int i = 0; i < a.size(); i++){
            int duplicate =1, vertical =0;
            int xi = a.get(i), yi = b.get(i);
            for(int j = i+1; j < a.size(); j++){
                int xj = a.get(j), yj = b.get(j);
                if(xi == xj){
                    if(yi == yj){
                        duplicate++;
                    }else{
                        vertical ++;
                    }
                }else{
                    double m = 0.0;
                    if(yj - yi == 0)
                        m = 0.0;
                    else if(xj - xi == 0)
                        m = Double.MAX_VALUE;
                    else
                        m = (double)(yj - yi) / (double)(xj - xi);
                    if(map.containsKey(m))
                        map.put(m, map.get(m) + 1);
                    else
                        map.put(m, 1);
                }
            }
            for(int sl : map.values()){
                if(maxPoints < sl + duplicate)
                    maxPoints = sl + duplicate;
            }
            maxPoints = Math.max(vertical + duplicate, maxPoints);
            map.clear();
        }
        return maxPoints;
    }
}
