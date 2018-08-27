package com.example.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int carry  = 0; int sum = 0;
        sum = a.get(a.size() -1) + 1;
        if(sum > 9){
            carry = 1;
            result.add(0);
        }else
            result.add(sum);
        for(int i = a.size() -2; i>=0; i--){
            if(carry > 0){
                sum = a.get(i) + carry;
                if(sum > 9){
                    carry = 1;
                    result.add(0);
                }else {
                    carry = 0;
                    result.add(sum);
                }
            }else {
                carry = 0;
                result.add(a.get(i));
            }

        }
        if(carry > 0)
            result.add(1);
        for(int i = result.size()-1 ; i >=0;i--){
            if(result.get(i) == 0)
                result.remove(i);
            else
                break;
        }
        Collections.reverse(result);
        return result;
    }

    public ArrayList<Integer> plusOne2(ArrayList<Integer> a) {
        int size = a.size();
        int carry = 1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i=size-1;i>=0;i--){
            int num = a.get(i);
            num = num + carry;
            carry = 0;

            if (num == 10){
                carry = 1;
                num = 0;
            }
            a.set(i,num);

        }
        if (carry==1)
            res.add(1);

        for (int elem:a){
            if (( elem == 0) && (res.size() == 0))
            {
                continue;
            }

            res.add(elem);
        }



        return res;
    }
}
