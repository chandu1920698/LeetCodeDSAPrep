/*
Class Name  : Subsets2
Description : This class consists of the solution for Subsets2.
Created Date: Jan 13, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/subsets-ii/description/

Modification Log: 
Date				    Name                                            Description
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class Subsets2
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added subsetsWithDup
Jan 13, 2022			Chandra Sekhar Reddy Muthumula					Added subsets
--------------------------------------------------------------------------------------------------
90. Subsets II
Medium
7.3K
206
Companies
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
-------------------------------------------------------------------------------------------
*/
package Problems.Subsets2;

import java.util.*;;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // sorting
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        result.add(new ArrayList<>());
        subsets(0, nums, numList, result, true);
        return result;
    }

    private void subsets(int offset, int[] nums, List<Integer> numList, List<List<Integer>> result, boolean isPicked) {
        // base case
        if (offset >= nums.length) {
            return;
        }
        int val = nums[offset];
        // duplicate checking (convert && to ||)
        if (offset == 0 || nums[offset - 1] != nums[offset] || isPicked == true) {
            // pick
            numList.add(val);
            subsets(offset + 1, nums, numList, result, true);
            result.add(new ArrayList<>(numList)); // add to the result list
            numList.remove(numList.size() - 1);
        }
        // not pick
        subsets(offset + 1, nums, numList, result, false);
    }
}