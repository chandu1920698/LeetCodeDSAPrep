/*
Class Name  : SingleNumber
Description : This class consists of the solution for SingleNumber.
Date        : Nov 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/single-number/description/

Modification Log: 
Date				Name                                            Description
Nov 5, 2022			Chandra Sekhar Reddy Muthumula					Added Class SingleNumber 
Nov 5, 2022			Chandra Sekhar Reddy Muthumula					Added singleNumber
--------------------------------------------------------------------------------------------------
136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. 
Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
-------------------------------------------------------------------------------------------
*/
package Problems.SingleNumber;

public class SingleNumber {
    /*
     * TC : O(N)
     * SC : O(1)
    */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}