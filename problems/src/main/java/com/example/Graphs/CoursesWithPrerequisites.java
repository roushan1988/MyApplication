package com.example.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class CoursesWithPrerequisites {

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[][] prerequisites = new int[C.size()][B.size()];
        for(int i=0; i<C.size(); i++)
            prerequisites[i][0] = B.get(i);

        for(int i=0; i<C.size(); i++)
            prerequisites[i][1] = C.get(i);
        return canFinish(A, prerequisites) ? 1 : 0;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }

        //store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }

        // number of courses that have no prerequisites
        int numNoPre = queue.size();

        while(!queue.isEmpty()){
            int top = queue.remove();
            for(int i=0; i<len; i++){
                // if a course's prerequisite can be satisfied by a course in queue
                if(prerequisites[i][1]==top){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return numNoPre == numCourses;
    }

}
