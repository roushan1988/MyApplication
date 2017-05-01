package com.example.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'
You may assume that there will be only one unique solution.

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 */
public class Sudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solve(a);
    }

    private static class Result{
        ArrayList<ArrayList<Character>> board;
        boolean status;

        public Result(boolean status, ArrayList<ArrayList<Character>> board) {
            this.status = status;
            this.board = board;
        }
    }

    private static Result solve(ArrayList<ArrayList<Character>> board){
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board.size(); j++){
                if(board.get(i).get(j) !='.')
                    continue;

                for(int k=1; k<=board.size(); k++){
                    board.get(i).set(j, (char) (k+'0')) ;
                    if(isValid(board, i, j)){
                        Result result = solve(board);
                        if(result.status)
                            return result;
                    }
                    board.get(i).set(j, '.');
                }

                return new Result(false, null);
            }
        }

        return new Result(true, board);
    }

    private static boolean isValid(ArrayList<ArrayList<Character>>board, int i, int j){
        HashSet<Character> set = new HashSet<Character>();

        for(int k=0; k<9; k++){
            if(set.contains(board.get(i).get(k)))
                return false;

            if(board.get(i).get(k)!='.' ){
                set.add(board.get(i).get(k));
            }
        }

        set.clear();

        for(int k=0; k<9; k++){
            if(set.contains(board.get(k).get(j)))
                return false;

            if(board.get(k).get(j)!='.' ){
                set.add(board.get(k).get(j));
            }
        }

        set.clear();

        for(int m=0; m<3; m++){
            for(int n=0; n<3; n++){
                int x=i/3*3+m;
                int y=j/3*3+n;
                if(set.contains(board.get(x).get(y)))
                    return false;

                if(board.get(x).get(y)!='.'){
                    set.add(board.get(x).get(y));
                }
            }
        }

        return true;
    }
}
