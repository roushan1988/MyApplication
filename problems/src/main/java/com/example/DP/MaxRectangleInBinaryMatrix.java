package com.example.DP;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0
    ]

Output : 4

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

 */
public class MaxRectangleInBinaryMatrix {

    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = m == 0 ? 0 : a.get(0).size();
        int[][] height = new int[m][n + 1];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == 0) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int area = largestRectangleArea(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    private int maxAreaHistogram(int[] height){
        int i=0, max = 0;
        Stack<Integer> stack = new Stack<>();
        while (i<height.length){
            if(stack.isEmpty() || height[stack.peek()] <= height[i])
                stack.push(i++);
            else{
                int top = stack.pop();
                max = Math.max(height[top] * (stack.isEmpty() ? i:i-stack.peek()-1), max);
            }
        }
        return max;
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int i=0, max = Integer.MIN_VALUE;
        while (i < height.length){
            if(stack.isEmpty() || height[i] >= height[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int topIndex = stack.pop();
                int h = height[topIndex];
                int w = stack.isEmpty() ? i:i-1-stack.peek();
                max = Math.max(h*w, max);
            }
        }
        while (!stack.isEmpty()){
            int topIndex = stack.pop();
            int h = height[topIndex];
            int w = stack.isEmpty() ? i:i-1-stack.peek();
            max = Math.max(h*w, max);
        }
        return max;
    }
}
