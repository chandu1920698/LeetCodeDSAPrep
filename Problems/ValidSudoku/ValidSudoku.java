import java.util.HashSet;

/*
Class Name  : ValidSudoku
Description : This class consists of the solution for ValidSudoku.
Date        : Sep 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/valid-sudoku/

Modification Log: 
Date					Name                                            Description
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class ValidSudoku 
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added isValidSudoku 
--------------------------------------------------------------------------------------------------
36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 
Example 1:

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 
Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
-------------------------------------------------------------------------------------------
*/

class ValidSudoku {
    // public boolean isValidSudoku(char[][] board) {
    //     for (int i=0; i<9; i++) {
    //         HashMap<Character, Integer> mapRow = new HashMap<Character, Integer> ();
    //         HashMap<Character, Integer> mapColumn = new HashMap<Character, Integer> ();
    //         for (int j=0; j<9; j++) {
    //             char chRow = board[i][j];
    //             char chColumn = board[j][i];
    //             if(chRow != '.' && mapRow.containsKey(new Character(chRow))) {
    //                 return false;
    //             }
    //             mapRow.put(chRow, 0);
    //             if(chColumn != '.' && mapColumn.containsKey(new Character(chColumn))) {
    //                 return false;
    //             }
    //             mapColumn.put(chColumn, 0);
    //         }
    //         if (i == 1 || i == 4 || i == 7) {
    //             HashMap<Character, Integer> mapSquare = new HashMap<Character, Integer> ();
    //             for (int j=0; j<9; j++) {
    //                 if (j%3 == 0 || j%3 == 1 || j%3 == 2) {
    //                     if (board[i-1][j%3] != '.' && (mapSquare.containsKey(board[i-1][j%3]) || mapSquare.containsKey(board[i-1][j%3]) || mapSquare.containsKey(board[i-1][j%3]))) {
    //                     return false;
    //                     } else {
    //                         mapSquare.put(board[i-1][j%3], 0);
    //                     }
    //                     if (board[i][j%3] != '.' && (mapSquare.containsKey(board[i][j%3]) || mapSquare.containsKey(board[i][j%3]) || mapSquare.containsKey(board[i][j%3]))) {
    //                     return false;
    //                     } else {
    //                         mapSquare.put(board[i][j%3], 0);
    //                     }
    //                     if (board[i+1][j%3] != '.' && (mapSquare.containsKey(board[i+1][j%3]) || mapSquare.containsKey(board[i+1][j%3]) || mapSquare.containsKey(board[i+1][j%3]))) {
    //                     return false;
    //                     } else {
    //                         mapSquare.put(board[i+1][j%3], 0);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
    
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> seen = new HashSet<String>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char number = board[i][j];
                if (number != '.') {
                   if (!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}