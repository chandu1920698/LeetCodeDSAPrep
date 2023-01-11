/*
Class Name  : SurroundedRegions
Description : This class consists of the solution for SurroundedRegions.
Created Date: Jan 11, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/surrounded-regions/description/

Modification Log: 
Date				    Name                                            Description
Jan 11, 2022			Chandra Sekhar Reddy Muthumula					Added Class SurroundedRegions
Jan 11, 2022			Chandra Sekhar Reddy Muthumula					Added solve
Jan 11, 2022			Chandra Sekhar Reddy Muthumula					Added helper
--------------------------------------------------------------------------------------------------
130. Surrounded Regions
Medium
6.4K
1.4K
Companies
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
-------------------------------------------------------------------------------------------
*/
package Problems.SurroundedRegions;

public class SurroundedRegions {
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            if(grid[i][0] == 'O') helper(grid, i, 0);
            if(grid[i][grid[0].length - 1] == 'O') helper(grid, i, grid[0].length - 1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            if(grid[0][i] == 'O') helper(grid, 0, i);
            if(grid[grid.length - 1][i] == 'O') helper(grid, grid.length - 1, i);
        }

        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if(grid[i][j] == '*'){
                    grid[i][j] = 'O';
                }
            }
        }
        return;
    }

    private void helper(char[][] grid, int i, int j) {
        if(i >=0 && i <= grid.length - 1 && j >= 0 && j <= grid[0].length - 1) {
            if(grid[i][j] == 'O') {
                grid[i][j] = '*';
                for (int[] direction : directions) {
                    int row = i + direction[0];
                    int column = j + direction[1];
                    helper(grid, row, column);
                }
            }            
        } else {
            return; 
        }
    }
}