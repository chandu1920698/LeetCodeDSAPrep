/*
Class Name  : 4Sum
Description : This class consists of the solution for 4Sum.
Date        : Sep 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/3sum/

Modification Log: 
Date					Name                                            Description
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class 4Sum 
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added fourSum 
--------------------------------------------------------------------------------------------------
18. 4Sum

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:

1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
-------------------------------------------------------------------------------------------
*/

class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        int left1 = 0;
        while (left1 < len - 3) {
            int left2 = left1 + 1;
            long target1 = target - (long)nums[left1];
            while (left2 < len - 2) {
                int start = left2 + 1;
                int end = len - 1;
                long target2 = target1 - (long)nums[left2];
                while (start < end) {
                    // long sum = nums[left1] + nums[left2] + nums[start] +nums[end];
                    long sum = nums[start] +nums[end];
                    // System.out.println("Sum : " + sum + " target : " + target);
                    if (sum == target2) {
                        result.add(Arrays.asList(nums[left1], nums[left2], nums[start], nums[end]));
                        while(--end > start && nums[end] == nums[end+1]);
                        while(++start < end && nums[start] == nums[start-1]);
                    } else  {
                        if (sum > target2) {
                            while(--end > start && nums[end] == nums[end+1]);
                        } else  {
                            while(++start < end && nums[start] == nums[start-1]);
                        }
                    } 
                }
                while(++left2 < len-2 && nums[left2] == nums[left2-1]);
            }
            while(++left1 < len-3  && nums[left1] == nums[left1-1]);
        }
        return result;
    }
}