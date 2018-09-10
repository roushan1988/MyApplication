package com.example.DP;
/*

From now, we will refer 3 colors combination for a Nth column of the 3*N board as W(n) and two colors as Y(n).
We can see that each W can generate 5Y and 11W, and each Y can generate 7Y and 10W. We get two equation from here
We have two equations now,

W(n+1) = 10*Y(n)+11*W(n);
Y(n+1) = 7*Y(n)+5*W(n);

    https://www.geeksforgeeks.org/ways-color-3n-board-using-4-colors/

 */
public class WaysToColor3NBoard {
    public static int solve(int A) {
        long color3 = 24; // When we to fill single column
        long color2 = 12;
        long temp = 0;
        for (int i = 2; i <= A; i++)
        {
            temp = color3;
            color3 = (11 * color3 + 10 * color2 ) % 1000000007;
            color2 = ( 5 * temp + 7 * color2 ) % 1000000007;
        }
        long num = (color3 + color2) % 1000000007;
        return (int)num;
    }
}
