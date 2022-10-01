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
        int len = nums.length;
        
        // This is brute force method
        /*
         TC : O(N^2)
         SC : O(1)
        */
        // for (int i=0; i < len; i++) {
        //     int count = 0;
        //     for (int j = 0; j < len; j++ ) {
        //         if(nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if(count > len/2){
        //         return nums[i];
        //     }
        // }
        
        // This is HashMap method
        /*
         TC : O(N)
         SC : O(N)
        */
        
        // HashMap<Integer, Integer> map = new HashMap<>();
        // if (len == 1) return nums[0];
        // else if (1 < n && n <= 50000) {
        //     for (int i=0; i<n; i++) {
        //         if (!map.containsKey(nums[i])) {
        //             map.put((Integer)nums[i], (Integer)1);
        //         } else {
        //             if (len/2 < (Integer)(map.get(nums[i]) + 1)) {
        //                 return nums[i];
        //             }
        //             map.put((Integer)nums[i], (Integer)(map.get(nums[i]) + 1));
        //         }                
        //     }
        // }
        
        // This is Array sorting method
        /*
         TC : O(NLogN)
         SC : O(1)
        */
        // Arrays.sort(nums);
        // return nums[len/2];
        
        
        // This is a new method
        /*
         TC : O(N)
         SC : O(1)
        */
        
        int count = 1;
        int maxValue = nums[0];
        for (int i=1; i<len; i++) {
            if (count == 0) {
                count++;
                maxValue = nums[i];
            } else if (maxValue == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return maxValue;
        
    }
}