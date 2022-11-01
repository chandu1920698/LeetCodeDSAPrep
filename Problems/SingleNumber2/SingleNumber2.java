/*
Class Name  : SingleNumber2
Description : This class consists of the solution for SingleNumber2.
Date        : Nov 1, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/single-number-ii/

Modification Log: 
Date				Name                                            Description
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class SingleNumber2 
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added singleNumberHashMapFrequency
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added singleNumberSorting
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added singleNumberBitManipulation
--------------------------------------------------------------------------------------------------
137. Single Number II

Given an integer array nums where every element appears three times except for one, 
which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
-------------------------------------------------------------------------------------------
*/
package Problems.SingleNumber2;

import java.util.*;

public class SingleNumber2 {

    public static void main(String[] args) {

    }

    public static int singleNumberHashMapFrequency(int[] nums) {
        // HashMap and Frequency method
        /*
         * TC : O(N)
         * SC : O(N)
         */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    public static int singleNumberSorting(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        // Sorting and Linear traversal
        /*
         * TC : O(NLogN + N)
         * SC : O(1)
         */
        Arrays.sort(nums);

        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[len - 1] != nums[len - 2]) {
            return nums[len - 1];
        }

        for (int i = 1; i < len; i += 3) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                return nums[i - 1];
            }
        }
        return 0;
    }

    public static int singleNumberBitManipulation(int[] nums) {
        // This is Bit Manipulation method
        /*
         * TC : O(N)
         * SC : O(1)
         */
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            // ones = (ones ^ num) & (~twos);
            // twos = (twos ^ num) & (~ones);
            ones ^= num & (~twos);
            twos ^= num & (~ones);
        }
        return ones;
    }
}