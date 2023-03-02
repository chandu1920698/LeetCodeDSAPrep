/*
Class Name  : SetMatrixZeroes
Description : This class consists of the solution for SetMatrixZeroes.
Created Date: Mar 3, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/set-matrix-zeroes/description/
Modification Log: 
Date					    Name                                            Description
Mar  3, 2022			    Chandra Sekhar Reddy Muthumula					Added Class SetMatrixZeroes
Mar  3, 2022			    Chandra Sekhar Reddy Muthumula					Added setZeroesBestApproach
Mar  3, 2022			    Chandra Sekhar Reddy Muthumula					Added setZeroesApproach2
Mar  3, 2022			    Chandra Sekhar Reddy Muthumula					Added setZeroesApproach3
--------------------------------------------------------------------------------------------------
73. Set Matrix Zeroes
Medium
10.7K
602
Companies
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
------------------------------------------------------------------------------------------------------
*/
package Problems.SetMatrixZeroes;
import java.util.*;
public class SetMatrixZeroes {
    public void setZeroesBestApproach(int[][] matrix) {
        /* 
         * TC : O(N * M)
         * SC : O(N + M)
        */
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 1;
        int col = 1;
        for(int i = 0; i < m; i++) {
            if(matrix[0][i] == 0) {
                row = 0;
            }
        }
        for(int i = 0; i < n; i++) {
            if(matrix[i][0] == 0) {
                col = 0;
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for(int i = 1; i < n; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(row == 0) {
            for(int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if(col == 0) {
            for(int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }

    public void setZeroesApproach2(int[][] matrix) {
        /* 
         * TC : O(N * M)
        */
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(int index : rowSet) {
            for(int x = 0; x < m; x++) {
                matrix[index][x] = 0;
            }
        }
        for(int index : colSet) {
            for(int y = 0; y < n; y++) {
                matrix[y][index] = 0;
            }
        }

        return;
    }

    public void setZeroesApproach3(int[][] matrix) {
        /* 
         * TC : O(N * M)
         * SC : O(N * M)
        */
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] copyMatrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    for(int x = 0; x < m; x++) {
                        copyMatrix[i][x] = 0;
                    }
                    for(int y = 0; y < n; y++) {
                        copyMatrix[y][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = copyMatrix[i][j];
            }
        }

        return;
    }
}