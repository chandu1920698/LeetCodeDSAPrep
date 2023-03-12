/*
Class Name  : UniqueBinarySearhTrees
Description : This class consists of the solution for UniqueBinarySearhTrees.
Created Date: Mar 12, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/unique-binary-search-trees/description/
Modification Log: 
Date					    Name                                            Description
Mar 12, 2022			    Chandra Sekhar Reddy Muthumula					Added Class UniqueBinarySearhTrees
Mar 12, 2022			    Chandra Sekhar Reddy Muthumula					Added numTrees 
--------------------------------------------------------------------------------------------------
96. Unique Binary Search Trees
Medium
8.9K
353
Companies
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19
------------------------------------------------------------------------------------------------------
*/
package Problems.UniqueBinarySearhTrees;

public class UniqueBinarySearhTrees {
    public int numTrees(int n) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= i; j++) {
                int leftBST = dp[j - 1];
                int rightBST = dp[i - j];
                sum += (leftBST * rightBST);
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}