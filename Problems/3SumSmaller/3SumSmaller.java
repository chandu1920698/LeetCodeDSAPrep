/*
Class Name  : 3SumSmaller
Description : This class consists of the solution for 3SumSmaller.
Date        : Sep 24, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.lintcode.com/problem/918/description

Modification Log: 
Date					Name                                            Description
Sep 24, 2022			Chandra Sekhar Reddy Muthumula					Added Class 3SumSmaller 
Sep 24, 2022			Chandra Sekhar Reddy Muthumula					Added threeSumSmaller 
--------------------------------------------------------------------------------------------------
16. 3Sum Closest
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
 
Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
-------------------------------------------------------------------------------------------
*/

public class 3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        int left = 0;
        while (left < len) {
            int middle = left + 1;
            int right = len - 1;
            while (middle < right) {
                long sum = nums[left] + nums[middle] + nums[right];
                if (sum < target) {
                    count += (right-middle);
                    middle++;
                } else {
                    right--;
                }
            }
            left++;
        }
        return count;
    }
}