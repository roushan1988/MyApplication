package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */

public class Pallindrome {
    public int isPalindrome(String a) {
        if(a == null || a.length() == 1)
            return 1;
        a = a.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n = a.length();
        for(int i = 0; i < n/2; i++){
            if(a.charAt(i) != a.charAt(n-1-i))
                return 0;
        }a.su
        return 1;
    }
}
