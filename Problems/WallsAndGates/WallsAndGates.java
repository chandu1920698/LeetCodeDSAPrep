/*
Class Name  : WallsAndGates
Description : This class consists of the solution for WallsAndGates.
Created Date: Jan 12, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.lintcode.com/problem/663/description

Modification Log: 
Date				    Name                                            Description
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class WallsAndGates
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class Pair
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added wallsAndGates
Jan 12, 2022			Chandra Sekhar Reddy Muthumula					Added helper
--------------------------------------------------------------------------------------------------
663 · Walls and Gates

Description
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a Gate, that room should remain filled with INF

Wechat reply 【Google】 get the latest requent Interview questions. (wechat id : jiuzhang1104)


Example
Example1

Input:
[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output:
[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

Explanation:
the 2D grid is:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
the answer is:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
Example2

Input:
[[0,-1],[2147483647,2147483647]]
Output:
[[0,-1],[1,2]]
-------------------------------------------------------------------------------------------
*/
package Problems.WallsAndGates;

import java.util.*;

public class WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1, 0 },
            new int[] { -1, 0 },
            new int[] { 0, 1 },
            new int[] { 0, -1 });

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0)
            return;
        int n = rooms[0].length;
        Queue<Pair> q = new LinkedList<>();
        // Get all the GATES into the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    q.add(new Pair(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Pair currentPoint = q.poll();
            int i = currentPoint.row;
            int j = currentPoint.column;
            for (int[] direction : DIRECTIONS) {
                int r = i + direction[0];
                int c = j + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[i][j] + 1;
                q.add(new Pair(r, c));
            }
        }
    }

    class Pair {
        int row;
        int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}