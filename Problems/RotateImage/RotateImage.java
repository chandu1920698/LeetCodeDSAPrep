/*
Class Name  : RotateImage
Description : This class consists of the solution for RotateImage.
Date        : Sep 20, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/rotate-image/

Modification Log: 
Date					Name                                            Description
Sep 20, 2022			Chandra Sekhar Reddy Muthumula					Added Class RotateImage 
Sep 20, 2022			Chandra Sekhar Reddy Muthumula					Added rotate 
--------------------------------------------------------------------------------------------------
48. Rotate Image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
-------------------------------------------------------------------------------------------
*/
class RotateImage {
    public void rotate(int[][] matrix) {
        int order = matrix.length;
		/*
		TC 			: O(N^2)
		SC 			: O(1)
		*/
		
        // Step -1 : Do transpose of the Matrix
        for(int i=0; i<order; i++) {		
            for(int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Step -2 : Now reverse the elements of the rows
        for(int i=0; i<order; i++) {		
            int start = 0;
            int end = order - 1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++; end--;
            }
        }
        
        // for(int i=0;i<order;i++) {		
        //     for(int j=0;j<order;j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //      System.out.println();
        // }
    }
}