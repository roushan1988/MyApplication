package com.example.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */

/*
Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.

Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
public class WordLadder2 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 1, null));

        dict.add(end);

        int minStep = 0;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>();
        unvisited.addAll(dict);

        int preNumSteps = 0;

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;

            if(word.equals(end)){
                if(minStep == 0){
                    minStep = top.numSteps;
                }

                if(top.numSteps == minStep && minStep !=0){
                    //nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre !=null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }

            }

            if(preNumSteps < currNumSteps){
                unvisited.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1, top));
                        visited.add(newWord);
                    }

                    arr[i]=temp;
                }
            }


        }

        return result;
    }

    private  static class WordNode{
        String word;
        int numSteps;
        WordNode pre;

        public WordNode(String word, int numSteps, WordNode pre){
            this.word = word;
            this.numSteps = numSteps;
            this.pre = pre;
        }
    }
}
