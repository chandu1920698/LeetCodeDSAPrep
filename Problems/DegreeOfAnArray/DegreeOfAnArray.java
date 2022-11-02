/*
Class Name  : DegreeOfAnArray
Description : This class consists of the solution for DegreeOfAnArray.
Date        : Nov 2, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/degree-of-an-array/

Modification Log: 
Date				Name                                            Description
Nov 2, 2022			Chandra Sekhar Reddy Muthumula					Added Class DegreeOfAnArray 
Nov 2, 2022			Chandra Sekhar Reddy Muthumula					Added findShortestSubArray
--------------------------------------------------------------------------------------------------
697. Degree of an Array

Given a non-empty array of non-negative integers nums, 
the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 

Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
-------------------------------------------------------------------------------------------
*/
package Problems.DegreeOfAnArray;

import java.util.*;

public class DegreeOfAnArray {

    public static void main(String[] args) {

    }

    public int findShortestSubArray(int[] nums) {
        /*
         * TC : O(N)
         * SC : O(2 * N)
         */

        HashMap<Integer, Integer> num_freq = new HashMap<Integer, Integer>();
        int degree = 0;

        HashMap<Integer, Integer> first_seen = new HashMap<Integer, Integer>();
        int min_length = 0;

        int nums_len = nums.length;

        for (int i = 0; i < nums_len; i++) {
            first_seen.putIfAbsent(nums[i], i);

            num_freq.put(nums[i], num_freq.getOrDefault(nums[i], 0) + 1);

            if (num_freq.get(nums[i]) > degree) {
                degree = num_freq.get(nums[i]);
                min_length = i - first_seen.get(nums[i]) + 1;
            } else if (num_freq.get(nums[i]) == degree) {
                min_length = Math.min(min_length, i - first_seen.get(nums[i]) + 1);
            }
        }
        return min_length;
    }
}