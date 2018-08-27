package com.example.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;

public class MinXOR {

    //O(nLogn)
    public int findMinXor(ArrayList<Integer> A) {
        // Sort given array
        Collections.sort(A);

        int minXor = Integer.MAX_VALUE;
        int val = 0;

        // calculate min xor of consecutive pairs
        for (int i = 0; i < A.size() - 1; i++) {
            val = A.get(i) ^ A.get(i + 1);
            minXor = Math.min(minXor, val);
        }

        return minXor;

    }

    //O(n)
    static final int INT_SIZE = 32;

    // A Trie Node
    static class TrieNode {
        int value; // used in leaf node
        TrieNode[] Child = new TrieNode[2];

        public TrieNode()
        {
            value = 0;
            Child[0] = null;
            Child[1] = null;
        }
    }

    static TrieNode root;

    // utility function insert new key in trie
    static void insert(int key) {
        TrieNode temp = root;

        // start from the most significant bit, insert all
        // bit of key one-by-one into trie
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            // Find current bit in given prefix
            int current_bit = (key & (1 << i)) >= 1 ? 1 : 0;

            // Add a new Node into trie
            if (temp != null && temp.Child[current_bit] == null)
                temp.Child[current_bit] = new TrieNode();

            temp = temp.Child[current_bit];
        }

        // store value at leafNode
        temp.value = key;
    }

    // Returns minimum XOR value of an integer inserted
    // in Trie and given key.
    static int minXORUtil(int key)
    {
        TrieNode temp = root;

        for (int i = INT_SIZE - 1; i >= 0; i--) {
            // Find current bit in given prefix
            int current_bit = (key & (1 << i)) >= 1 ? 1 : 0;

            // Traversal Trie, look for prefix that has
            // same bit
            if (temp.Child[current_bit] != null)
                temp = temp.Child[current_bit];

                // if there is no same bit.then looking for
                // opposite bit
            else if (temp.Child[1 - current_bit] != null)
                temp = temp.Child[1 - current_bit];
        }

        // return xor value of minimum bit difference value
        // so we get minimum xor value
        return key ^ temp.value;
    }

    static int minXOR(int arr[], int n)
    {
        int min_xor = Integer.MAX_VALUE; // Initialize result

        // create a True and insert first element in it
        root = new TrieNode();
        insert(arr[0]);

        // Traverse all array element and find minimum xor
        // for every element
        for (int i = 1; i < n; i++) {
            // Find minimum XOR value of current element with
            // previous elements inserted in Trie
            min_xor = Math.min(min_xor, minXORUtil(arr[i]));

            // insert current array value into Trie
            insert(arr[i]);
        }
        return min_xor;
    }
}
