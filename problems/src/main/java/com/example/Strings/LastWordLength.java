package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
public class LastWordLength {
    public int lengthOfLastWord(final String a) {
        int currentWord = 0;
        int lastWord = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == ' '){
                if(currentWord == 0){
                    continue;
                }
                lastWord = currentWord;
                currentWord = 0;
            }
            else{
                currentWord++;
            }
        }
        return currentWord > 0 ? currentWord : lastWord;
    }
}
