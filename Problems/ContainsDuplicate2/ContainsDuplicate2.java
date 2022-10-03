
/*
Class Name  : ContainsDuplicate2
Description : This class consists of the solution for ContainsDuplicate2.
Date        : Oct 3, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/contains-duplicate-ii/
Modification Log: 
Date					Name                                            Description
Oct 3, 2022			Chandra Sekhar Reddy Muthumula					Added Class ContainsDuplicate2 
Oct 3, 2022			Chandra Sekhar Reddy Muthumula					Added containsNearbyDuplicate 
--------------------------------------------------------------------------------------------------
219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
------------------------------------------------------------------------------------------------------
*/
package Problems.ContainsDuplicate2;
import java.util.*;;
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if(len <= 1) {
            return false;
        }
        
        // This is brute force method.
        // This is giving Time Limit exceed error
        /*
        * TC : O(N^2)
        * SC : O(1)
        */
        // for (int i=0; i<len; i++) {
        //     for (int j=i+1; j<len; j++) {
        //         if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
        //             return true;
        //         }
        //     }   
        // }
        
        
        // This is some what optimized
        /*
        * TC : O(N^2) - Worst Case
        * TC : O(N*K) - Average Case
        * SC : O(1)
        */
        // if (k >= len) {
        //     for (int i=0; i<len; i++) {
        //         for (int j=i+1; j<len; j++) {
        //             if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
        //                 return true;
        //             }
        //         }   
        //     }
        // } else if (k < len) {
        //     int i =0;
        //     for (i=0; i<len-k; i++) {
        //         for (int j=i+k; j>i; j--) {
        //             if (nums[i] == nums[j]) {
        //                 return true;
        //             }
        //         }
        //     }
        //     for (; i<len-1;i++) {
        //         if(nums[i] == nums[i+1]) {
        //             return true;
        //         }
        //     }
        // } 
        
        
        // This is HashMap method
        /*
        * TC : O(N) - Worst Case
        * SC : O(N) - Worst Case
        */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<len; i++) {
            if(map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            } 
        }
        return false;
    }
}