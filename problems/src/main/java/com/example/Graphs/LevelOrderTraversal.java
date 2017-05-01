package com.example.Graphs;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).
 */

public class LevelOrderTraversal {
    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>() ;
        createLevelLists(a, lists, 0);
        return lists;
    }

    private void createLevelLists(TreeNode root, ArrayList<ArrayList<Integer>> lists, int level){
        if(root == null)
            return;
        ArrayList<Integer> list = null;
        if(lists.size() == level) {
            list = new ArrayList<>();
            lists.add(list);
        } else
            list = lists.get(level);

        list.add(root.val);
        createLevelLists(root.left, lists, level+1);
        createLevelLists(root.right, lists, level+1);
    }
}
