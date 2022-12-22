/*
Class Name  : FindPeakElement
Description : This class consists of the solution for FindPeakElement.
Created Date: Dec 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-peak-element/description/

Modification Log: 
Date					Name                                            Description
Dec 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindPeakElement 
Dec 22, 2022			Chandra Sekhar Reddy Muthumula					Added findPeakElement 
--------------------------------------------------------------------------------------------------
162. Find Peak Element
Medium
8.1K
4.1K
Companies
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
-------------------------------------------------------------------------------------------
*/package Problems.FindPeakElement;

public class FindPeakElement {
    public int findPeakElement(int[] arr) {
        int len = arr.length;
        int start = 0;
        int end = len - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);

            if (arr[mid] < arr[mid + 1]) {
                // Increaing part, so start will be mid + 1
                start = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                // In the decreasing part, so the end will be mid only, 
                // not mid - 1 because we dont know if the mid is peak or not
                end = mid;
            }

            if (start == end) {
                return start;
            }
        }
        return start;
    }
}
