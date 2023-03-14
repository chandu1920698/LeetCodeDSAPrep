/*
Class Name  : ConcatenationOfArray
Description : This class consists of the solution for ConcatenationOfArray.
Created Date: Mar 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/concatenation-of-array/description/
Modification Log: 
Date					    Name                                            Description
Mar 14, 2022			    Chandra Sekhar Reddy Muthumula					Added Class ConcatenationOfArray
Mar 14, 2022			    Chandra Sekhar Reddy Muthumula					Added numTrees 
--------------------------------------------------------------------------------------------------
1929. Concatenation of Array
Easy
2.1K
280
Companies
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

 

Example 1:

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]
Example 2:

Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
- ans = [1,3,2,1,1,3,2,1]
 

Constraints:

n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000
------------------------------------------------------------------------------------------------------
*/
package Problems.ConcatenationOfArray;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int n = nums.length;
        int[] result = new int[2 * n];
        for(int i = 0; i < n; i++) {
            result[i] = nums[i];
            result[n + i] = nums[i];
        }
        return result;
    }
}