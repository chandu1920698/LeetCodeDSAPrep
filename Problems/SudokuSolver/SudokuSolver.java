/*
Class Name  : SudokuSolver
Description : This class consists of the solution for SudokuSolver.
Date        : Oct 31, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/sudoku-solver/

Modification Log: 
Date					Name                                            Description
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class SudokuSolver 
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added solveSudoku
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added solveSudokuHelper
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added isSafe
--------------------------------------------------------------------------------------------------
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [
                ["5","3",".",".","7",".",".",".","."],
                ["6",".",".","1","9","5",".",".","."],
                [".","9","8",".",".",".",".","6","."],
                ["8",".",".",".","6",".",".",".","3"],
                ["4",".",".","8",".","3",".",".","1"],
                ["7",".",".",".","2",".",".",".","6"],
                [".","6",".",".",".",".","2","8","."],
                [".",".",".","4","1","9",".",".","5"],
                [".",".",".",".","8",".",".","7","9"]
                ]
Output: [
        ["5","3","4","6","7","8","9","1","2"],
        ["6","7","2","1","9","5","3","4","8"],
        ["1","9","8","3","4","2","5","6","7"],
        ["8","5","9","7","6","1","4","2","3"],
        ["4","2","6","8","5","3","7","9","1"],
        ["7","1","3","9","2","4","8","5","6"],
        ["9","6","1","5","3","7","2","8","4"],
        ["2","8","7","4","1","9","6","3","5"],
        ["3","4","5","2","8","6","1","7","9"]
        ]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
-------------------------------------------------------------------------------------------
*/
package Problems.SudokuSolver;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    public boolean solveSudokuHelper(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (emptyLeft == false) {
                break;
            }
        }
        if (emptyLeft == true)
            return true;
        for (int number = 1; number <= n; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = (char) (number + '0');
                if (solveSudokuHelper(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, int num) {
        // Check for the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] - '0' == num) {
                return false;
            }
        }
        // check in the column
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] - '0' == num) {
                return false;
            }
        }
        // check for the sub square
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] - '0' == num) {
                    return false;
                }
            }
        }
        return true;
    }
}