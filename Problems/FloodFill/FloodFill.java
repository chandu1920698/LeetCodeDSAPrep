/*
Class Name  : FloodFill
Description : This class consists of the solution for FloodFill.
Created Date: Feb 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/flood-fill/description/
Modification Log: 
Date					    Name                                            Description
Feb 18, 2022			    Chandra Sekhar Reddy Muthumula					Added Class FloodFill 
Feb 18, 2022			    Chandra Sekhar Reddy Muthumula					Added floodFill
Feb 18, 2022			    Chandra Sekhar Reddy Muthumula					Added dfs
--------------------------------------------------------------------------------------------------
733. Flood Fill
Easy
6.6K
657
Companies
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

 

Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
------------------------------------------------------------------------------------------------------
*/

package Problems.FloodFill;
import java.util.*;
public class FloodFill {
    public static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {0, -1}, {1, 0} };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;
        int[][] newImage = new int[n][m];
        int[][] visited = new int[n][m];
        int oldColor = image[sr][sc];
        for(int  i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                newImage[i][j] = image[i][j];
            }
        }
        
        dfs(sr, sc, newImage, visited, color, oldColor);
        return newImage;
    }

    private void dfs(int row, int col, int[][] grid, int[][] visited, int color, int oldColor) {
        visited[row][col] = 1;
        grid[row][col] = color;
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
                if(nRow < grid.length && nRow >= 0 && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == oldColor && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    grid[nRow][nCol] = color;
                    queue.offerFirst(new Pair(nRow, nCol));
                }
            }
        }
        return;
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