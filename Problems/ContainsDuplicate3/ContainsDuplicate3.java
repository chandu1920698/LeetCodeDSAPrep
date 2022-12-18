/*
Class Name  : ContainsDuplicate3
Description : This class consists of the solution for ContainsDuplicate3.
Created Date: Dec 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/contains-duplicate-iii/description/
Modification Log: 
Date					Name                                            Description
Dec 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class ContainsDuplicate3 
dec 18, 2022			Chandra Sekhar Reddy Muthumula					Added containsNearbyAlmostDuplicate
--------------------------------------------------------------------------------------------------
220. Contains Duplicate III
Hard
353
7
Companies
You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
Return true if such pair exists or false otherwise.

 

Example 1:

Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
Explanation: We can choose (i, j) = (0, 3).
We satisfy the three conditions:
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
Example 2:

Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.
 

Constraints:

2 <= nums.length <= 105
-109 <= nums[i] <= 109
1 <= indexDiff <= nums.length
0 <= valueDiff <= 109
------------------------------------------------------------------------------------------------------
*/

package Problems.ContainsDuplicate3;

public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int len = nums.length;
       for (int i = 0; i < len; i++ ) {
            for (int j = Math.max((i - indexDiff), 0); j < i; j++ ) {
                if (Math.abs(nums[i] - nums[j]) <= valueDiff){
                    return true;
                }
            }
        }
        return false;
    }
}
