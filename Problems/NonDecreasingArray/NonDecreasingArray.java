/*
Class Name  : NonDecreasingArray
Description : This class consists of the solution for NonDecreasingArray.
Date        : Oct 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/non-decreasing-array/submissions/

Modification Log: 
Date					Name                                            Description
Oct 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class NonDecreasingArray 
Oct 23 2022			Chandra Sekhar Reddy Muthumula					Added checkPossibility
--------------------------------------------------------------------------------------------------
665. Non-decreasing Array

Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).


Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You cannot get a non-decreasing array by modifying at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
-------------------------------------------------------------------------------------------
*/
package Problems.NonDecreasingArray;

public class NonDecreasingArray {
    public static void main(String[] args) {
        checkPossibility(new int[] {12,2});
    }
    public static boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        boolean changed = false;
        for (int i = 0; i + 1 < len; i++) {
            if(nums[i] <= nums[i + 1]) {
                continue;
            } else if(changed) {
                return false;
            } else {
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
                changed = true;
            }
        }
        
        return true;
    }
}
