package com.example.Trees;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
 */
public class ShortestUniquePrefix {
    static int MAX = 256;
    public ArrayList<String> prefix(ArrayList<String> a) {
        ArrayList<String> result = new ArrayList<>(a);
        TrieNode root = getRoot();
        populateTrie(a, root);
        findPrefixesUtil(result, root, new char[maxWordLen(a)], 0);
        return result;
    }

    static int maxWordLen(ArrayList<String> a){
        int max = Integer.MIN_VALUE;
        for (String temp : a){
            if(max < temp.length());
            max = temp.length();
        }
        return max;
    }

    public static void findPrefixesUtil(ArrayList<String> result, TrieNode root, char[] builder, int index){
        if(root.count == 1){
            int pos = result.indexOf(root.word);
            result.set(pos, new String(builder, 0, index));
            return;
        }

        for(int i=0; i<MAX; i++){
            if(root.child[i] != null) {
                builder[index] = ((char)i);
                findPrefixesUtil(result, root.child[i], builder, index + 1);
            }
        }
    }
    public static void populateTrie(ArrayList<String> a, TrieNode root){
        int index; TrieNode tempRoot;
        for(String temp : a){
            tempRoot = root;
            for(int i=0; i<temp.length(); i++){
                index = temp.charAt(i);
                if(tempRoot.child[index] == null){
                    tempRoot.child[index] = getNewTrieNode();
                }else{
                    tempRoot.child[index].count ++;
                }
                tempRoot = tempRoot.child[index];
                tempRoot.word = temp;
            }

        }
    }

    static class TrieNode{
        int count;
        TrieNode[] child;
        String word;
    }

    static TrieNode getNewTrieNode(){
        TrieNode node = new TrieNode();
        node.count = 1;
        node.child = new TrieNode[MAX];
        return node;
    }

    static TrieNode getRoot(){
        TrieNode node = new TrieNode();
        node.count = 0;
        node.child = new TrieNode[MAX];
        return node;
    }
}
