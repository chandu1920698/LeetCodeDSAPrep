/*
Class Name  : SingleElementInSortedArray
Description : This class consists of the solution for SingleElementInSortedArray.
Date        : Jun 06, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/single-element-in-a-sorted-array/description/

Modification Log: 
Date					Name                                            Description
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added Class SingleElementInSortedArray 
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added singleNonDuplicateBinarySearch 
Jun 04, 2023			Chandra Sekhar Reddy Muthumula					Added singleNonDuplicateBruteForce 
Jun 04, 2023			Chandra Sekhar Reddy Muthumula					Added singleNonDuplicateBruteForce1 
--------------------------------------------------------------------------------------------------
540. Single Element in a Sorted Array
Medium
9.2K
144
Companies
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
-------------------------------------------------------------------------------------------
*/
package Problems.SingleElementInSortedArray;

public class SingleElementInSortedArray {
    public int singleNonDuplicateBinarySearch(int[] nums) {
        /*
         * TC : O(Log N)
         * SC : O(1)
         */
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[len - 2] != nums[len - 1]) {
            return nums[len - 1];
        }

        int start = 0, end = len - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (mid % 2 == 0) {
                if (nums[mid + 1] != nums[mid]) {
                    end = mid;
                } else {
                    start = mid + 2;
                }
            } else {
                if (nums[mid - 1] != nums[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
        }

        return nums[start];
    }

    public int singleNonDuplicateBruteForce(int[] nums) {
        /*
         * TC : O(N)
         * SC : O(1)
         */
        int singleElement = 0;
        for (int num : nums) {
            singleElement ^= num;
        }

        return singleElement;
    }

    public int singleNonDuplicateBruteForce1(int[] nums) {
        /*
         * TC : O(N)
         * SC : O(1)
         */
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[len - 2] != nums[len - 1]) {
            return nums[len - 1];
        }

        for (int i = 1; i < len - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}