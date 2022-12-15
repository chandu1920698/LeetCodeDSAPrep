/*
Class Name  : FindAllDuplicatesInArray
Description : This class consists of the solution for FindAllDuplicatesInArray.
Craeted Date: Dec 15, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

Modification Log: 
Date					Name                                            Description
Dec 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindAllDuplicatesInArray 
Dec 15, 2022			Chandra Sekhar Reddy Muthumula					Added findDuplicatesCyclicSort
Dec 15, 2022			Chandra Sekhar Reddy Muthumula					Added findDuplicates
--------------------------------------------------------------------------------------------------
442. Find All Duplicates in an Array
Medium
7.8K
296
Companies
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.
-------------------------------------------------------------------------------------------
*/
package Problems.FindAllDuplicatesInArray;

import java.util.*;

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicatesCyclicSort(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int correct = nums[i] - 1;
            while (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
                correct = nums[i] - 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (i + 1 != nums[i]) {
                ansList.add(nums[i]);
            }
        }
        return ansList;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                ansList.add(index + 1);
            nums[index] = -nums[index];
        }
        return ansList;
    }
}