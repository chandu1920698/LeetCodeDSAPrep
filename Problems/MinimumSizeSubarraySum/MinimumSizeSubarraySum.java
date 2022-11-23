/*
Class Name  : MinimumSizeSubarraySum
Description : This class consists of the solution for MinimumSizeSubarraySum.
Date        : Nov 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/minimum-size-subarray-sum/description/

Modification Log: 
Date				    Name                                            Description
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinimumSizeSubarraySum
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added minSubArrayLen
--------------------------------------------------------------------------------------------------
209. Minimum Size Subarray Sum
Medium
8.3K
230
Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
-------------------------------------------------------------------------------------------
*/package Problems.MinimumSizeSubarraySum;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        /*
         * This is a two pounter solution
         * TC : O(N)
         * SC : O(1)
        */
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minWindowSize = len + 1;
        while(right < len) {
            if (nums[right] == target) return 1;
            sum += nums[right++];
            if(sum >= target) minWindowSize = Math.min(minWindowSize, right - left);
            while(left < right && sum > target) {
                sum -= nums[left++];
                if(sum >= target) minWindowSize = Math.min(minWindowSize, right - left);
            }
        }
        return minWindowSize == len + 1 ? 0 : minWindowSize;
    }
}