/*
Class Name  : SpiralMatrix
Description : This class consists of the solution for SpiralMatrix.
Date        : Oct 3, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/spiral-matrix/
Modification Log: 
Date			    Name                                        Description
Oct 3, 2022			Chandra Sekhar Reddy Muthumula					Added Class SpiralMatrix 
Oct 3, 2022			Chandra Sekhar Reddy Muthumula					Added spiralOrder 
--------------------------------------------------------------------------------------------------
54. Spiral Matrix

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
------------------------------------------------------------------------------------------------------
*/
package Problems.SpiralMatrix;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        // System.out.println("rowStart : " + rowStart);
        // System.out.println("rowEnd : " + rowEnd);
        // System.out.println("colStart : " + colStart);
        // System.out.println("colEnd : " + colEnd);
        List<Integer> result = new ArrayList<Integer>();
        while(rowStart <= rowEnd && colStart <= colEnd) {
            
            for (int i=colStart; i<=colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }rowStart++;
            // System.out.println("result : " + Arrays.asList(result));
            for (int i=rowStart; i<=rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }colEnd--;
            // System.out.println("result : " + Arrays.asList(result));
            if (rowStart > rowEnd || colStart > colEnd) {
                break;
            }
            // System.out.println("result : " + Arrays.asList(result));
            for (int i=colEnd; i>=colStart; i--) {
                result.add(matrix[rowEnd][i]);
            }rowEnd--;
            // System.out.println("result : " + Arrays.asList(result));
            for (int j = rowEnd; j >= rowStart; j--) {
                result.add(matrix[j][colStart]);
            }colStart++;
            // System.out.println("result : " + Arrays.asList(result));
        }
        return result;

    }
}