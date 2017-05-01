package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Find if Given number is power of 2 or not.
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number if a power of 2 else return 0

Example:

Input : 128
Output : 1
 */
public class PowerOf2 {
    public int power(String a) {
        if(a.length() == 1){
            if(a.charAt(0) == '2'|| a.charAt(0) =='4' || a.charAt(0) == '8')
                return 1;
            return 0;
        }else{
            while(!isOne(a) && isEven(a)){
                a = divideBy2(a);
            }
            if(isOne(a))
                return 1;
            else
                return 0;
        }
    }
    private static String divideBy2(String num){
        int base = 10;
        StringBuilder tempBuilder = new StringBuilder();

        for(int i = 0, rem = 0; i < num.length() ; i++) {
            int currentDigit = (num.charAt(i) - '0') + rem * base;
            int val = currentDigit / 2;
            rem = currentDigit % 2;
            tempBuilder.append(String.valueOf(val));
        }
        while(tempBuilder.charAt(0) == '0' && tempBuilder.length() >0)
            tempBuilder.deleteCharAt(0);
        return tempBuilder.toString();
    }

    private static boolean isEven(String num){
        if((num.charAt(num.length()-1) -'0' & 1) != 0)
            return false;
        else
            return true;
    }

    private static boolean isOne(String num){
        if(num.length() > 1)
            return false;
        else if(num.charAt(0) == '1')
            return true;
        else
            return false;
    }
}
