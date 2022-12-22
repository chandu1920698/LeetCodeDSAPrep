/*
Class Name  : PeakIndeInMountainArray
Description : This class consists of the solution for PeakIndeInMountainArray.
Created Date: Dec 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

Modification Log: 
Date					Name                                            Description
Dec 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class PeakIndeInMountainArray 
Dec 22, 2022			Chandra Sekhar Reddy Muthumula					Added peakIndexInMountainArray 
--------------------------------------------------------------------------------------------------
852. Peak Index in a Mountain Array
Medium
4.3K
1.8K
Companies
An array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.

 

Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1
 

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
-------------------------------------------------------------------------------------------
*/
package Problems.PeakIndeInMountainArray;

public class PeakIndeInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
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