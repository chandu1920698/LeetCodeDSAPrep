/*
Class Name  : BinarySearch
Description : This class consists of the solution for BinarySearch.
Date        : Oct 1, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/binary-search/

Modification Log: 
Date					Name                                            Description
Oct 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class BinarySearch 
Oct 1, 2022			Chandra Sekhar Reddy Muthumula					Added search 
Oct 1, 2022			Chandra Sekhar Reddy Muthumula					Added searchRecursive
--------------------------------------------------------------------------------------------------
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:

1 <= nums.length <= 10^4
-10^4 < nums[i], target < 10^4
All the integers in nums are unique.
nums is sorted in ascending order.
-------------------------------------------------------------------------------------------
*/
public class BinarySearch {
    // This is the generic Binary search method using Iterators
    /*
     * TC : O(LogN)
     * SC : O(1)
    */
    // public int search(int[] nums, int target) {
    //     int start = 0;
    //     int end = nums.length - 1;
    //     while(start <= end) {
    //         int mid = start + ((end - start) >> 1); 
    //         if (nums[mid] == target) {
    //             return mid;
    //         } else if(target < nums[mid]) {
    //             end = mid - 1;
    //         } else {
    //             start = mid + 1;
    //         }
    //     }
    //     return -1;
    // }
    

    // This is the Binary search method using Recursion
     /*
     * TC : O(LogN)
     * SC : O(LogN)
    */
    public int search(int[] nums, int target) {
        return searchRecursive(nums, target, 0,  nums.length - 1);
    }
    
    public int searchRecursive(int[] nums, int target, int start, int end) {
        if (start > end ) return -1; 
        int mid = start + ((end - start) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return searchRecursive(nums, target, start, mid -1 );
        } else {
            return searchRecursive(nums, target, mid + 1, end );
        }
    }
}
