/*
Class Name  : GridIllumination
Description : This class consists of the solution for GridIllumination.
Created Date: Jan 16, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/grid-illumination/description/

Modification Log: 
Date				    Name                                            Description
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added Class GridIllumination
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added gridIllumination
--------------------------------------------------------------------------------------------------
1001. Grid Illumination
Hard
516
128
Companies
There is a 2D grid of size n x n where each cell of this grid has a lamp that is initially turned off.

You are given a 2D array of lamp positions lamps, 
where lamps[i] = [rowi, coli] indicates that the lamp at grid[rowi][coli] is turned on. 
Even if the same lamp is listed more than once, it is turned on.

When a lamp is turned on, it illuminates its cell and all other cells in the same row, column, or diagonal.

You are also given another 2D array queries, where queries[j] = [rowj, colj]. 
For the jth query, determine whether grid[rowj][colj] is illuminated or not. 
After answering the jth query, turn off the lamp at grid[rowj][colj] and its 8 adjacent lamps if they exist. 
A lamp is adjacent if its cell shares either a side or corner with grid[rowj][colj].

Return an array of integers ans, where ans[j] should be 1 if the cell in the jth query was illuminated, 
or 0 if the lamp was not.

 

Example 1:


Input: n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
Output: [1,0]
Explanation: We have the initial grid with all lamps turned off. 
In the above picture we see the grid after turning on the lamp at grid[0][0] then turning on the lamp at grid[4][4].
The 0th query asks if the lamp at grid[1][1] is illuminated or not (the blue square). 
It is illuminated, so set ans[0] = 1. Then, we turn off all lamps in the red square.

The 1st query asks if the lamp at grid[1][0] is illuminated or not (the blue square). 
It is not illuminated, so set ans[1] = 0. Then, we turn off all lamps in the red rectangle.

Example 2:

Input: n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
Output: [1,1]
Example 3:

Input: n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
Output: [1,1,0]
 

Constraints:

1 <= n <= 109
0 <= lamps.length <= 20000
0 <= queries.length <= 20000
lamps[i].length == 2
0 <= rowi, coli < n
queries[j].length == 2
0 <= rowj, colj < n
-------------------------------------------------------------------------------------------
*/

package Problems.GridIllumination;

import java.util.*;

public class GridIllumination {
    public static final int[][] DIRECTIONS = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 },
            { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        /*
         * TC : O(N + M * 9)
         * SC : O(N ^ 2)
         */
        Map<Integer, Integer> rowLightFreq = new HashMap<>();
        Map<Integer, Integer> colLightFreq = new HashMap<>();
        Map<Integer, Integer> diag1LightFreq = new HashMap<>();
        Map<Integer, Integer> diag2LightFreq = new HashMap<>();
        Map<Integer, Boolean> cellLightFreq = new HashMap<>();
        for (int[] lamp : lamps) {
            int row = lamp[0], col = lamp[1];
            if (cellLightFreq.containsKey(row * n + col) == false) {
                cellLightFreq.put(row * n + col, true);
                rowLightFreq.put(row, rowLightFreq.getOrDefault(row, 0) + 1);
                colLightFreq.put(col, colLightFreq.getOrDefault(col, 0) + 1);
                diag1LightFreq.put(row + col, diag1LightFreq.getOrDefault(row + col, 0) + 1);
                diag2LightFreq.put(row - col + n - 1, diag2LightFreq.getOrDefault(row - col + n - 1, 0) + 1);
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int row = query[0], col = query[1];
            result[i] = (rowLightFreq.getOrDefault(row, 0) > 0 || colLightFreq.getOrDefault(col, 0) > 0
                    || diag1LightFreq.getOrDefault(row + col, 0) > 0
                    || diag2LightFreq.getOrDefault(row - col + n - 1, 0) > 0) ? 1 : 0;

            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0], c = col + direction[1];
                if (r < n && r >= 0 && c < n && c >= 0) {
                    if (cellLightFreq.containsKey(r * n + c) && cellLightFreq.get(r * n + c) == true) {
                        cellLightFreq.put(r * n + c, false);
                        rowLightFreq.put(r, rowLightFreq.getOrDefault(r, 1) - 1);
                        colLightFreq.put(c, colLightFreq.getOrDefault(c, 1) - 1);
                        diag1LightFreq.put(r + c, diag1LightFreq.getOrDefault(r + c, 1) - 1);
                        diag2LightFreq.put(r - c + n - 1, diag2LightFreq.getOrDefault(r - c + n - 1, 1) - 1);
                    }
                }
            }
        }
        return result;
    }
}
