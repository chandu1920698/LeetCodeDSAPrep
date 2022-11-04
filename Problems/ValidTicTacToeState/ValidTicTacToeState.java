/*
Class Name  : ValidTicTacToeState
Description : This class consists of the solution for ValidTicTacToeState.
Date        : Nov 4, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/valid-tic-tac-toe-state/description/

Modification Log: 
Date				Name                                            Description
Nov 4, 2022			Chandra Sekhar Reddy Muthumula					Added Class ValidTicTacToeState 
Nov 4, 2022			Chandra Sekhar Reddy Muthumula					Added validTicTacToeBestApproach
Nov 4, 2022			Chandra Sekhar Reddy Muthumula					Added validTicTacToe
Nov 4, 2022			Chandra Sekhar Reddy Muthumula					Added checkForWinner
--------------------------------------------------------------------------------------------------
794. Valid Tic-Tac-Toe State

Given a Tic-Tac-Toe board as a string array board, 
return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. 
The ' ' character represents an empty square.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares ' '.
The first player always places 'X' characters, while the second player always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
 

Example 1:


Input: board = ["O  ","   ","   "]
Output: false
Explanation: The first player always plays "X".
Example 2:


Input: board = ["XOX"," X ","   "]
Output: false
Explanation: Players take turns making moves.
Example 3:


Input: board = ["XOX","O O","XOX"]
Output: true
 

Constraints:

board.length == 3
board[i].length == 3
board[i][j] is either 'X', 'O', or ' '.
-------------------------------------------------------------------------------------------
*/
package Problems.ValidTicTacToeState;

public class ValidTicTacToeState {

    public boolean validTicTacToeBestApproach(String[] board) {
        int X_count = 0, O_count = 0;
        boolean xWins = false, oWins = false;
        for (int i = 0; i < 3; i++) {
            for (char c : board[i].toCharArray()) {
                if (c == 'X') {
                    X_count++;
                } else if (c == 'O') {
                    O_count++;
                }
            }
            // Check horizontal
            if (board[i].equals("XXX")) xWins = true;
            else if (board[i].equals("OOO")) oWins = true;

            // Check vertical
            String vertical = new StringBuilder()
                                  .append(board[0].charAt(i))
                                  .append(board[1].charAt(i))
                                  .append(board[2].charAt(i))
                                  .toString();
            if (vertical.equals("XXX")) xWins = true;
            else if (vertical.equals("OOO")) oWins = true;
        }

        String diagonal1 = new StringBuilder()
                              .append(board[0].charAt(0))
                              .append(board[1].charAt(1))
                              .append(board[2].charAt(2))
                              .toString();
                              ;
        if (diagonal1.equals("XXX")) xWins = true;
        else if (diagonal1.equals("OOO")) oWins = true;

        String diagonal2 = new StringBuilder()
                              .append(board[2].charAt(0))
                              .append(board[1].charAt(1))
                              .append(board[0].charAt(2))
                              .toString();
                              ;
        if (diagonal2.equals("XXX")) xWins = true;
        else if (diagonal2.equals("OOO")) oWins = true;

        if (xWins) {
            return !oWins && X_count == O_count + 1;
        } else if (oWins) {
            return X_count == O_count;
        } 
        return X_count >= O_count && X_count - O_count <= 1;
    }

    public boolean validTicTacToe(String[] board) {
        int X_count = 0, O_count = 0, row_index = 0;
        char[][] char_board = new char[3][3];
        for (String row : board) {
            int row_len = row.length();
            for (int i = 0; i < row_len; i++) {
                char_board[row_index][i] = row.charAt(i);
                if (row.charAt(i) == 'X') {
                    X_count++;
                } else if (row.charAt(i) == 'O') {
                    O_count++;
                }
            }
            row_index++;
        }
        System.out.println("X : " + X_count + " O : " + O_count);
        System.out.println("X : " + checkForWinner(char_board, 'X'));
        System.out.println("O : " + checkForWinner(char_board, 'O'));
        if (checkForWinner(char_board, 'X')) {
            return !checkForWinner(char_board, 'O') && X_count == O_count + 1;
        } else if (checkForWinner(char_board, 'O')) {
            return X_count == O_count;
        } 
        return X_count >= O_count && X_count - O_count <= 1;
    }
    public boolean checkForWinner(char[][] char_board, char player) {
        // Horizontal check
        for (int i = 0; i < 3; i++) {
            if (char_board[i][0] == player && char_board[i][0] == char_board[i][1] && char_board[i][1] == char_board[i][2]) {
                return true;
            }
        }
        // Vertical check
        for (int i = 0; i < 3; i++) {
            if (char_board[0][i] == player && char_board[0][i] == char_board[1][i] && char_board[1][i] == char_board[2][i]) {
                return true;
            }
        }
        // Diagonal check
        if (char_board[0][0] == player && char_board[0][0] == char_board[1][1] && char_board[1][1] == char_board[2][2]) {
            return true;
        }
        if (char_board[2][0] == player && char_board[2][0] == char_board[1][1] && char_board[1][1] == char_board[0][2]) {
            return true;
        }
        return false;
    }
}