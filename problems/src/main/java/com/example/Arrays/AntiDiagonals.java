package com.example.Arrays;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:


Input:

1 2 3
4 5 6
7 8 9

Return the following :

[
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input :
1 2
3 4
Return the following  :

[
  [1],
  [2, 3],
  [4]
]
 */
public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int rowSize = a.size();
        int colSize = a.get(0).size();
        for(int line = 1; line <= rowSize + colSize -1; line++){
            int row = Math.max(0, line-rowSize);
            int count = Math.min(Math.min(line, colSize - row), Math.min(line, rowSize));
            ArrayList<Integer> resRow = new ArrayList<>(count);
            for(int j=0; j<count; j++){
                int aRow = Math.min(rowSize, line) - j -1;
                int aCol = row + j;
                resRow.add(a.get(aCol).get(aRow));
            }
            result.add(resRow);
        }
        return result;
    }

    // The main function that prints given
// matrix in diagonal order
    static void diagonalOrder(int matrix[][]) {
        int ROW = matrix.length;
        int COL = matrix[0].length;
        // There will be ROW+COL-1 lines in the output
        for (int line = 1; line <= (ROW + COL - 1); line++) {

            // Get column index of the first element in this
            // line of output.The index is 0 for first ROW
            // lines and line - ROW for remaining lines
            int start_col = Math.max(0, line - ROW);

            // Get count of elements in this line. The count
            // of elements is equal to minimum of line number,
            // COL-start_col and ROW
            int count = Math.min(Math.min(line, (COL - start_col)), ROW);

            // Print elements of this line
            for (int j = 0; j < count; j++)
                System.out.print(matrix[Math.min(ROW, line) - j - 1]
                        [start_col + j] + " ");

            // Print elements of next diagonal on next line
            System.out.println();
        }
    }
}
