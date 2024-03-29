/*
Class Name  : Pattern132
Description : This class consists of the solution for Pattern132.
Created Date: Feb 27, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/132-pattern/description/
Modification Log: 
Date					    Name                                            Description
Feb 27, 2022			    Chandra Sekhar Reddy Muthumula					Added Class Pattern132 
Feb 27, 2022			    Chandra Sekhar Reddy Muthumula					Added find132pattern
Feb 27, 2022			    Chandra Sekhar Reddy Muthumula					Added find132patternWithoutStack
--------------------------------------------------------------------------------------------------
456. 132 Pattern
Medium
5.4K
309
Companies
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109
------------------------------------------------------------------------------------------------------
*/
package Problems.Pattern132;
import java.util.*;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int thirdElement = Integer.MIN_VALUE;
        for(int i = len - 1; i >= 0; i--) {
            if(nums[i] < thirdElement) {
                return true;
            }
            while(!stack.isEmpty() && stack.peek() < nums[i]) {
                thirdElement = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }


    public boolean find132patternWithoutStack(int[] nums) {
        /* 
         * TC : O(N ^ 2)
         * SC : O(1)
        */
        int len = nums.length;
        // if (len < 3) return false;
        int min = nums[0];
        for(int j = 0; j < len - 1; j++) {
            for(int k = j + 1; k < len; k++) {
                if(nums[k] > min && nums[j] > nums[k]) {
                    return true;
                }  else {
                    min = Math.min(min, nums[j]);
                }
            }
        }
        return false;
    }
}
