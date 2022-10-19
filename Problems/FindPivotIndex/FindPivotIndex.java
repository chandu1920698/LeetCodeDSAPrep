/*
Class Name  : FindPivotIndex
Description : This class consists of the solution for FindPivotIndex.
Date        : Sep 25, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-pivot-index/

Modification Log: 
Date					Name                                            Description
Sep 25, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindPivotIndex 
Sep 25, 2022			Chandra Sekhar Reddy Muthumula					Added pivotIndex
Oct 19, 2022			Chandra Sekhar Reddy Muthumula					Added pivotIndexBruteForce
--------------------------------------------------------------------------------------------------
724. Find Pivot Index

Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
 

Constraints:

1 <= nums.length <= 10^4
-1000 <= nums[i] <= 1000

Note: This question is the same as 1991: https://leetcode.com/problems/find-the-middle-index-in-array/
-------------------------------------------------------------------------------------------
*/

class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int totalSum = 0;
        for (int i=0; i<len ; i++) {
            totalSum += nums[i];
        }
        
        int leftSum = 0;
        
        for (int i=0; i<len; i++) {
            totalSum = totalSum - nums[i]; // This is right sum
            if (totalSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
         }
        return -1;
    }

    public int pivotIndexBruteForce(int[] nums) {
        /*
         * TC : O(N) + O(N)
         * SC : O(N) + O(N)
        */
        int len = nums.length;
        int[] leftsum = new int[len];
        int[] rightsum = new int[len];
        
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            left += nums[i]; 
            leftsum[i] = left;
            
            right += nums[len - 1 - i];
            rightsum[len - 1 - i] = right;
            
        }
        
        // System.out.println("leftsum :" + Arrays.toString(leftsum));
        // System.out.println("rightsum :" + Arrays.toString(rightsum));
        
        for (int i = 0; i < len; i++) {
            // System.out.println("Leftsum :" + leftsum[i-1] + " RightSum : " + rightsum[i + 1] );
            if (leftsum[i] == rightsum[i]) {
                return i;
            }
        }
        
        return -1;
        
    }
}