package com.example.BinarySearch;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 */
public class RotatedSortedArraySearch {
    public int search(final List<Integer> a, int b) {
        return search(a, b, 0, a.size()-1);
    }

    private static int search(final List<Integer> a, int b, int left, int right){
        int mid = (left+right)/2;
        if(b ==a.get(mid))
            return mid;
        if(right < left)
            return -1;

        if(a.get(left) < a.get(mid)){  //left half sorted
            if((b >= a.get(left)) && (b <=a.get(mid))){
                return search(a, b, left, mid-1);
            }else{
                return search(a, b, mid+1, right);
            }
        }else if(a.get(mid) < a.get(right)){ //right half sorted
            if(b >= a.get(mid) && b<=a.get(right)){
                return search(a, b, mid+1, right);
            }
            else{
                return search(a, b, left, mid-1);
            }
        }else if(a.get(left) == a.get(mid)){ //duplicate
            if(a.get(mid) != a.get(right)){
                search(a, b, mid+1, right);
            }else{
                int res = search(a, b, left, mid-1);
                if(res ==-1)
                    return search(a, b, mid+1, right);
                else
                    return res;
            }
        }
        return -1;
    }
}
