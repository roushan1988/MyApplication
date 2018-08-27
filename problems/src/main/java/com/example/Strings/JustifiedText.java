package com.example.Strings;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible.
If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]

L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]
 Note: Each word is guaranteed not to exceed L in length.
 */
public class JustifiedText {
    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> result = new ArrayList<String>();
        if(a==null || a.size()==0){
            return result;
        }
        int count=0, lastChosenWordPos=0;
        for(int i=0; i<a.size(); i++){
            count += a.get(i).length(); // keep adding the length of words
            if(count + i-lastChosenWordPos > b){ // till no more can be accomodated with one space for each
                int wordsCharLength = count-a.get(i).length(); //discarding last word added
                int spacChareLen = b-wordsCharLength; //Compute no. of spaces needed
                int eachLen = 1;
                int extraLen = 0;
                int numberOfWords = i-1 -lastChosenWordPos;
                if(numberOfWords >0){ //if there are 2 or more than 2 words
                    eachLen = spacChareLen/(numberOfWords); // equal space count to be distributed
                    extraLen = spacChareLen%(numberOfWords);// extra spaces that need to be accomodated
                }
                StringBuilder sb = new StringBuilder();
                for(int k=lastChosenWordPos; k<i-1; k++){ //add last chosen to one less than the pos of last word for the line
                    sb.append(a.get(k));
                    int ce = 0;
                    while(ce<eachLen){ // add all "must" spaces
                        sb.append(" ");
                        ce++;
                    }
                    if(extraLen>0){ // add the extra space if needed
                        sb.append(" ");
                        extraLen--;
                    }
                }
                sb.append(a.get(i-1)); //add last word
                while(sb.length()<b){
                    sb.append(" ");
                }
                result.add(sb.toString());

                lastChosenWordPos = i; //preparing for new line
                count=a.get(i).length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=lastChosenWordPos; i<a.size()-1; i++){
            count = count+a.get(i).length();
            sb.append(a.get(i)+" ");
        }
        sb.append(a.get(a.size()-1));
        int d=0;
        while(sb.length()<b)
            sb.append(" ");
        result.add(sb.toString());
        return result;
    }
}
