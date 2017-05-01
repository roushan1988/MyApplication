package com.example.Trees;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 */
public class LCA {

    public int lca(TreeNode a, int val1, int val2) {
        Result result = lcaHelper(a, val1, val2);
        if(result.isAncestor)
            return result.node != null ? result.node.val :-1;
        return -1;
    }

    public static class Result{
        TreeNode node;
        boolean isAncestor;

        public Result(TreeNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }

    public Result lcaHelper(TreeNode root, int p, int q){
        if(root == null)
            return new Result(null, false);
        if(root.val == p && root.val == q)
            return new Result(root, true);
        Result rleft = lcaHelper(root.left, p, q);
        if(rleft.isAncestor)
            return rleft;
        Result rRigt = lcaHelper(root.right, p, q);
        if(rRigt.isAncestor)
            return rRigt;

        if(rleft.node != null && rRigt.node != null){
            return new Result(root, true);
        }else if(root.val == p || root.val == q){
            boolean isAncestor = rleft.node != null || rRigt.node != null;
            return new Result(root, isAncestor);
        }else
            return new Result(rleft.node != null ? rleft.node : rRigt.node, false);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
