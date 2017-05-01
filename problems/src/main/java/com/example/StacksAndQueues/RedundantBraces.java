package com.example.StacksAndQueues;

import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/6/17.
 */
/*
Write a program to validate if the input string has redundant braces?
Return 0/1
 0 -> NO 1 -> YES

Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0
 */

public class RedundantBraces {
    public int braces(String a) {
        Stack<Character> stack = new Stack<Character>();
        int index = 0;
        while(index < a.length()){
            char c = a.charAt(index);
            if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/'){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.peek() == '('){
                    return 1;
                } else{
                    while(!stack.isEmpty() && stack.peek() != '('){
                        stack.pop();
                    }
                    stack.pop();
                }
            }
            index++;
        }
        return 0;
    }
}
