package com.example.Hashing;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidSudoku {
    public int isValidSudoku(final List<String> a) {
        if (a == null || a.size() != 9 || a.get(0).length() != 9)
            return 0;

        if(checkCol(a) == 0)
            return 0;

        if(checkRow(a) == 0)
            return 0;

        if(checkBox(a) == 0)
            return 0;
        return 1;
    }

    private static int checkCol(List<String> a){
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (a.get(i).charAt(j) != '.') {
                    if (m[(int) (a.get(i).charAt(j) - '1')]) {
                        return 0;
                    }
                    m[(int) (a.get(i).charAt(j) - '1')] = true;
                }
            }
        }
        return 1;
    }

    private static int checkRow(List<String> a){
        for (int j = 0; j < 9; j++) {
            boolean[] m = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (a.get(i).charAt(j) != '.') {
                    if (m[(int) (a.get(i).charAt(j) - '1')]) {
                        return 0;
                    }
                    m[(int) (a.get(i).charAt(j) - '1')] = true;
                }
            }
        }
        return 1;
    }

    private static int checkBox(List<String> a){
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (a.get(i).charAt(j) != '.') {
                        if (m[(int) (a.get(i).charAt(j) - '1')]) {
                            return 0;
                        }
                        m[(int) (a.get(i).charAt(j) - '1')] = true;
                    }
                }
            }
        }
        return 1;
    }
}
