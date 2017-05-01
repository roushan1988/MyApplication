package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.io.*;

public class Solution {
    //System.out.print(flip("1101010001"));
    // System.out.print(flip("0111000100010"));
    // System.out.print(flip("010"));
    public static void main(String[] args) throws Exception {
        String A1[] = {"pear", "amleth", "dormitory", "tinsel", "dirty room", "hamlet", "listen", "silent"};
        Integer A2[] = {30, -13, -70, 58, -34, 79, -36, 27};
        Integer A[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        Integer A3[] = {10, 12};
        Character[][] b = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(/*nchoc(10, new ArrayList<>(Arrays.asList(A1)))*/);
        groupAnagrams(A1);
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        String polygon = null;
        String input = null;
        Integer i = Integer.parseInt(br.readLine());
        while((input=br.readLine())!=null){
            System.out.println(input);
        }
    }

    private class PersistedURL{
        String encodedURL, fullURL;

    }

    Map<Integer, String> idToUrlMap;
    public static String host = "tinyurl.com/";

    public String encode(String longUrl) {
        if(idToUrlMap == null)
            idToUrlMap = new HashMap<>();
        int id = idToUrlMap.size();
        idToUrlMap.put(id, longUrl);
        StringBuilder builder = new StringBuilder();
        builder.append(host)
                .append(":")
                .append(id);
        return builder.toString() ;
    }

    public String decode(String shortUrl) throws Exception {
        String[] split = shortUrl.split(":");
        int id;
        if(split.length == 2){
            id = Integer.parseInt(split[1]);
        }else
            throw new Exception("Unsupported shortURL");

        return idToUrlMap.get(id);
    }



    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> result = new ArrayList<String>();

        int m = board.length;
        int n = board[0].length;

        for (String word : words) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char[][] newBoard = new char[m][n];
                    for (int x = 0; x < m; x++)
                        for (int y = 0; y < n; y++)
                            newBoard[x][y] = board[x][y];

                    if (dfs(newBoard, word, i, j, 0)) {
                        flag = true;
                    }
                }
            }
            if (flag) {
                result.add(word);
            }
        }

        return result;
    }

    public boolean searchWord(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int wordPos) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || wordPos > word.length() - 1) {
            return false;
        }
        if(board[i][j] == word.charAt(wordPos)){
            char temp = board[i][j];
            board[i][j] = '!';
            if (wordPos == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, wordPos + 1)
                    || dfs(board, word, i + 1, j, wordPos + 1)
                    || dfs(board, word, i, j - 1, wordPos + 1)
                    || dfs(board, word, i, j + 1, wordPos + 1)) {
                board[i][j] = temp;
                return true;
            }
        }else {
            return false;
        }
        return false;
    }

    public boolean dfs2(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || k > word.length() - 1) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';

            if (k == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, k + 1)
                    || dfs(board, word, i + 1, j, k + 1)
                    || dfs(board, word, i, j - 1, k + 1)
                    || dfs(board, word, i, j + 1, k + 1)) {
                board[i][j] = temp;
                return true;
            }

        } else {
            return false;
        }

        return false;
    }

    //
    Set<String> result = new HashSet<String>();
    public List<String> findWords2(char[][] board, String[] words) {
        //HashSet<String> result = new HashSet<String>();

        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        int m=board.length;
        int n=board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<String>(result);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie){
        int m=board.length;
        int n=board[0].length;

        if(i<0 || j<0||i>=m||j>=n){
            return;
        }

        if(visited[i][j])
            return;

        str = str + board[i][j];

        if(!trie.startsWith(str))
            return;

        if(trie.search(str)){
            result.add(str);
        }

        visited[i][j]=true;
        dfs(board, visited, str, i-1, j, trie);
        dfs(board, visited, str, i+1, j, trie);
        dfs(board, visited, str, i, j-1, trie);
        dfs(board, visited, str, i, j+1, trie);
        visited[i][j]=false;
    }

    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    //Trie
    class Trie{
        public TrieNode root = new TrieNode();

        public void insert(String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a']==null){
                    node.children[c-'a']= new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.item = word;
        }

        public boolean search(String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a']==null)
                    return false;
                node = node.children[c-'a'];
            }
            if(node.item.equals(word)){
                return true;
            }else{
                return false;
            }
        }

        public boolean startsWith(String prefix){
            TrieNode node = root;
            for(char c: prefix.toCharArray()){
                if(node.children[c-'a']==null)
                    return false;
                node = node.children[c-'a'];
            }
            return true;
        }
    }


    static Map<String, String> methodToObfusName;
    public static void preProcess(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        try {
            methodToObfusName = new HashMap<>();
            String currentClass = null, currClassObs = null, currMethod, currMethodObs;
            StringBuilder builder1 = new StringBuilder();
            StringBuilder builder2 = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null){
                String[] splitted = line.split("->");
                if(!splitted[0].endsWith("()")){ //class

                    currentClass = splitted[0];
                    currClassObs = splitted[1];
                }else{                           //method
                    builder2.setLength(0);
                    builder1.setLength(0);
                    currMethod = splitted[0];
                    currMethodObs = splitted[1];
                    String [] split2 = currMethod.substring(0, currMethod.length()-2).split("\\s+");
                    builder1.append(currentClass)
                            .append(split2[1]);
                    builder2.append(currClassObs)
                            .append(currMethodObs);
                   methodToObfusName.put(builder1.toString(), builder2.toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
        }
    }

    public static String getObsName(String key){
        return methodToObfusName.get(key);
    }

    public static void groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)==' '){
                    continue;
                }
                arr[(str.charAt(i)-'a')]++;
            }
            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());
        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> strings, List<String> t1) {
                return strings.get(0).compareTo(t1.get(0));
            }
        });
        System.out.print(result);
    }


}
