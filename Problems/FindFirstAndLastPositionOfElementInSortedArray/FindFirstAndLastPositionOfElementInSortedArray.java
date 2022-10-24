/*
Class Name  : FindFirstAndLastPositionOfElementInSortedArray
Description : This class consists of the solution for FindFirstAndLastPositionOfElementInSortedArray.
Date        : Oct 24, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Modification Log: 
Date					Name                                            Description
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindFirstAndLastPositionOfElementInSortedArray 
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added searchRange 
--------------------------------------------------------------------------------------------------
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, 
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.


Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
-------------------------------------------------------------------------------------------
*/
package Problems.FindFirstAndLastPositionOfElementInSortedArray;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        // This is an edge case where the length of nums is 1 and the target is matching
        if(len == 1) {
            if(target == nums[0]) {
                return new int[] {0, 0};
            }
        } 
        int start = 0;
        int end = nums.length - 1;
        // Initialize the result array with default not fould answer
        int[] result = {-1, -1};
        // Binary search
        /*
        * TC : O(Log N)
        * SC : O(1)
        */
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if(nums[mid] == target) {
                int firstIndex = mid;
                int lastIndex = mid;
                // Once after the target is found then search for the target towards right
                while(firstIndex - 1 >= 0 && nums[firstIndex] == nums[firstIndex - 1])firstIndex--;
                // Once after the target is found then search for the target towards left
                while(lastIndex + 1 < len && nums[lastIndex] == nums[lastIndex + 1])lastIndex++;
                // Assign the minimum to result[0]
                result[0] = firstIndex;
                // Assign the maximum to result[1]
                result[1] = lastIndex;
                return result;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;       
    }
}