/*
Class Name  : SquaresOfSortedArray
Description : This class consists of the solution for SquaresOfSortedArray.
Date        : Nov 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/squares-of-a-sorted-array/description/

Modification Log: 
Date				    Name                                            Description
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class SquaresOfSortedArray 
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added sortedSquaresBinarySearch
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added sortedSquaresTwoPointers
Nov 14, 2022			Chandra Sekhar Reddy Muthumula					Added sortedSquaresBruteForce
--------------------------------------------------------------------------------------------------
977. Squares of a Sorted Array
Easy
6.8K
172
Companies
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
-------------------------------------------------------------------------------------------
*/
package Problems.SquaresOfSortedArray;
import java.util.Arrays;
public class SquaresOfSortedArray {
    
    public int[] sortedSquaresBinarySearch(int[] A) {
        /*
         * TC : O(N)
         * SC : O(1)
         * Even thought binary search is used it take O(N) time complexity
        */
        if (A == null || A.length < 1) return A;
        int left = 0, right = A.length - 1;
        int index = binarySearch(A, left, right);        
        int[] res = new int[A.length];
        int toLeft = index - 1;
        int toRight = index + 1;
        res[0] = A[index] * A[index];
        int count = 1;
        while (toLeft >= 0 && toRight < A.length) {
            if (Math.abs(A[toLeft]) < Math.abs(A[toRight])) {
                res[count++] = A[toLeft] * A[toLeft];
                toLeft--;
            } else {
                res[count++] = A[toRight] * A[toRight];
                toRight++;
            }
        }
        
        while (toLeft >= 0) {
            res[count++] = A[toLeft] * A[toLeft];
            toLeft--;
        }
        
        while (toRight < A.length) {
            res[count++] = A[toRight] * A[toRight];
            toRight++;
        }
        return res;
    }
    
    private int binarySearch(int[] A, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == 0) return mid;
            if (A[mid] < 0) left = mid;
            else right = mid;
        }
        if (Math.abs(A[left]) < Math.abs(A[right])) return left;
        return right;
    }

    public int[] sortedSquaresTwoPointers(int[] nums) {
        /*
         * TC : O(N)
         * SC : O(1)
        */
        int len = nums.length;
        int i = 0, j = len - 1;
        int[] result = new int[len];
        for (int p = len - 1; p >= 0; p--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[p] = nums[i] * nums[i];
                i++;
            } else {
                result[p] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }

    public int[] sortedSquaresBruteForce(int[] nums) {
        /*
         * TC : O(N LogN)
         * SC : O(1)
        */
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] = (int)Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }
}