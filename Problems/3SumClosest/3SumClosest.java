/*
Class Name  : 3SumClosest
Description : This class consists of the solution for 3SumClosest.
Date        : Sep 24, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/3sum-closest/

Modification Log: 
Date					Name                                            Description
Sep 24, 2022			Chandra Sekhar Reddy Muthumula					Added Class 3SumClosest 
Sep 24, 2022			Chandra Sekhar Reddy Muthumula					Added threeSumClosest 
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

class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        long diff = Integer.MAX_VALUE;
        long result = target;
        int left = 0;
        while(left < len) {
            int start = left+1;
            int end = len -1;
            long target1 = (long) target - nums[left];
            while(start < end) {
                long sum = nums[start] + nums[end];
                if (sum == target1) {
                    return target;
                } else {
                    if (sum < target1) {
                        if (diff > Math.abs(sum-target1)) {
                            diff = Math.abs(sum-target1);
                            result = sum + nums[left];
                        }
                        while(++start < end && nums[start] == nums[start-1]);
                    }else if (sum > target1) {
                        if (diff > Math.abs(sum-target1)) {
                            diff = Math.abs(sum-target1);
                            result = sum + nums[left];
                        }
                        while(--end > start && nums[end] == nums[end+1]);
                    }
                }
            }
            while(++left < len && nums[left] == nums[left-1]);
        }
        return (int)result;
    }
}