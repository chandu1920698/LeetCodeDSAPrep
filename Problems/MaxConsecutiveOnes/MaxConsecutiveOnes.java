/*
Class Name  : MaxConsecutiveOnes
Description : This class consists of the solution for MaxConsecutiveOnes.
Date        : Nov 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/max-consecutive-ones/description/

Modification Log: 
Date				    Name                                            Description
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class MaxConsecutiveOnes 
Nov 13, 2022			Chandra Sekhar Reddy Muthumula					Added findMaxConsecutiveOnes
--------------------------------------------------------------------------------------------------
485. Max Consecutive Ones
Easy
3.6K
414
Companies
Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
-------------------------------------------------------------------------------------------
*/
package Problems.MaxConsecutiveOnes;

public class MaxConsecutiveOnes {
    /*
     * TC : O(N)
     * SC : O(1)
    */
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int max_ones = 0;
        if (len == 1 && nums[0] == 0) return 0;
        int end = 0;
        int start = 0;
        while (end < len) {
            while (start < len && nums[start] == 0) start++;
            end = start;
            while(end < len && nums[end] == 1) end++;
            max_ones = Math.max(max_ones, end - start);
            start = end;
            
        }
        return max_ones;
    }
}