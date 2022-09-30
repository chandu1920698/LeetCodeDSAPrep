import java.util.HashMap;

/*
Class Name  : TwoSum
Description : This class consists of the solution for TwoSum.
Date        : Sep 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/two-sum/
Modification Log: 
Date					Name                                            Description
Sep 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class TwoSum 
Sep 18, 2022			Chandra Sekhar Reddy Muthumula					Added twoSum
--------------------------------------------------------------------------------------------------
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

------------------------------------------------------------------------------------------------------
*/
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		/*
		TC 			: O(N)
		SC 			: O(N)
		Recommended : YES
		*/
        for (int i=0; i<nums.length; i++) {
            int findNumber = target - nums[i];
            map.put(findNumber, i);
        }
        for (int i=0; i<nums.length; i++) {
            int findNumber = target - nums[i];
            if (map.containsKey(findNumber)) {
                
            }
        }
        return new int[] {-1,-1};
    }
}