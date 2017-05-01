package com.example.BitManipulation;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Example:

5 / 2 = 2
Also, consider if there can be overflow cases. For overflow case, return INT_MAX.
 */
public class DivideIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        if(divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        int result = 0;
        while(pDividend>=pDivisor){
            int numShift = 0;
            while(pDividend>=(pDivisor<<numShift)){
                numShift++;
            }

            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }

        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        }else{
            return -result;
        }
    }
}
