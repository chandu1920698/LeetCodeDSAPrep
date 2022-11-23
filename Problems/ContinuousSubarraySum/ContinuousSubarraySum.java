/*
Class Name  : ContinuousSubarraySum
Description : This class consists of the solution for ContinuousSubarraySum.
Date        : Nov 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/continuous-subarray-sum/description/

Modification Log: 
Date				    Name                                            Description
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class ContinuousSubarraySum
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added checkSubarraySumBruteForceMethod
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added checkSubarraySumBestApproach
--------------------------------------------------------------------------------------------------
523. Continuous Subarray Sum
Medium
4.2K
410
Companies
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= sum(nums[i]) <= 231 - 1
1 <= k <= 231 - 1
-------------------------------------------------------------------------------------------
*/
package Problems.ContinuousSubarraySum;
import java.util.*;
public class ContinuousSubarraySum {
    public boolean checkSubarraySumBruteForceMethod(int[] nums, int k) {
        /*
         * This is a Brute Force Method
         * TC : O(N ^ 2)
         * Sc : O(1)
        */
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    if(j - i >= 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySumBestApproach(int[] nums, int k) {
        /*
         * TC : O(N)
         * SC : O(1)
        */
        int len = nums.length;
        HashMap<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (!remainderIndexMap.containsKey(remainder)) {
                remainderIndexMap.put(remainder, i);
            } else if(i - remainderIndexMap.get(remainder) > 1) {
                return true;
            }
        }
        return false;
    }
}