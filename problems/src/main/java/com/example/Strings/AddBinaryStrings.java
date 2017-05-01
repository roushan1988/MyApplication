package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.
 */
public class AddBinaryStrings {
    private static String result = "";
    public String addBinary(String a, String b) {
        result = "";
        if((a == "" || a.length() == 0) && (b == "" || b.length() == 0)){
            return "0";
        }
        if((a == "" || a.length() == 0))
            return b;

        if((b == "" || b.length() == 0))
            return a;
        char carry = '0';
        int i = a.length()-1;
        int j = b.length()-1;
        while(i >= 0 && j >= 0){
            char ca = a.charAt(i);
            i--;
            char cb = b.charAt(j);
            j--;
            carry = add(ca, cb, carry);
        }

        while(i >= 0){
            carry = add(a.charAt(i), '0', carry);
            i--;
        }
        while(j >= 0){
            carry = add('0', b.charAt(j), carry);
            j--;
        }
        if(carry == '1') {
            return carry + result;
        }
        return result;
    }

    private static char add(char ca, char cb, char carry){
        if(carry == '0'){
            if(ca == '0' && cb == '0'){
                carry = '0';
                result = "0" + result;
            }
            else if(ca == '1' && cb == '0'){
                carry = '0';
                result = "1" + result;
            }
            else if(ca == '0' && cb == '1') {
                carry = '0';
                result = "1" + result;
            }
            else if(ca == '1' && cb == '1') {
                result = "0" + result;
                carry = '1';
            }
        }else {
            if(ca == '0' && cb == '0'){
                carry = '0';
                result = "1" + result;
            }else if(ca == '1' && cb == '0'){
                carry = '1';
                result = "0" + result;
            }
            else if(ca == '0' && cb == '1') {
                carry = '1';
                result = "0" + result;
            }
            else if(ca == '1' && cb == '1') {
                result = "1" + result;
                carry = '1';
            }
        }
        return carry;
    }
}
