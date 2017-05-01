package com.example.Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
For example,

A = 30
B = 12
We return
X = 5
 */
public class LargestCoprimeDivisor {
    public int cpFact(int A, int B) {
        List<Integer> factors = new ArrayList<>();
        for(int i=1; i<=(int) Math.sqrt(A); i++){
            if(A%i==0){
                factors.add(i);
                if(A/i!=i){
                    factors.add(A/i);
                }
            }
        }
        Collections.sort(factors, Collections.reverseOrder());
        for(int factor: factors){
            if(gcd(B, factor)==1){
                return factor;
            }
        }
        return 1;
    }
    public int gcd(int a, int b) {
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        int a1 = Math.max(a, b);
        int a2 = (a1==a)? b : a;
        int remainder = a1 % a2;
        int quotient = a2;
        while(remainder!=0){
            int temp = quotient;
            quotient = remainder;
            remainder = temp % remainder;
        }
        return quotient;
    }
}
