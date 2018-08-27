package com.example.Graphs;

import com.example.Solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveObstacle {
    static boolean[][] visited ;
    static void initializeVisited(int numRows, int numCols, List<List<Integer>> lot){
        // To keep track of visited QItems. Marking
        // blocked cells as visited.
        visited = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++)
            {
                if (lot.get(i).get(j) == 0)
                    visited[i][j] = true;
                else
                    visited[i][j] = false;

            }
        }
    }
    static int removeObstacle(int numRows, int numCols, List<List<Integer>> lot){
        initializeVisited(numRows, numCols, lot);
        Node source = new Node(0, 0, 0);
        Queue<Node> queue = new LinkedList<>();

        queue.offer(source);
        visited[source.row][source.col] = true;
        while (!queue.isEmpty()){
            Node p = queue.poll();
            // Destination found;
            if (lot.get(p.row).get(p.col) == 9)
                return p.dist;
            if (p.row - 1 >= 0 &&
                    visited[p.row - 1][p.col] == false) {
                queue.offer(new Node(p.row - 1, p.col, p.dist + 1));
                visited[p.row - 1][p.col] = true;
            }

            // moving down
            if (p.row + 1 < numRows &&
                    visited[p.row + 1][p.col] == false) {
                queue.offer(new Node(p.row + 1, p.col, p.dist + 1));
                visited[p.row + 1][p.col] = true;
            }

            // moving left
            if (p.col - 1 >= 0 &&
                    visited[p.row][p.col - 1] == false) {
                queue.offer(new Node(p.row, p.col - 1, p.dist + 1));
                visited[p.row][p.col - 1] = true;
            }

            // moving right
            if (p.col + 1 < numCols &&
                    visited[p.row][p.col + 1] == false) {
                queue.offer(new Node(p.row, p.col + 1, p.dist + 1));
                visited[p.row][p.col + 1] = true;
            }
        }
        return -1;
    }

    static class Node {
        int row;
        int col;
        int dist;

        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
