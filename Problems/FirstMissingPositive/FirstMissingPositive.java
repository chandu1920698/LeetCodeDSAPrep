/*
Class Name  : FirstMissingPositive
Description : This class consists of the solution for FirstMissingPositive.
Date        : Nov 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/first-missing-positive/description/

Modification Log: 
Date				    Name                                            Description
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class FirstMissingPositive
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added firstMissingPositiveBestMethod
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added firstMissingPositiveAvgMethod
Nov 23, 2022			Chandra Sekhar Reddy Muthumula					Added firstMissingPositiveLeastBestMethod
--------------------------------------------------------------------------------------------------
41. First Missing Positive
Hard
12.4K
1.5K
Companies
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
-------------------------------------------------------------------------------------------
*/
package Problems.FirstMissingPositive;

import java.util.*;

public class FirstMissingPositive {
    public int firstMissingPositiveBestMethod(int[] nums) {
        /*
         * TC : O(N) + O(N) + O(N) = O(N)
         * SC : O(1)
         */
        int len = nums.length;
        // Change all the -ves to 0 in in nus
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0)
                nums[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < len && index >= 0) {
                if (nums[index] > 0)
                    nums[index] *= -1;
                else if (nums[index] == 0)
                    nums[index] = -(len + 1);
            }
        }
        int i;
        for (i = 0; i < len; i++) {
            if (nums[i] >= 0)
                return i + 1;
        }
        return i + 1;
    }

    public int firstMissingPositiveAvgMethod(int[] nums) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        int len = nums.length;
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);
        int i;
        for (i = 1; i <= len; i++) {
            if (!numSet.contains(i))
                return i;
        }
        return i;
    }

    public int firstMissingPositiveLeastBestMethod(int[] nums) {
        /*
         * TC : O(N) + O(NLogN) = O(NLogN)
         * SC : O(1)
         */
        int len = nums.length;
        int minMissingNumber = 1;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                continue;
            } else {
                if (nums[i] != minMissingNumber)
                    return minMissingNumber;
                else
                    minMissingNumber++;

            }
            while (i + 1 < len && nums[i] == nums[i + 1])
                i++;
        }
        return minMissingNumber;
    }
}