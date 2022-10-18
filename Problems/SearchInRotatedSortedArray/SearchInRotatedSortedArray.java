/*
Class Name  : SearchInRotatedSortedArray
Description : This class consists of the solution for SearchInRotatedSortedArray.
Date        : Oct 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

Modification Log: 
Date					Name                                            Description
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class SearchInRotatedSortedArray 
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added searchBruteForce 
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added searchBinarySearch
--------------------------------------------------------------------------------------------------
33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, 
nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, 
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
-------------------------------------------------------------------------------------------
*/
package Problems.SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {

    public int searchBruteForce(int[] nums, int target) {
        // Brute force
        int len = nums.length;
        for (int i=0; i<len; i++) {
            if(target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public int  searchBinarySearch(int[] nums, int target) {
        // Efficient way
        /*
         * TC : O(LogN)
         * SC : O(1)
        */
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            
            if (nums[mid] == target) return mid;
            
            // Checking in left portion
            if(nums[start] <= nums[mid]) {
                if(target < nums[start] || target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else { // This is the right portion
                if (target > nums[end] || target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}