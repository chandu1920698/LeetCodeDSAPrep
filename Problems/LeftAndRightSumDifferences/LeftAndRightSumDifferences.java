/*
Class Name  : LeftAndRightSumDifferences
Description : This class consists of the solution for LeftAndRightSumDifferences.
Created Date: Feb 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/left-and-right-sum-differences/
Modification Log: 
Date					    Name                                            Description
Feb 26, 2022			    Chandra Sekhar Reddy Muthumula					Added Class LeftAndRightSumDifferences 
Feb 26, 2022			    Chandra Sekhar Reddy Muthumula					Added leftRigthDifference
--------------------------------------------------------------------------------------------------
Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:

answer.length == nums.length.
answer[i] = |leftSum[i] - rightSum[i]|.
Where:

leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
Return the array answer.

 

Example 1:

Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
Example 2:

Input: nums = [1]
Output: [0]
Explanation: The array leftSum is [0] and the array rightSum is [0].
The array answer is [|0 - 0|] = [0].
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 105
------------------------------------------------------------------------------------------------------
*/
package Problems.LeftAndRightSumDifferences;
public class LeftAndRightSumDifferences {
    public int[] leftRigthDifference(int[] nums) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int n = nums.length;
        if(n == 1) {
            return new int[] {0};
        }
        
        int prefixSum = 0;
        int suffixSum = 0;
        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            suffixSum += nums[n - 1 - i];
            result[n - 1 - i] = Math.abs(prefixSum - suffixSum);
            prefixSum -= nums[n - 1 - i];
            
        }
        return result;
    }
}