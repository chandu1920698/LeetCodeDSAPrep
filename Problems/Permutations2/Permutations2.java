/*
Class Name  : Permutations2
Description : This class consists of the solution for Permutations2.
Created Date: Jan 8, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/permutations-ii/description/

Modification Log: 
Date				Name                                            Description
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class Permutations2
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added permuteUnique
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added helper 
--------------------------------------------------------------------------------------------------
47. Permutations II
Medium
6.9K
125
Companies
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
-------------------------------------------------------------------------------------------
*/
package Problems.Permutations2;

import java.util.*;

public class Permutations2 {

    public static List<List<Integer>> list;

    public List<List<Integer>> permuteUnique(int[] nums) {
        /* 
         * TC : O(N! * N)
         * SC : O(N)
        */
        boolean[] freq = new boolean[nums.length];
        list = new ArrayList<>();
        helper(nums, new ArrayList<>(), freq);
        return list;
    }

    private void helper(int[] nums, List<Integer> array, boolean[] freq) {
        if (array.size() == nums.length) {
            if (!list.contains(array)) {
                list.add(new ArrayList<Integer>(array));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                array.add(nums[i]);
                helper(nums, array, freq);
                array.remove(array.size() - 1);
                freq[i] = false;
            }
        }
    }
}