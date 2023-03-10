/*
Class Name  : GridGame
Description : This class consists of the solution for GridGame.
Created Date: Mar 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/grid-game/description/
Modification Log: 
Date					    Name                                            Description
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added Class GridGame
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added gridGame 
--------------------------------------------------------------------------------------------------
2017. Grid Game
Medium
637
18
Companies
You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.

Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).

At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.

The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.

 

Example 1:


Input: grid = [[2,5,4],[1,5,1]]
Output: 4
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 0 + 4 + 0 = 4 points.
Example 2:


Input: grid = [[3,3,1],[8,5,2]]
Output: 4
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 3 + 1 + 0 = 4 points.
Example 3:


Input: grid = [[1,3,1,15],[1,3,3,1]]
Output: 7
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 1 + 3 + 3 + 0 = 7 points.
 

Constraints:

grid.length == 2
n == grid[r].length
1 <= n <= 5 * 104
1 <= grid[r][c] <= 105
------------------------------------------------------------------------------------------------------
*/
package Problems.GridGame;

public class GridGame {
    public long gridGame(int[][] grid) {
        /* 
         * TC : O(N)
         * SC : O(2 * N)
        */
        int n = grid[0].length;
        if(n == 1) {
            return 0;
        }
        long[] upper = new long[n + 2];
        long[] lower = new long[n + 2];
        for(int i = 1; i <= n; i++) {
            lower[i] = lower[i - 1] + grid[1][i - 1];
            upper[n - i + 1] = upper[n - i + 2] + grid[0][n - i];
        }
        // System.out.println(Arrays.toString(upper));
        // System.out.println(Arrays.toString(lower));
        long maxValue = Long.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            maxValue = Math.min(Math.max(lower[i - 1], upper[i + 1]), maxValue);
        }
        return maxValue;
    }
}