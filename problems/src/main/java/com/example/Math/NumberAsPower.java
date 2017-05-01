package com.example.Math;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */

public class NumberAsPower {
    public boolean isPower(int a) {
        if(a<=1){
            return true;
        }
        for(int i=2; i<=Math.sqrt(a); i++){
            int base =i;
            while (base<=a/i){
                base*=i;
                if(base==a){
                    return true;
                }
            }
        }
        return false;
    }
}
