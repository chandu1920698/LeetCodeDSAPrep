/*
Class Name  : FindNumberswithEvenNumberofDigits
Description : This class consists of the solution for FindNumberswithEvenNumberofDigits.
Date        : May 09, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
Modification Log: 
Date					Name                                            Description
May 09, 2023			Chandra Sekhar Reddy Muthumula					Added Class FindNumberswithEvenNumberofDigits 
May 09, 2023			Chandra Sekhar Reddy Muthumula					Added findNumbers 
May 09, 2023			Chandra Sekhar Reddy Muthumula					Added containsEvenNoOfDigits 
May 09, 2023			Chandra Sekhar Reddy Muthumula					Added findNumbersBruteForce 
--------------------------------------------------------------------------------------------------
268. MissingNumber

1295. Find Numbers with Even Number of Digits
Easy
1.9K
113
Companies
Given an array nums of integers, return how many of them contain an even number of digits.

 

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.
 

Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 105
------------------------------------------------------------------------------------------------------
*/
package Problems.FindNumberswithEvenNumberofDigits;

public class FindNumberswithEvenNumberofDigits {
    public int findNumbers(int[] nums) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(containsEvenNoOfDigits(nums[i])) {
                count++;
            }
        }
        return count;
    }

    private boolean containsEvenNoOfDigits(int num) {
        if(num == 0) {
            return false;
        }
        int digits = 0;
        while(num > 0) {
            digits++;
            num /= 10;
        }

        if((digits % 2) == 0) {
            return true;
        }
        return false;
    }

    public int findNumbersBruteForce(int[] nums) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            if((nums[i] >= 10 && nums[i] <= 99) ||
               (nums[i] >= 1000 && nums[i] <= 9999) || 
               (nums[i] == 100000)
            ) {
                count++;
            }
        }
        return count;
    }
}