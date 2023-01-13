/*
Class Name  : NumberOfDistinctIslands
Description : This class consists of the solution for NumberOfDistinctIslands.
Created Date: Jan 13, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.lintcode.com/problem/860/

Modification Log: 
Date				    Name                                            Description
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class NumberOfDistinctIslands
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added numberofDistinctIslands
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added dfs
--------------------------------------------------------------------------------------------------
860 · Number of Distinct Islands

Description
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island has the same shape as another island (and not rotated or reflected).

Notice that:

11
1
and

 1
11
are considered different island, because we do not consider reflection / rotation.

Wechat reply 【Google】 get the latest requent Interview questions. (wechat id : jiuzhang1104)


The length of each dimension in the given grid does not exceed 50.

Example
Example 1:

Input: 
  [
    [1,1,0,0,1],
    [1,0,0,0,0],
    [1,1,0,0,1],
    [0,1,0,1,1]
  ]
Output: 3
Explanation:
  11   1    1
  1        11   
  11
   1
Example 2:

Input:
  [
    [1,1,0,0,0],
    [1,1,0,0,0],
    [0,0,0,1,1],
    [0,0,0,1,1]
  ]
Output: 1
-------------------------------------------------------------------------------------------
*/
package Problems.NumberOfDistinctIslands;

import java.util.*;

public class NumberOfDistinctIslands {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int numberofDistinctIslands(int[][] grid) {
        /* 
         * TC : O(N * M + Log(N * M) + N * M * 4)
         * SC : O(N * M)
        */
        int n = grid.length;
        int m = grid[0].length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    dfs(i, j, grid, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private void dfs(int i, int j, int[][] grid, List<Integer> list, int row0, int col0) {

        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            list.add(i - row0);
            list.add(j - col0);
            for (int[] direction : DIRECTIONS) {
                int row = i + direction[0];
                int col = j + direction[1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                    dfs(row, col, grid, list, row0, col0);
                }
            }
        }
    }
}