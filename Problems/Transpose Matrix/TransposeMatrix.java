/*
Class Name  : TransposeMatrix
Description : This class consists of the solution for TransposeMatrix.
Date        : Sep 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/transpose-matrix/

Modification Log: 
Date					Name                                            Description
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class TransposeMatrix 
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added transpose 
--------------------------------------------------------------------------------------------------
867. Transpose Matrix

Given a 2D integer array matrix, return the transpose of matrix.
The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:
Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109
*/

class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
		/*
		TC 			: O(N^2)
		SC 			: O(N)
		Recommended : YES
		*/
        int[][] matrixT = new int[n][m];
        if (m <= 1000 && 1 <= m && n <= 1000 && 1 <= n && m*n <= 100000 && 1 <= m*n) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    matrixT[i][j] = matrix[j][i];
                }
            }
        }
        return matrixT;
    }
}