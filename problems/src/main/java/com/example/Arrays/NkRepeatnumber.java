package com.example.Arrays;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */

public class NkRepeatnumber {
    public int repeatedNumber(final List<Integer> a) {
        Element [] slots = new Element[2];
        for(int i=0; i<2; i++) {
            slots[i] = new Element();
            slots[i].count = 0;
        }
        for(int val : a){
            int j;
            for(j=0; j<2; j++){
                if(slots[j].value == val) {
                    slots[j].count++;
                    break;
                }
            }
            if(j == 2){
                int m;
                for(m=0;m<2;m++){
                    if(slots[m].count == 0){
                        slots[m].value = val;
                        slots[m].count = 1;
                        break;
                    }
                }
                if(m == 2){
                    for(int k=0;k<2;k++)
                        slots[k].count--;
                }
            }

        }
        for(int k=0; k<2; k++){
            int realCount = 0;
            for(int val : a){
                if(slots[k].value == val)
                    realCount ++;
            }
            if(realCount > a.size()/3)
                return slots[k].value;
        }

        return -1;
    }
    public class Element{
        int count;
        int value;
    }
}
