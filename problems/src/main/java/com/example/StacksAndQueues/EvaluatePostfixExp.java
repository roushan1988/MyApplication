package com.example.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/6/17.
 */
/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluatePostfixExp {
    public int evalRPN(ArrayList<String> a) {
        int result = 0;
        String operators = "+-/*";
        Stack<String> stack = new Stack<String>();
        for(String t : a){
            if(!operators.contains(t))
                stack.push(t);
            else{
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(stack.pop());
                switch (t){
                    case "+":
                        stack.push(String.valueOf(x+y));
                        break;
                    case "-":
                        stack.push(String.valueOf(y-x));
                        break;
                    case "*":
                        stack.push(String.valueOf(x*y));
                        break;
                    case "/":
                        stack.push(String.valueOf(y/x));
                        break;
                    default:
                        break;
                }
            }
        }
        result = Integer.valueOf(stack.pop());
        return result;
    }
}
