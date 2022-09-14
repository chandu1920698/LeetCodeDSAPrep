/*
Class Name  : MoveZeroes
Description : This class consists of the solution for MoveZeroes.
Date        : Sep 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/move-zeroes/

Modification Log: 
Date					Name                                            Description
Sep 14, 2022			Chandra Sekhar Reddy Muthumula					Added Class MoveZeroes 
Sep 14, 2022			Chandra Sekhar Reddy Muthumula					Added moveZeroes 
--------------------------------------------------------------------------------------------------
283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 
Constraints:
1 <= nums.length <= 104
-2^31 <= nums[i] <= 2^31 - 1

Follow up: Could you minimize the total number of operations done?

*/


class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        int numsLength = nums.length;
        if (numsLength <= 10000 && 1 <= numsLength) {
			/*
			TC 			: O(N+N)
			SC 			: O(1)
			Recommended : YES
			*/
            int resultIndex = 0;
            for (int i=0; i<numsLength; i++) {
                if ( !(nums[i] == 0)) {
                    nums[resultIndex++] = nums[i];
                }
            }
            for (int i=resultIndex; i<numsLength;  i++) {
                nums[i] = 0;
            }
        }
        return nums;
    }
}