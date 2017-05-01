package com.example.StacksAndQueues;

import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/6/17.
 */

public class MaxAreaHistogram {
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
