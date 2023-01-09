/*
Class Name  : WordSearch
Description : This class consists of the solution for WordSearch.
Created Date: Jan 9, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/word-search/description/

Modification Log: 
Date				Name                                            Description
Jan 9, 2022			Chandra Sekhar Reddy Muthumula					Added Class WordSearch
Jan 9, 2022			Chandra Sekhar Reddy Muthumula					Added exist
Jan 9, 2022			Chandra Sekhar Reddy Muthumula					Added search 
--------------------------------------------------------------------------------------------------
79. Word Search
Medium
12.5K
503
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
-------------------------------------------------------------------------------------------
*/
package Problems.WordSearch;

public class WordSearch {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        // list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) {
            // The word is found
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j] == true) {
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i - 1, j, index + 1) || 
            search(board, word, i, j - 1, index + 1) || 
            search(board, word, i + 1, j, index + 1) || 
            search(board, word, i, j + 1, index + 1) ) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}