package com.example.BinarySearch;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 */
public class SquareRoot {
    public int sqrt(int a) {
        long low=0;
        long high = a;
        while (low<=high){
            long mid = (low+high)/2;
            long sqr = mid*mid;
            long nextSqr = (mid+1)*(mid+1);
            if(sqr==a || (sqr<a && nextSqr>a)){
                return ((Long)mid).intValue();
            }
            if(sqr>a){
                high = mid-1;
            }
            if(sqr<a){
                low = mid+1;
            }
        }
        return ((Long)((low+high)/2)).intValue();
    }
}
