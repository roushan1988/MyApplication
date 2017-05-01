package com.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by shwetatrivedi1 on 2/3/17.
 */
/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 */
// http://www.programcreek.com/2014/04/leetcode-surrounded-regions-java/

public class CaptureRegions {
    public void solve(ArrayList<ArrayList<Character>> a) {
        if(a==null || a.size()==0 || a.get(0).size()==0)
            return;
        int m=a.size();
        int n=a.get(0).size();

        for(int j=0; j<n; j++){
            if(a.get(0).get(j)=='O'){
                bfs(a, 0, j);
            }
        }

        for(int j=0; j<n; j++){
            if(a.get(m-1).get(j)=='O'){
                bfs(a, m-1, j);
            }
        }

        for(int i=0; i<m; i++){
            if(a.get(i).get(0)=='O'){
                bfs(a, i, 0);
            }
        }

        for(int i=0; i<m; i++){
            if(a.get(i).get(n-1)=='O'){
                bfs(a, i, n-1);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(a.get(i).get(j)=='O'){
                    a.get(i).set(j,'X');
                }
                if(a.get(i).get(j)=='1'){
                    a.get(i).set(j,'O');
                }
            }
        }
    }

    private void bfs(ArrayList<ArrayList<Character>> a, int x, int y){
        int m=a.size();
        int n=a.get(0).size();

        int index = x*n+y;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        a.get(x).set(y, '1');

        while(!queue.isEmpty()){
            int top = queue.poll();
            int i=top/n;
            int j=top%n;

            if(i-1>=0 && a.get(i-1).get(j)=='O'){
                a.get(i-1).set(j, '1');
                queue.offer((i-1)*n+j);
            }
            if(i+1<m && a.get(i+1).get(j)=='O'){
                a.get(i+1).set(j, '1');
                queue.offer((i+1)*n+j);
            }
            if(j-1>=0 && a.get(i).get(j-1)=='O'){
                a.get(i).set(j-1, '1');
                queue.offer(i*n+j-1);
            }
            if(j+1<n && a.get(i).get(j+1)=='O'){
                a.get(i).set(j+1, '1');
                queue.offer(i*n+j+1);
            }
        }
    }
}
