package com.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

You must change exactly one character in every transformation
Each intermediate word must exist in the dictionary

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 */
public class WordLadder1 {
    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 1));
        dictV.add(end);
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(end)){
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(dictV.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        dictV.remove(newWord);
                    }
                    arr[i]=temp;
                }
            }
        }
        return 0;
    }

    private  static class WordNode{
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }
}
