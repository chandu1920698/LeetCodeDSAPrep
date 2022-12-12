/*
Class Name  : CountNegativeNumbersInSortedMatrix
Description : This class consists of the solution for CountNegativeNumbersInSortedMatrix.
Created Date: Dec 12, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

Modification Log: 
Date					Name                                            Description
Dec 12, 2022			Chandra Sekhar Reddy Muthumula					Added Class CountNegativeNumbersInSortedMatrix 
Dec 12, 2022			Chandra Sekhar Reddy Muthumula					Added countNegatives
--------------------------------------------------------------------------------------------------
1470. Shuffle the Array
Easy
3.2K
210
Companies
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

 

Example 1:

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7] 
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
Example 2:

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
Example 3:

Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]
 

Constraints:

1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3
-------------------------------------------------------------------------------------------
*/
package Problems.CountNegativeNumbersInSortedMatrix;

public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        /* 
         * BEST TC : O(N)
         * WORST TC : O(N ^2)
         * SC : O(1)
        */
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0){
                    count += (grid[0].length - j);
                    break;
                }
            }
        }
        return count;
    }
}