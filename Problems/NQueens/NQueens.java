/*
Class Name  : NQueens
Description : This class consists of the solution for NQueens.
Created Date: Jan 15, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/n-queens/description/

Modification Log: 
Date				    Name                                            Description
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class NQueens
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added solveNQueens
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added solveNQueensHelper
Jan 15, 2022			Chandra Sekhar Reddy Muthumula					Added isSafe
--------------------------------------------------------------------------------------------------
51. N-Queens
Hard
9.2K
208
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
-------------------------------------------------------------------------------------------
*/
package Problems.NQueens;
import java.util.*;
public class NQueens {
    public static List<List<String>> boards;
    public List<List<String>> solveNQueens(int n) {
        boards = new ArrayList<List<String>>();
        boolean[][] board = new boolean[n][n];
        solveNQueensHelper(0, board);
        return boards;
    }

    private void solveNQueensHelper(int row, boolean[][] board) {
        if(row == board.length){
            boards.add(getBoard(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                solveNQueensHelper(row + 1, board);
                board[row][col] = false;
            }
        }
        return; 
    }

    private List<String> getBoard(boolean[][] board) {
        List<String> tempBoard = new ArrayList<>();
        for(boolean[] row : board) {
            StringBuffer tempBoardString = new StringBuffer(); 
            for(boolean element : row) {
                if(element) {
                    tempBoardString.append("Q");
                } else {
                    tempBoardString.append(".");
                }
            }
            tempBoard.add(new String(tempBoardString));
        }
        // boards.add(tempBoard);
        return tempBoard;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        
        // Check the vertical elements
        int vertical = 0;
        while(vertical < row) {
            if(board[vertical][col]) {
                return false;
            }
            vertical++;
        }

        // Check left  diagonal
        int r = 1, c = 1;
        while(row - r > -1 && col - c > -1) {
            if(board[row - r][col - c]) {
                return false;
            }
            r++; 
            c++;
        }

        // Check right diagonal
        r = 1;
        c = 1;
        while(row - r >= 0 && col + c < board[0].length) {
            if(board[row - r][col + c]) {
                return false;
            }
            r++; 
            c++;
        }
        return true;
    }
}