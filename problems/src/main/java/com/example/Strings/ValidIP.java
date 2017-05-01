package com.example.Strings;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 */
public class ValidIP {
    public ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> result = new ArrayList<>();
        if (a.length()<4||a.length()>12) return result;
        recursiveDot(a,"",result,0);
        return result;
    }

    private static boolean isValid(String s){
        if (s.charAt(0)=='0')
            return s.equals("0");
        int num = Integer.parseInt(s);
        return num<=255 && num>0;
    }

    private static void recursiveDot(String s, String tmp, ArrayList<String> res, int count){
        if (count == 3 ) {
            if(isValid(s))
                res.add(tmp + s);
            return;
        }
        for(int i=1; i<4 && i<s.length(); i++){
            String substr = s.substring(0,i);
            if (isValid(substr)){
                recursiveDot(s.substring(i), tmp + substr + '.', res, count+1);
            }
        }
    }
}
