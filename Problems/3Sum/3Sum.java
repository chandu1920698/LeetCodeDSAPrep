/*
Class Name  : 3Sum
Description : This class consists of the solution for 3Sum.
Date        : Sep 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/3sum/

Modification Log: 
Date					Name                                            Description
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class 3Sum 
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added threeSum 
--------------------------------------------------------------------------------------------------
15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
-------------------------------------------------------------------------------------------
*/

class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (len < 3) return result;
        Arrays.sort(nums);
        int left = 0;
        while(left < len) {
            int start = left + 1;
            int end = len - 1;
            while (start < end) {
                long sum = nums[left] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[start], nums[end]));
                    while(--end > start && nums[end] == nums[end+1]);
                    while(++start < end && nums[start] == nums[start-1]);
                } else {
                    if (sum > 0) {
                        while(--end > start && nums[end] == nums[end+1]);
                    } else {
                        while(++start < end && nums[start] == nums[start-1]);
                    }
                }
            } 
            while(++left < len-1 && nums[left] == nums[left-1]);
        }
        // while(left < len - 2) {
        //     int middle = left + 1;
        //     int right = len - 1;
        //     while (middle < right) {
        //         long sum = nums[left] + nums[middle] + nums[right];
        //         if (sum == 0) {
        //             result.add(Arrays.asList(nums[left], nums[middle], nums[right]));
        //         } 
        //         if (sum <= 0) {
        //             while (nums[middle] == nums[++middle] && middle < right){}
        //         } 
        //         if (sum >= 0) {
        //             while (nums[right] == nums[--right] && middle < right) {}
        //         }
        //     }
        //     while(nums[left] == nums[++left] && left < len - 2){}
        // }
        
        return result;
    }
}