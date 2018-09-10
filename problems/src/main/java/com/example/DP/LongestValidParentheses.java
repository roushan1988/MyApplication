package com.example.DP;

import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 *
 * Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

 Examples:

 Input : ((()
 Output : 2
 Explanation : ()

 Input: )()())
 Output : 4
 Explanation: ()()

 Input:  ()(()))))
 Output: 6
 Explanation:  ()(())

 * https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 *
 * Efficient Solution can solve this problem in O(n) time.
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String a) {
        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;

        for(int i=0; i<=a.length()-1; i++){
            char c = a.charAt(i);
            if(c=='('){
                int[] index = {i,0};
                stack.push(index);
            }else{
                if(stack.empty()||stack.peek()[1]==1){ //An extra closing bracket
                    int[] index = {i,1};
                    stack.push(index);
                }else{
                    stack.pop();
                    int currentLen=0;
                    if(stack.empty()){
                        currentLen = i+1;
                    }else{
                        currentLen = i-stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }

        return result;
    }
}
