/*
Class Name  : SortAnArray
Description : This class consists of the solution for SortAnArray.
Created Date: Dec 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/sort-an-array/description/

Modification Log: 
Date					Name                                            Description
Dec 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class SortAnArray 
Dec 14, 2022			Chandra Sekhar Reddy Muthumula					Added sort
Dec 14, 2022			Chandra Sekhar Reddy Muthumula					Added sortArray
Dec 14, 2022			Chandra Sekhar Reddy Muthumula					Added mergeSort
--------------------------------------------------------------------------------------------------
912. Sort an Array
Medium
3.1K
586
Companies
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
-------------------------------------------------------------------------------------------
*/
package Problems.SortAnArray;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        /* 
         * Merge Sort
         * Best, Avg, Worst TC : O(NLogN)
         * SC : O(N)
        */
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] arr, int start, int end) {
        if (start < end ) {
            int mid = start + ((end - start) >> 1);
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            mergeSort(arr, start, mid, end);
        }
    }

    public void mergeSort(int[] arr, int start, int mid, int end) {
        int len1 = mid - start + 1;
        int[] arr1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            arr1[i] = arr[i + start];
        }

        int len2 = end - mid;
        int[] arr2 = new int[len2];
        for (int i = 0; i < len2; i++) {
            arr2[i] = arr[i + mid + 1];
        }

        int i = 0, j = 0, k = start;
        while (i < len1 && j <len2) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < len1) {
            arr[k++] = arr1[i++];
        }

        while (j <len2) {
            arr[k++] = arr2[j++];
        }
    }
}