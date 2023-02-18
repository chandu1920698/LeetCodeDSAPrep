/*
Class Name  : NumberOfIslands
Description : This class consists of the solution for NumberOfIslands.
Created Date: Jan 11, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: hhttps://leetcode.com/problems/number-of-islands/description/

Modification Log: 
Date				    Name                                            Description
Jan 11, 2022			Chandra Sekhar Reddy Muthumula					Added Class NumberOfIslands
Jan 11, 2022			Chandra Sekhar Reddy Muthumula					Added numIslands
Jan 11, 2022			Chandra Sekhar Reddy Muthumula					Added helper2 
Jan 11, 2022			Chandra Sekhar Reddy Muthumula					Added helper1
Jan 11, 2022			Chandra Sekhar Reddy Muthumula					Added helper3
Feb 18, 2022			Chandra Sekhar Reddy Muthumula					Added numIslandsGraphs
--------------------------------------------------------------------------------------------------
200. Number of Islands
Medium
18.5K
409
Companies
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
-------------------------------------------------------------------------------------------
*/
package Problems.NumberOfIslands;
import java.util.*;
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    helper(grid, i, j);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    private void helper(char[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if(grid[i][j] == '1') {
                grid[i][j] = '0';
                helper(grid, i, j + 1); // Moving Right
                helper(grid, i, j - 1); // Moving left
                helper(grid, i - 1, j); // Moving up
                helper(grid, i + 1, j); // Moving down
            }            
        } else {
            return;
        }
    }

    private void helper2(char[][] grid, int i, int j) {
        if(i == grid.length || j == grid[0].length) {
            return;
        }
        grid[i][j] = '0';
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1') { // Moving Right
            helper(grid, i, j + 1);
        }
        if(j - 1 >= 0 && grid[i][j - 1] == '1') { // Moving left
            helper(grid, i, j - 1);
        }
        if(i - 1 >= 0 && grid[i - 1][j] == '1') { // Moving up
            helper(grid, i - 1, j);
        }
        if(i + 1 < grid.length && grid[i + 1][j] == '1') { // Moving down
            helper(grid, i + 1, j);
        }
    }

    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void helper3(char[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if(grid[i][j] == '1') {
                grid[i][j] = '0';
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

    public static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {0, -1}, {1, 0} };
    public int numIslandsGraphs(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        for(int  i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }
    private void dfs(int row, int col, char[][] grid, int[][] visited) {
        visited[row][col] = 1;
        LinkedList<Pair> queue = new LinkedList<>();
        queue.offerFirst(new Pair(row, col));
        while(!queue.isEmpty()) {
            Pair node = queue.pollLast();
            int r = node.first;
            int c = node.second;
            // System.out.println(r + " : " + c);
            for(int[] direction : DIRECTIONS) {
                int nRow = r + direction[0];
                int nCol = c + direction[1];
                if(nRow < grid.length && nRow >= 0 && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    queue.offerFirst(new Pair(nRow, nCol));
                }
            }
        }
        return;
    }

    class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}