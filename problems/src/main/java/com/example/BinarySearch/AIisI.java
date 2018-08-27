package com.example.BinarySearch;
/*
AmagicindexinanarrayA[l...n-l] isdefinedtobeanindexsuchthatA[i] = i.

Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
FOLLOW UP
What if the values are not distinct?
 */
public class AIisI {

        public static int magicFast(int[] array, int start, int end) {
            if (end < start || start < 0 || end >= array.length) {
                return -1;
            }
            int midlndex = (start + end) / 2;
            int midValue = array[midlndex];
            if (midValue == midlndex) {
                return midlndex;
            }
            /* Search left */
            int leftlndex = Math.min(midlndex - 1, midValue);
            int left = magicFast(array, start, leftlndex);
            if (left >= 0) {
                return left;
            }

            /* Search right */
            int rightlndex = Math.max(midlndex + 1, midValue);
            int right = magicFast(array, rightlndex, end);
            return right;
        }
        public static int magicFast(int[] array) {
            return magicFast(array, 9, array.length - 1);
        }

}
