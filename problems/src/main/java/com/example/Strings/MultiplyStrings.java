package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
For example,
given strings "12", "10", your answer should be “120”.
NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
We will retroactively disqualify such submissions and the submissions will incur penalties.
 */
public class MultiplyStrings {
    public String multiply(String a, String b) {
        String n1 = new StringBuilder(a).reverse().toString();
        String n2 = new StringBuilder(b).reverse().toString();
        int[] d = new int[a.length() + b.length()];
        for(int i =0; i < n1.length(); i++){
            for(int j =0; j < n2.length(); j++){
                d[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < d.length; i++){
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if(i + 1 < d.length)
                d[i + 1] += carry;
            sb.insert(0, mod);
        }

        while(sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
