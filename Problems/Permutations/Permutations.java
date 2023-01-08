/*
Class Name  : Permutations
Description : This class consists of the solution for Permutations.
Created Date: Jan 8, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/permutations/description/

Modification Log: 
Date				Name                                            Description
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class Permutations
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added permute
Jan 8, 2022			Chandra Sekhar Reddy Muthumula					Added helper 
--------------------------------------------------------------------------------------------------
46. Permutations
Medium
14.2K
240
Companies
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
-------------------------------------------------------------------------------------------
*/
package Problems.Permutations;
import java.util.*;
public class Permutations {
    
    public static List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        boolean[] freq = new boolean[nums.length];
        list = new ArrayList<>();
        helper(nums, new ArrayList<>(), freq);
        return list;
    }
    private void helper(int[] nums, List<Integer> array, boolean[] freq) {
        if(array.size() == nums.length) {
            list.add(new ArrayList<Integer>(array));
            return ;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                array.add(nums[i]);
                helper(nums, array, freq);
                array.remove(array.size() - 1);
                freq[i] = false;
            }
        }
    }
}