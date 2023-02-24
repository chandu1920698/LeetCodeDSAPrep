/*
Class Name  : PacificAtlanticWaterFlow
Description : This class consists of the solution for PacificAtlanticWaterFlow.
Created Date: Feb 24, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/pacific-atlantic-water-flow/description/
Modification Log: 
Date					    Name                                            Description
Feb 24, 2022			    Chandra Sekhar Reddy Muthumula					Added Class PacificAtlanticWaterFlow 
Feb 24, 2022			    Chandra Sekhar Reddy Muthumula					Added pacificAtlantic
Feb 24, 2022			    Chandra Sekhar Reddy Muthumula					Added fillOcean
--------------------------------------------------------------------------------------------------
417. Pacific Atlantic Water Flow
Medium
6.1K
1.2K
Companies
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

 

Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 

Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105
------------------------------------------------------------------------------------------------------
*/

package Problems.PacificAtlanticWaterFlow;

import java.util.*;

public class PacificAtlanticWaterFlow {
    List<List<Integer>> result;
    int[][] pacificGrid;
    int[][] atlanticGrid;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        pacificGrid = new int[n][m];
        atlanticGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            fillOcean(i, 0, heights, pacificGrid, Integer.MIN_VALUE);
            fillOcean(i, m - 1, heights, atlanticGrid, Integer.MIN_VALUE);
        }
        for (int j = 0; j < m; j++) {
            fillOcean(0, j, heights, pacificGrid, Integer.MIN_VALUE);
            fillOcean(n - 1, j, heights, atlanticGrid, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacificGrid[i][j] == 1 && atlanticGrid[i][j] == 1) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private void fillOcean(int i, int j, int[][] heights, int[][] ocean, int prev) {
        if (i >= heights.length || i < 0 || j >= heights[0].length || j < 0 || ocean[i][j] == 1
                || heights[i][j] < prev) {
            return;
        }
        ocean[i][j] = 1;
        fillOcean(i - 1, j, heights, ocean, heights[i][j]);
        fillOcean(i + 1, j, heights, ocean, heights[i][j]);
        fillOcean(i, j - 1, heights, ocean, heights[i][j]);
        fillOcean(i, j + 1, heights, ocean, heights[i][j]);
        return;
    }
}