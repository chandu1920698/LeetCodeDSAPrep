/*
Class Name  : Shift2DGrid
Description : This class consists of the solution for Shift2DGrid.
Date        : Nov 12, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/shift-2d-grid/description/

Modification Log: 
Date				    Name                                            Description
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class Shift2DGrid 
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class shiftGridBestApproach 
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class reverse
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class shiftGridBetterApproach 
Nov 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class shiftGridWorstApproach 
--------------------------------------------------------------------------------------------------
1260. Shift 2D Grid
Easy
1.5K
314
Companies
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

 

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
Example 2:


Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
-------------------------------------------------------------------------------------------
*/
package Problems.Shift2DGrid;

import java.util.*;
import java.util.stream.Collectors;

public class Shift2DGrid {
    public List<List<Integer>> shiftGridBestApproach(int[][] grid, int k) {
        int R = grid.length;
        int C = grid[0].length;
        int[][] ans = new int[R][C];
        k %= R * C;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[(i + (j + k) / C) % R][(j + k) % C] = grid[i][j];
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int[] row : ans) {
            list.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
            System.out.println(Arrays.toString(row));
        }
        return list;
    }

    public List<List<Integer>> shiftGridBetterApproach(int[][] grid, int k) {
        int R = grid.length;
        int C = grid[0].length;

        k %= R * C;
        // int
        if (k > 0) {
            int[] oneD_array = new int[R * C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    oneD_array[C * i + j] = grid[i][j];
                }
            }

            int start = 0;
            int end = R * C - 1;
            oneD_array = reverse(oneD_array, start, end);

            start = 0;
            end = k - 1;
            oneD_array = reverse(oneD_array, start, end);

            start = k;
            end = R * C - 1;
            oneD_array = reverse(oneD_array, start, end);

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    grid[i][j] = oneD_array[C * i + j];
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();

        for (int[] row : grid) {
            list.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
            System.out.println(Arrays.toString(row));
        }
        return list;
    }

    public int[] reverse(int[] oneD_array, int start, int end) {
        while (start <= end) {
            if (oneD_array[start] != oneD_array[end]) {
                oneD_array[start] ^= oneD_array[end];
                oneD_array[end] ^= oneD_array[start];
                oneD_array[start] ^= oneD_array[end];
            }
            start++;
            end--;
        }
        return oneD_array;
    }

    public List<List<Integer>> shiftGridWorstApproach(int[][] grid, int k) {
        int R = grid.length;
        int C = grid[0].length;

        Stack<Integer> stack = new Stack<>();
        k %= (R * C);
        int count = k;

        if (count > 0) {
            for (int i = R - 1; i >= 0; i--) {
                for (int j = C - 1; j >= 0; j--) {
                    stack.push(grid[i][j]);
                    count--;
                    if (count == 0)
                        break;
                }
                if (count == 0)
                    break;
            }
        }
        int rem_count = R * C - k;
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                if (i != 0 && j == 0) {
                    System.out.println(grid[i][j] + " <-- " + grid[i - 1][C - 1]);
                    grid[i][j] = grid[i - 1][C - 1];
                } else {
                    if (j != 0) {
                        System.out.println(grid[i][j] + " <-- " + grid[i][j - 1]);
                        grid[i][j] = grid[i][j - 1];
                    }
                }
                // rem_count--;
                // if (rem_count == 0) break;
            }
            // if (rem_count == 0) break;
        }
        // for (int[] row : grid) {
        // System.out.println(Arrays.toString(row));
        // }
        // System.out.println("-----------------------");
        if (!stack.isEmpty()) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    grid[i][j] = stack.pop();
                    if (stack.isEmpty())
                        break;
                }
                if (stack.isEmpty())
                    break;
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int[] row : grid) {
            list.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-----------------------");
        return list;
    }
}