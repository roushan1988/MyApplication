package com.example.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneGraph {
    class UndirectedGraphNode {
             int label;
             List<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
         };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeToCloneMap = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        nodeToCloneMap.put(node, new UndirectedGraphNode(node.label));
        while (!q.isEmpty()){
            UndirectedGraphNode u = q.poll();
            UndirectedGraphNode cloneNodeU = nodeToCloneMap.get(u);
            if(u.neighbors != null){

                for (UndirectedGraphNode graphNode : u.neighbors)
                {
                    UndirectedGraphNode cloneNodeG = nodeToCloneMap.get(graphNode);

                    if (cloneNodeG == null)
                    {
                        q.add(graphNode);
                        cloneNodeG = new UndirectedGraphNode(graphNode.label);
                        nodeToCloneMap.put(graphNode,cloneNodeG);
                    }

                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }
        return nodeToCloneMap.get(node);
    }
}
