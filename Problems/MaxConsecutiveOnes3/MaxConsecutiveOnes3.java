/*
Class Name  : MaxConsecutiveOnes3
Description : This class consists of the solution for MaxConsecutiveOnes3.
Date        : Nov 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/max-consecutive-ones-iii/description/

Modification Log: 
Date				    Name                                            Description
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class MaxConsecutiveOnes3 
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added longestOnes
--------------------------------------------------------------------------------------------------
1004. Max Consecutive Ones III
Medium
5.5K
66
Companies
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
-------------------------------------------------------------------------------------------
*/
package Problems.MaxConsecutiveOnes3;

public class MaxConsecutiveOnes3 {
    /*
     * TC : O(N)
     * SC : O(1)
    */
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right;
        for (right = 0; right < len; right++) {
            if(nums[right] == 0) {
                k--;
            }

            if (k < 0 && nums[left++] == 0) {
                k++;
            }
        }
        return right - left;
    }
}