/*
Class Name  : SearchInsertPosition
Description : This class consists of the solution for SearchInsertPosition.
Date        : Sep 25, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/search-insert-position/

Modification Log: 
Date					Name                                            Description
Sep 25, 2022			Chandra Sekhar Reddy Muthumula					Added Class SearchInsertPosition 
Sep 25, 2022			Chandra Sekhar Reddy Muthumula					Added searchInsert 
--------------------------------------------------------------------------------------------------
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
 
Constraints:
1 <= nums.length <= 10^4
-104 <= nums[i] <= 10^4
nums contains distinct values sorted in ascending order.
-104 <= target <= 10^4
-------------------------------------------------------------------------------------------
*/

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int index = -1;
        if (len == 1) {
            if (nums[0] == target) return 0;
            else {
                if (target > nums[0]) return 1;
                else return 0;
            }
        } else {
            int start = 0;
            int end = len - 1;
            while(start <= end) {
                int mid = start + (end-start)/2;
                if(nums[mid] == target) {  
                    return mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                    
                } else if (nums[mid] > target) {
                    end = mid - 1;
                }
            }
            index = start;
        }
        return index;
    }
}