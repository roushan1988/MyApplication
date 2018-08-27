package com.example.BinarySearch;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.
 */
public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if(n == 0) return -1;
        int m = A.get(0).size();
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        int x = 1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(isLessThanHalf(A, mid)) {
                lo = mid+1;
            } else {
                x = mid;
                hi = mid-1;
            }
        }
        return x;
    }
    boolean isLessThanHalf(ArrayList<ArrayList<Integer>> a, int num) {
        int N = a.size();
        int M = a.get(0).size();
        int count = 0;

        for(int i = 0; i < N; i++) {
            count += getCount(a.get(i), num);
        }
        return count < (N*M)/2 + 1;
    }
    int getCount(ArrayList<Integer> a, int n) {
        int lo = 0;
        int hi = a.size()-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(a.get(mid) > n) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }

   /* public int findMedian2(ArrayList<ArrayList<Integer>> A) {
        int mn = A.get(0).get(0), mx = A.get(0).get(0), n = A.size(), m = A.get(0).size();
        for (int i = 0; i < n; ++i) {
            if (A.get(i).get(0) < mn) {
                mn = A.get(i).get(0);
            }
            if (A.get(i).get(m-1) > mx) {
                mx = A.get(i).get(m - 1);
            }
        }
        int desired = (n * m +1)/2  ;
        while (mn < mx) {
            int mid = mn + (mx - mn) / 2;
            int count = getCountLessThan(mid, A);
            if (count < desired)
                mn = mid + 1 ;
            else
                mx = mid;
        }
        return mn;
    }
    private static int getCountLessThan(int x,ArrayList<ArrayList<Integer>> A ){
        int count = 0, n = A.size();
        for (int i = 0; i < n; ++i){
            int index =0;
            for(int j=0; j<A.get(0).size(); j++){
                if(A.get(i).get(j) <= x)
                    index++;
            }

            *//*int index = Collections.binarySearch(A.get(i), x+1);
            if(index <0){
                index = -index-1;
            }*//*
            count +=(index);
        }
        return count;
    }*/
}
