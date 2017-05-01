package com.example.Math;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
 */
public class PalindromeInteger {
    public boolean isPalindrome(int a) {
        if (a < 0)
            return false;

        int div = 1;
        while (a / div >= 10) {
            div *= 10;
        }

        while (a != 0) {
            int left = a / div;
            int right = a % 10;

            if (left != right)
                return false;

            a = (a % div) / 10;
            div /= 100;
        }

        return true;
    }
}
