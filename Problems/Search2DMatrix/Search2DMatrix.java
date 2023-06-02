/*
Class Name  : Search2DMatrix
Description : This class consists of the solution for Search2DMatrix.
Date        : Oct 3, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/search-a-2d-matrix/
Modification Log: 
Date				Name                                            Description
Oct 3, 2022			Chandra Sekhar Reddy Muthumula					Added Class Search2DMatrix 
Oct 3, 2022			Chandra Sekhar Reddy Muthumula					Added searchMatrix 
Jun 2, 2023			Chandra Sekhar Reddy Muthumula					Added searchMatrixEfficient 
Jun 2, 2023			Chandra Sekhar Reddy Muthumula					Added getRowIndex 
Jun 2, 2023			Chandra Sekhar Reddy Muthumula					Added binarySearch 
--------------------------------------------------------------------------------------------------
74. Search a 2D Matrix
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
------------------------------------------------------------------------------------------------------
*/
package Problems.Search2DMatrix;

public class Search2DMatrix {

    public boolean searchMatrixEfficient(int[][] matrix, int target) {
        /* 
         * TC : O(M + Log N)
         * SC : O(1)
        */
        int searchRowIndex = getRowIndex(matrix, target);
        if(searchRowIndex == -2) {
            return true;
        } else if(searchRowIndex == -1) {
            return false;
        }

        return binarySearch(matrix[searchRowIndex], target);

    }

    public int getRowIndex(int[][] matrix, int target) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        for(int row = 0; row < matrix.length; row++) {
            if(matrix[row][matrix[row].length - 1] == target) {
                return -2;
            } else if(matrix[row][matrix[row].length - 1] > target) {
                return row;
            }
        }
        return -1;
    }

    public boolean binarySearch(int[] arr, int target) {
        /* 
         * TC : O(Log N)
         * SC : O(1)
        */
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i=0; i<rows; i++) {
            int[] array = matrix[i];
            int start = 0;
            int end = cols - 1;
            while(start <= end) {
                int mid = start + ((end - start) >> 1);
                if(array[mid] == target ) {
                    return true;
                } else if (array[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}