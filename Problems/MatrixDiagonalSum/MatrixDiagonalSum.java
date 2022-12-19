/*
Class Name  : MatrixDiagonalSum
Description : This class consists of the solution for MatrixDiagonalSum.
Created Date: Dec 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/matrix-diagonal-sum/submissions/862241056/
Modification Log: 
Date					Name                                            Description
Dec 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class MatrixDiagonalSum 
Dec 19, 2022			Chandra Sekhar Reddy Muthumula					Added diagonalSumOptimized
Dec 19, 2022			Chandra Sekhar Reddy Muthumula					Added diagonalSumBruteForce
--------------------------------------------------------------------------------------------------
1572. Matrix Diagonal Sum
Easy
1.7K
25
Companies
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

 

Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:

Input: mat = [[5]]
Output: 5
 

Constraints:

n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100
------------------------------------------------------------------------------------------------------
*/
package Problems.MatrixDiagonalSum;

public class MatrixDiagonalSum {
    public int diagonalSumOptimized(int[][] mat) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        long sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += (mat[i][i] + mat[i][mat.length - 1 - i]);
        }  
        if (mat.length % 2 == 1) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return (int)sum; 
    }

    public int diagonalSumBruteForce(int[][] mat) {
        /* 
         * TC : O(N ^ 2)
         * SC : O(1)
        */
        long sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == j) {
                    sum += mat[i][j];
                }

                if (j == mat.length - 1 - i) {
                    if (i != j) {
                        sum += mat[i][j];
                    }
                }
            }
        }  
        return (int)sum; 
    }
}