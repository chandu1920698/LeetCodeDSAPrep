/*
Class Name  : RottingOranges
Description : This class consists of the solution for RottingOranges.
Created Date: Feb 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/rotting-oranges/description/
Modification Log: 
Date					    Name                                            Description
Feb 18, 2022			    Chandra Sekhar Reddy Muthumula					Added Class RottingOranges 
Feb 18, 2022			    Chandra Sekhar Reddy Muthumula					Added orangesRotting
--------------------------------------------------------------------------------------------------
994. Rotting Oranges
Medium
9.7K
331
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
------------------------------------------------------------------------------------------------------
*/

package Problems.RottingOranges;
import java.util.*;
public class RottingOranges {
    public static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {0, -1}, {1, 0} };
    public int orangesRotting(int[][] grid) {
        // List<Pair> rottenOrangesIndices = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        LinkedList<Pair> queue = new LinkedList<>();
        int nonRottenOranges = 0;
        for(int  i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    nonRottenOranges++;
                }
                if(grid[i][j] == 2) {
                    // visited[i][j] = 1;
                    queue.offerFirst(new Pair(i, j));
                }
            }
        }
        if (nonRottenOranges == 0)
        return 0;
        int level = -1;
        // System.out.println(Arrays.toString(queue.toArray()));
        while(!queue.isEmpty() && queue.size() > 0) {
            int size = queue.size();
            // System.out.println(size);
            // while(size-- > 0) {
            for(int index = 0; index < size; index++) {
                Pair node = queue.pollLast();
                int r = node.first;
                int c = node.second;
                // System.out.println(r + " : " + c);
                for(int[] direction : DIRECTIONS) {
                    int nRow = r + direction[0];
                    int nCol = c + direction[1];
                    if(nRow < grid.length && nRow >= 0 && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1) {
                        // visited[nRow][nCol] = 1;
                        grid[nRow][nCol] = 2;
                        nonRottenOranges--;
                        queue.offerFirst(new Pair(nRow, nCol));
                    }
                }
            }
            level++;
        }
        if(nonRottenOranges > 0) {
            return -1;
        } else {
            return level;
        }
    }
}

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}