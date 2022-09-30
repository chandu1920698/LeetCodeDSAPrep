/*
Class Name  : ContainsDuplicate
Description : This class consists of the solution for ContainsDuplicate.
Date        : Sep 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/contains-duplicate/
Modification Log: 
Date					Name                                            Description
Sep 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class ContainsDuplicate 
Sep 18, 2022			Chandra Sekhar Reddy Muthumula					Added containsDuplicate
--------------------------------------------------------------------------------------------------
217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

------------------------------------------------------------------------------------------------------
*/
import java.util.*;;
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
	
		/*
		Brute Force Method
		TC 			: O(N^2)
		SC 			: O(1)
		Recommended : NO
		*/
		
        // for (int i=0; i<nums.length; i++) {
        //     for (int j=i+1; j<nums.length; j++) {
        //         if ((nums[i] ^ nums[j]) == 0) {
        //             return true;
        //         }
        //     }
        // }
        
		/*
		TC 			: O(NLogN) + O(N)
		SC 			: O(1)
		Recommended : Not sure - based on the requirement
		*/
		
        // Arrays.sort(nums);
        // //System.out.println(Arrays.toString(nums));
        // for (int i=0; i<nums.length-1; i++) {
        //     if((nums[i] ^ nums[i+1]) == 0) {
        //         return true;
        //     }
        // }
        
		/*
		TC 			: O(N)
		SC 			: O(N)
		Recommended : Not sure - based on the requirement
		*/
		
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}