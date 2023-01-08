/*
Class Name  : CombinationSum
Description : This class consists of the solution for CombinationSum.
Created Date: Jan 8, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/combination-sum/description/

Modification Log: 
Date				Name                                            Description
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class CombinationSum 
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added combinationSum 
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added helper 
--------------------------------------------------------------------------------------------------
39. Combination Sum
Medium
14.6K
291
Companies
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
-------------------------------------------------------------------------------------------
*/
package Problems.CombinationSum;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        // Sort the candidates array to get the combinantions in increasing order by
        // default
        Arrays.sort(candidates);
        helper(candidates, combinations, new ArrayList<Integer>(), 0, target, 0);
        return combinations;
    }

    private void helper(int[] candidates, List<List<Integer>> combinations, List<Integer> array, int currentSum,
            int target, int start) {
        if (currentSum == target) {
            combinations.add(new ArrayList<Integer>(array));
            return;
        }

        if (currentSum < target) {
            for (int i = start; i < candidates.length; i++) {
                array.add(candidates[i]);
                helper(candidates, combinations, array, currentSum + candidates[i], target, i);
                array.remove(array.size() - 1);
            }
        } else if (currentSum > target) {
            return;
        }
    }
}