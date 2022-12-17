/*
Class Name  : SortArrayByParity2
Description : This class consists of the solution for SortArrayByParity2.
Created Date: Dec 17, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/sort-array-by-parity-ii/description/
Modification Log: 
Date					Name                                            Description
Dec 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class SortArrayByParity2 
Dec 17, 2022			Chandra Sekhar Reddy Muthumula					Added sortArrayByParityIIInPlaceSolution
Dec 17, 2022			Chandra Sekhar Reddy Muthumula					Added sortArrayByParityII
--------------------------------------------------------------------------------------------------
922. Sort Array By Parity II
Easy
2.1K
79
Companies
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]
 

Constraints:

2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
 

Follow Up: Could you solve it in-place?
------------------------------------------------------------------------------------------------------
*/
package Problems.SortArrayByParity2;

public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        int len = nums.length;
        if (nums == null || len == 0) {
            return new int[] {};
        }

        int evenIndex = 0, oddIndex = 1;
        int[] sortedArray = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                // num is even
                sortedArray[evenIndex] = nums[i];
                evenIndex += 2;

            } else {
                // Num is odd
                sortedArray[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }
        return sortedArray;
    }

    public int[] sortArrayByParityIIInPlaceSolution(int[] nums) {
        /*
         * TC : O(N)
         * SC : O(1)
         */
        int len = nums.length;
        if (nums == null || len == 0) {
            return new int[] {};
        }
        int start = 0, end = 1;
        while (start < len && end < len) {
            while (start < len && 0 == nums[start] % 2) {
                // If the index and the element are even
                start += 2;
                // Here we are skipping all the valid elements and its places
            }
            while (end < len && 1 == nums[end] % 2) {
                // If the index and the element are even
                end += 2;
                // Here we are skipping all the valid elements and its places
            }
            if (start < len && end < len) {
                // Here we found the even value element in odd index and odd value element in
                // even index
                // So swap both
                // One shot two birds
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                // start += 2;
                // end += 2;
            }
        }
        return nums;
    }
}