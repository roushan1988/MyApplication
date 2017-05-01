package com.example.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
N number of books are given.
The ith book has Pi number of pages.
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

NOTE: Return -1 if a valid assignment is not possible

Input:
 List of Books M number of students

Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion :
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class AllocateBooks {
    public int books(ArrayList<Integer> a, int b) {
        return (int)partition(a, b);
    }

    private static long partition(ArrayList<Integer> a, int k) {
        if(a.size() < k)
            return -1;
        Long[] b = cumulativeSum(a);
        long hi , lo ;
        lo = Collections.max(a);
        hi = b[b.length-1];

        while (lo < hi) {
            long mid = lo + (hi-lo)/2;
            int requiredPainters = requiredPainters(a, mid);
            if (requiredPainters <= k)
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }
    private static int requiredPainters(ArrayList<Integer> a, long maxLengthPerPainter){
        long totalPainted = 0;
        int numPainters = 1;
        for(int i=0; i<a.size(); i++){
            totalPainted+=a.get(i);
            if(totalPainted >maxLengthPerPainter){
                numPainters++;
                totalPainted = a.get(i);
            }
        }
        return numPainters;
    }

    private static Long[] cumulativeSum(ArrayList<Integer> a){
        Long[] b = new Long[a.size()];
        b[0] = (long)a.get(0);
        for(int i=1;i<a.size();i++)
            b[i] = a.get(i) + b[i-1];
        return b;
    }
}
