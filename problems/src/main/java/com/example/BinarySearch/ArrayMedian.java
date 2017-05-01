package com.example.BinarySearch;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 */
public class ArrayMedian {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(a.size() > b.size()){
            return medianUtil(b, b.size(), a, a.size());
        }
        return medianUtil(a, a.size(), b, b.size());
    }

    private static double medianUtil(final List<Integer> a, int n, final List<Integer> b, int m){
        if(n==0)
            return median(b, m);
        if(n==1){
            if(m==1)
                return median2(a.get(0), b.get(0));
            if(m%2 !=0)
                return median2(b.get(m/2), median3(a.get(0), b.get(m/2 -1), b.get(m/2+1)));
            return median3(a.get(0), b.get(m/2 -1), b.get(m/2));
        }else if(n==2){
            if(m==2)
                return median4(a.get(0), a.get(1), b.get(0), b.get(1));
            if(m%2 !=0)
                return median3(b.get(m/2), Math.max(a.get(0), b.get(m/2 -1)), Math.min(a.get(1), b.get(m/2 +1)));
            return median4(b.get(m/2), b.get(m/2 -1), Math.max(a.get(0), b.get(m/2 -2)), Math.min(a.get(1), b.get(m/2+1)));
        }
        int aHalf = (n-1)/2;
        int bHalf = (m-1)/2;
        if(a.get(aHalf) <= b.get(bHalf))
            return medianUtil(a.subList(aHalf, n), n/2 +1, b, m-aHalf);
        return medianUtil(a,n/2+1, b.subList(aHalf, m), m-aHalf);
    }
    private static double median2(double a, double b){
        return (a+b)/2.0;
    }

    private static double median3(double a, double b, double c){
        return a+b+c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    private static double median4(double a, double b, double c, double d){
        return (a+b+c+d - Math.max(d, Math.max(a, Math.max(b, c))) - Math.min(d, Math.min(a, Math.min(b, c))))/2.0;
    }

    private static double median(final List<Integer> a, int n){
        if(n==0)
            return -1;
        if(n%2 ==0)
            return (a.get(n/2) + a.get(n/2 -1))/2.0;
        return a.get(n/2);
    }
}
