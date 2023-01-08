/*
Class Name  : Subsets
Description : This class consists of the solution for Subsets.
Created Date: Jan 8, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/house-robber/description/

Modification Log: 
Date				Name                                            Description
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class Subsets 
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added subsets 
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added helper 
--------------------------------------------------------------------------------------------------
78. Subsets
Medium
13.2K
187
Companies
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
-------------------------------------------------------------------------------------------
*/
package Problems.Subsets;
import java.util.*;
public class Subsets {
    public static List<List<Integer>> subsetsList;
    public List<List<Integer>> subsets(int[] nums) {
        subsetsList = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return subsetsList;
    }

    private void helper(int[] nums, List<Integer> array, int index) {
        if(index == nums.length){
            subsetsList.add(new ArrayList<Integer>(array));
            return ;
        }
        helper(nums, array, index + 1);
        array.add(nums[index]);
        helper(nums, array, index + 1);
        array.remove(array.size() - 1);
    }
}