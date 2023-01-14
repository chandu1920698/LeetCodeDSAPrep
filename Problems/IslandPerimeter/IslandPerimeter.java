/*
Class Name  : IslandPerimeter
Description : This class consists of the solution for IslandPerimeter.
Created Date: Jan 14, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/island-perimeter/description/

Modification Log: 
Date				    Name                                            Description
Jan 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class IslandPerimeter
Jan 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class Pair
Jan 14, 2022			Chandra Sekhar Reddy Muthumula					Added islandPerimeterBestApproach
Jan 14, 2022			Chandra Sekhar Reddy Muthumula					Added islandPerimeter
Jan 14, 2022			Chandra Sekhar Reddy Muthumula					Added dfs
--------------------------------------------------------------------------------------------------
463. Island Perimeter
Easy
5.3K
262
Companies
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4
 

Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.
-------------------------------------------------------------------------------------------
*/
package Problems.IslandPerimeter;
import java.util.*;
public class IslandPerimeter {
    

    public int islandPerimeterBestApproach(int[][] grid) {
        /* 
         * TC : O(N * M)
         * SC : O(1)
        */
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    perimeter += 4;
                    if(i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if(j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
         
        return perimeter;
    }

    public static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Pair> set = new HashSet<Pair>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    dfs(i, j, grid, set);
                }
            }
        }
        int perimeter = 0;
        for (Pair pair : set) {
            for (int[] direction : DIRECTIONS) {
                int row = pair.r + direction[0];
                int col = pair.c + direction[1];
                if ((row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) || (grid[row][col] == 0) ){
                    perimeter++;
                }
            }
        }
        
        return perimeter;
    }

    private void dfs(int i, int j, int[][] grid, Set<Pair> set) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            set.add(new Pair(i, j));
            for (int[] direction :  DIRECTIONS) {
                int row = i + direction[0];
                int col = j + direction[1];

                if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                    dfs(row, col, grid, set);
                }
            }
            grid[i][j] = 1;
        }
    }
}

class Pair {
    int r;
    int c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}