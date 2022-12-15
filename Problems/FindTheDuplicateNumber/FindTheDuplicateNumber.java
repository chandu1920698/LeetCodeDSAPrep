/*
Class Name  : FindTheDuplicateNumber
Description : This class consists of the solution for FindTheDuplicateNumber.
Created Date: Dec 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/find-the-duplicate-number/description/

Modification Log: 
Date                Name                                            Description
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added Class FindTheDuplicateNumber
Dec 11, 2022		Chandra Sekhar Reddy Muthumula					Added findDuplicate
Dec 15, 2022		Chandra Sekhar Reddy Muthumula					Added findDuplicateCyclicSort
--------------------------------------------------------------------------------------------------
287. Find the Duplicate Number
Medium
17.4K
2.4K
Companies
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
-------------------------------------------------------------------------------------------
*/
package Problems.FindTheDuplicateNumber;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }   

    public int findDuplicateCyclicSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int correct = nums[i] - 1;
            while(nums[i] != nums[correct]) {
                // swap(nums, i, correct);
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
                correct = nums[i] - 1;
            }
        }
        return nums[len -1];
    }

    public void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }
}