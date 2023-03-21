/*
Class Name  : Triangle
Description : This class consists of the solution for Triangle.
Created Date: Mar 21, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/triangle/description/
Modification Log: 
Date					    Name                                            Description
Mar 21, 2022			    Chandra Sekhar Reddy Muthumula					Added Class Triangle
Mar 21, 2022			    Chandra Sekhar Reddy Muthumula					Added minimumTotal
--------------------------------------------------------------------------------------------------
120. Triangle
Medium
7.8K
466
Companies
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
------------------------------------------------------------------------------------------------------
*/
package Problems.Triangle;
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int len = triangle.size();
        if (len == 1) {
            return triangle.get(0).get(0);
        }
        int[] dp = new int[len];
        for(int i = 0; i < len; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }
        for (int i = len - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size() ;j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}