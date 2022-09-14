/*
Class Name  : MajorityElement
Description : This class consists of the solution for MajorityElement.
Date        : Sep 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/majority-element/

Modification Log: 
Date					Name                                            Description
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class MajorityElement 
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added majorityElement 
--------------------------------------------------------------------------------------------------
8169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?

*/

class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // int maxValue = Integer.MIN_VALUE;
        // int count = Integer.MIN_VALUE;
        int count2 = 1;
        int maxValue2 = nums[0];
		
		/*
		TC 			: O(N)
		SC 			: O(N)
		Recommended : NO - Because it does not have O(1) Space Complexity
		*/
		
         // HashMap<Integer, Integer> map = new HashMap<>();
        // if (n==1) maxValue = nums[0];
        // else if (1 <= n && n <= 50000) {
        //     for (int i=0; i<n; i++) {
        //         if (!map.containsKey(nums[i])) {
        //             map.put((Integer)nums[i], (Integer)1);
        //         } else {
        //             if (count < (Integer)(map.get(nums[i]) + 1)) {
        //                 count = (Integer)(map.get(nums[i]) + 1);
        //                 maxValue = nums[i];
        //             }
        //             map.put((Integer)nums[i], (Integer)(map.get(nums[i]) + 1));
        //         }                
        //     }
        // }
		
		/*
		TC 			: O(N)
		SC 			: O(1)
		Recommended : YES
		*/
        
        for (int i=1; i<n; i++) {
            if (count2 == 0) {
                count2++;
                maxValue2 = nums[i];
            } else if (maxValue2 == nums[i]) {
                count2++;
            } else {
                count2--;
            }
        }
        return maxValue2;
    }
}