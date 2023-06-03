/*
Class Name  : FindMinimumInRotatedSortedArray
Description : This class consists of the solution for FindMinimumInRotatedSortedArray.
Date        : Jun 3, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
Modification Log: 
Date				Name                                            Description
Jun 3, 2023			Chandra Sekhar Reddy Muthumula					Added Class FindMinimumInRotatedSortedArray 
Jun 3, 2023			Chandra Sekhar Reddy Muthumula					Added searchMatrix 
--------------------------------------------------------------------------------------------------
153. Find Minimum in Rotated Sorted Array
Medium
10.6K
483
Companies
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.
------------------------------------------------------------------------------------------------------
*/package Problems.FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArray {
    /* 
     * TC : O(Log N)
     * SC : O(1)
    */
    public int findMin(int[] nums) {
        int len = nums.length;
        int start = 0, end = len - 1;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            if(mid + 1 < len && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if( mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if(nums[start] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[0];
    }
}