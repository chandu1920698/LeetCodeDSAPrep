/*
Class Name  : ThirdMaximumNumber
Description : This class consists of the solution for ThirdMaximumNumber.
Date        : Oct 31, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/third-maximum-number/

Modification Log: 
Date					Name                                            Description
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class ThirdMaximumNumber 
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added thirdMax
--------------------------------------------------------------------------------------------------
414. Third Maximum Number

Given an integer array nums, return the third distinct maximum number in this array. 
If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Can you find an O(n) solution?
-------------------------------------------------------------------------------------------
*/
package Problems.ThirdMaximumNumber;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        
    }

    public static int thirdMax(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        // if (len == 3) return nums[0] < (nums[1] < nums[2] ? nums[1] : nums[2]) ? nums[0] : (nums[1] < nums[2] ? nums[1] : nums[2]);
        
        long fmax = Long.MIN_VALUE;
        long smax = Long.MIN_VALUE;
        long tmax = Long.MIN_VALUE;
        
        while(--len >= 0) {
            if (fmax == nums[len] || smax == nums[len] || tmax == nums[len]) continue;
            if (fmax < nums[len]) {
                tmax = smax;
                smax = fmax;
                fmax = nums[len];
            } else if (smax < nums[len]) {
                tmax = smax;
                smax = nums[len];
            } else if (tmax < nums[len]) {
                tmax = nums[len];
            }
        }
        // System.out.println("fmax: " + fmax + " smax : " + smax + " tmax : " + tmax);
        return tmax < Integer.MIN_VALUE ? (int)fmax : (int)tmax;
    }
}