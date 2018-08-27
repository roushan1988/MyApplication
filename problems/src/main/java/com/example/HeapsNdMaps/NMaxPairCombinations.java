package com.example.HeapsNdMaps;




import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/*
Given two arrays A & B of size N each.
Find the maximum n elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
and maximum 2 elements are 6, 5

Example:

N = 4
a[]={1,4,2,3}
b[]={2,5,1,6}

Maximum 4 elements of combinations sum are
10   (4+6),
9    (3+6),
9    (4+5),
8    (2+6)
 */
public class NMaxPairCombinations {
    private static class pair<S,T>
    {
        S first;
        T second;
        pair(S first,T second)
        {
            this.first = first; this.second = second;
        }
    };


    public static ArrayList<Integer> solve2(ArrayList<Integer> A, ArrayList<Integer> B) {
        // sort both arrays A and B
        Collections.sort(A);
        Collections.sort(B);
        ArrayList<Integer> result = new ArrayList<>();
        int N = A.size();

        // Max heap which contains tuple of the format
        // (sum, (i, j)) i and j are the indices
        // of the elements from array A
        // and array B which make up the sum.
        PriorityQueue<pair<Integer, pair<Integer, Integer> > > pq = new PriorityQueue<>(N, new Comparator<pair<Integer, pair<Integer, Integer>>>() {
            @Override
            public int compare(pair<Integer, pair<Integer, Integer>> a, pair<Integer, pair<Integer, Integer>> b) {
                return b.first - a.first;
            }
        });

        // my_set is used to store the indices of
        // the  pair(i, j) we use my_set to make sure
        // the indices doe not repeat inside max heap.
        Set<pair<Integer, Integer> > my_set = new HashSet<>();

        // initialize the heap with the maximum sum
        // combination ie (A[N - 1] + B[N - 1])
        // and also push indices (N - 1, N - 1) along
        // with sum.
        pq.add(new pair<Integer, pair<Integer, Integer>>(A.get(N-1) + B.get(N-1), new pair<Integer, Integer>(N-1, N-1)));

        my_set.add(new pair<>(N - 1, N - 1));

        // iterate upto K
        for (int count=0; count<N; count++) {

            // tuple format (sum, i, j).
            pair<Integer, pair<Integer, Integer> > temp = pq.poll();
            result.add(temp.first);

            int i = temp.second.first;
            int j = temp.second.second;
            int sum;pair<Integer, Integer> temp1;
            if(i>0){
                sum = A.get(i - 1) + B.get(j);

                // insert (A[i - 1] + B[j], (i - 1, j))
                // into max heap.
                temp1 = new pair<>(i - 1, j);

                // insert only if the pair (i - 1, j) is
                // not already present inside the map i.e.
                // no repeating pair should be present inside
                // the heap.
                if (!my_set.contains(temp1)) {
                    pq.add(new pair<Integer, pair<Integer, Integer>>(sum, temp1));
                    my_set.add(temp1);
                }
            }

            if(j>0){
                // insert (A[i] + B[j - 1], (i, j - 1))
                // into max heap.
                sum = A.get(i) + B.get(j-1);
                temp1 = new pair<>(i, j - 1);

                // insert only if the pair (i, j - 1)
                // is not present inside the heap.
                if (!my_set.contains(temp1)) {
                    pq.add(new pair<Integer, pair<Integer, Integer>>(sum, temp1));
                    my_set.add(temp1);
                }
            }

        }
        return result;
    }
}
