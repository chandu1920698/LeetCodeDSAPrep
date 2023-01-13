/*
Class Name  : MaxAreaOfIsland
Description : This class consists of the solution for MaxAreaOfIsland.
Created Date: Jan 13, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/max-area-of-island/description/

Modification Log: 
Date				    Name                                            Description
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class MaxAreaOfIsland
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added maxAreaOfIsland
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added dfs
--------------------------------------------------------------------------------------------------
695. Max Area of Island
Medium
8.5K
187
Companies
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
-------------------------------------------------------------------------------------------
*/
package Problems.MaxAreaOfIsland;

public class MaxAreaOfIsland {
    public static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int area;
    public int maxAreaOfIsland(int[][] grid) {
        area = 0;
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    area = 1;
                    dfs(i, j, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int i, int j, int[][] grid) {

        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            for (int[] direction : DIRECTIONS) {
                int row = i + direction[0];
                int col = j + direction[1];
                if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                    area++;
                    dfs(row, col, grid);
                }
            }
        }
    }
}