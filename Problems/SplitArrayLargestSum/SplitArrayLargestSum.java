/*
Class Name  : SplitArrayLargestSum
Description : This class consists of the solution for SplitArrayLargestSum.
Created Date: Feb 28, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/split-array-largest-sum/description/
Modification Log: 
Date					    Name                                            Description
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added Class SplitArrayLargestSum
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added splitArray 
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added noOfSubArrays 
--------------------------------------------------------------------------------------------------
410. Split Array Largest Sum
Hard
7.7K
171
Companies
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
------------------------------------------------------------------------------------------------------
*/
package Problems.SplitArrayLargestSum;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        /* 
         * TC : O(N) + O(LogN * N)
        */
        int len = nums.length;
        int low;
        int high = 0;
        low = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            high += nums[i];
            low = Math.max(low, nums[i]);
        }
        int ans = low;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            int n = noOfSubArrays(nums, mid);
            if(n > k) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    private int noOfSubArrays(int[] nums, int mid) {
        int sum = 0;
        int countOfSubArrays = 1;
        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > mid) {
                sum = nums[i];
                countOfSubArrays++;
            } else {
                sum += nums[i];
            }
        }
        return countOfSubArrays;
    }
}