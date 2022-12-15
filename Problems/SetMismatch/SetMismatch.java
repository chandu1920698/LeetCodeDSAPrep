/*
Class Name  : SetMismatch
Description : This class consists of the solution for SetMismatch.
Craeted Date: Dec 15, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/set-mismatch/description/

Modification Log: 
Date					Name                                            Description
Dec 15, 2022			Chandra Sekhar Reddy Muthumula					Added Class SetMismatch 
Dec 15, 2022			Chandra Sekhar Reddy Muthumula					Added findErrorNums
Dec 15, 2022			Chandra Sekhar Reddy Muthumula					Added findDuplicates
--------------------------------------------------------------------------------------------------
645. Set Mismatch
Easy
3.4K
781
Companies
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
-------------------------------------------------------------------------------------------
*/
package Problems.SetMismatch;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}