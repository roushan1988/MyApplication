package com.example.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].
 */
public class SearchRange {
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int low=0;
        int high = a.size()-1;
        ArrayList<Integer> result = new ArrayList<>();
        if(a.get(high)<b || a.get(low)>b){
            result.add(-1);
            result.add(-1);
            return result;
        }
        if(a.get(low).equals(b)){
            result.add(low);
        }else{
            int mid;
            loop1:
            while (low<=high){ //gets left most occurence of target
                mid = (low+high)/2;
                if(a.get(mid).equals(b) && a.get(mid-1)<b){ // break loop only if this is the leftmost entry
                    result.add(mid);
                    low = mid;
                    break loop1;
                }
                if(a.get(mid)<b){ //search right side
                    low = mid+1;
                }
                if(a.get(mid)>=b){ // search left side
                    high = mid-1;
                }
            }
            if(result.isEmpty()){
                result.add(-1);
                result.add(-1);
                return result;
            }
        }
        high = a.size()-1;
        if(a.get(high).equals(b)){
            result.add(high);
        }else{
            int mid;
            loop2:
            while (low<=high){
                mid = (low+high)/2;
                if(a.get(mid).equals(b) && a.get(mid+1)>b){
                    result.add(mid);    // break loop only if this is the leftmost entry
                    break loop2;
                }
                if(a.get(mid)<=b){ //move Left
                    low = mid+1;
                }
                if(a.get(mid)>b){ //move Right
                    high = mid-1;
                }
            }
        }
        return result;

    }
    public ArrayList<Integer> searchRange2(final List<Integer> a, int b) { // may have overflow issues
        Integer[] arr = {-1, -1};
        binarySearch(a, 0, a.size()-1, b, arr);
        ArrayList<Integer> result = new ArrayList<>(2);
        result.add(arr[0]);
        result.add(arr[1]);
        return result;
    }
    private static void binarySearch(final List<Integer> a, int left, int right, int target, Integer[] arr) {
        if (right < left)
            return;

        if (a.get(left) == a.get(right) && a.get(left) == target) {
            arr[0] = left;
            arr[1] = right;
            return;
        }

        int mid = left + (right - left) / 2;
        if (a.get(mid) < target) {
            binarySearch(a, mid + 1, right, target, arr);
        } else if (a.get(mid) > target) {
            binarySearch(a, left, mid - 1, target, arr);
        } else {
            arr[0] = mid;
            arr[1] = mid;

            int t1 = mid;
            while (t1 > left && a.get(t1) == a.get(t1 - 1)) {
                t1--;
                arr[0] = t1;
            }

            int t2 = mid;
            while (t2 < right && a.get(t2) == a.get(t2 + 1)) {
                t2++;
                arr[1] = t2;
            }
            return;
        }

    }
}
