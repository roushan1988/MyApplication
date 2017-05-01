package com.example.Trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shwetatrivedi1 on 2/16/17.
 */

public class AutocompletingTrie {
    protected final Map<Character, AutocompletingTrie> children;
    protected String value;
    protected boolean terminal = false;

    public AutocompletingTrie() {
        this(null);
    }

    private AutocompletingTrie(String value) {
        this.value = value;
        children = new HashMap<>();
    }

    protected void add(char c) {
        String val;
        if (this.value == null) {
            val = Character.toString(c);
        } else {
            val = this.value + c;
        }
        children.put(c, new AutocompletingTrie(val));
    }

    public void insert(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Cannot add null to a AutocompletingTrie");
        }
        AutocompletingTrie node = this;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.add(c);
            }
            node = node.children.get(c);
        }
        node.terminal = true;
    }

    public String find(String word) {
        AutocompletingTrie node = this;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return "";
            }
            node = node.children.get(c);
        }
        return node.value;
    }

    public Collection<String> autoComplete(String prefix) {
        AutocompletingTrie node = this;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return Collections.emptyList();
            }
            node = node.children.get(c);
        }
        return node.allPrefixes();
    }

    protected Collection<String> allPrefixes() {
        List<String> results = new ArrayList<>();
        if (this.terminal) {
            results.add(this.value);
        }
        for (Map.Entry<Character, AutocompletingTrie> entry : children.entrySet()) {
            AutocompletingTrie child = entry.getValue();
            Collection<String> childPrefixes = child.allPrefixes();
            results.addAll(childPrefixes);
        }
        return results;
    }

    public static void main(String[] args){
        AutocompletingTrie trie = new AutocompletingTrie();
        String word = "apple";
        trie.insert(word);
        String prefix = "app";
        trie.autoComplete(prefix);
    }
}
