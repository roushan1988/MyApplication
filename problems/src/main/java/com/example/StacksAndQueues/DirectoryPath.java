package com.example.StacksAndQueues;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by shwetatrivedi1 on 2/6/17.
 */
/*
Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.
 */
public class DirectoryPath {
    public String simplifyPath(String a) {
        Stack<String> stack = new Stack<String>();
        while(a.length()> 0 && a.charAt(a.length()-1) =='/'){
            a = a.substring(0, a.length()-1);
        }
        int start = 0;
        for(int i=1; i<a.length(); i++){
            if(a.charAt(i) == '/'){
                stack.push(a.substring(start, i));
                start = i;
            }else if(i == a.length()-1){
                stack.push(a.substring(start));
            }
        }
        LinkedList<String> result = new LinkedList<String>();
        int count =0;
        while(!stack.isEmpty()){
            String top = stack.pop();
            if(top.equals("/..")){
                count++;
            }
            else if(!top.equals("/.") && !top.equals("/")){
                if(count >0)
                    count--;
                else
                    result.push(top);
            }

        }
        if(result.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()){
            String s = result.pop();
            sb.append(s);
        }
        return sb.toString();
    }
}
