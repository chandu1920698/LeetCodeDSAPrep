/*
Class Name  : FrequencyOfTheMostFrequentElement
Description : This class consists of the solution for LongestCommonPrefix.
Date        : Nov 9, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

Modification Log: 
Date				Name                                            Description
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added Class FrequencyOfTheMostFrequentElement 
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added maxFrequency 
--------------------------------------------------------------------------------------------------
1838. Frequency of the Most Frequent Element
Medium
1.9K
46
Companies
The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

 

Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.
Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
Example 3:

Input: nums = [3,9,6], k = 2
Output: 1
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= 105
-------------------------------------------------------------------------------------------
*/
package Problems.FrequencyOfTheMostFrequentElement;

import java.util.*;

public class FrequencyOfTheMostFrequentElement {

    /*
     * Intuition
     * Sort the input array
     * Sliding window prolem
     * 
     * Approach
     * Complexity
     * Time complexity: O(NLogN)
     * Space complexity: O(1)
     * Code
     */
    public int maxFrequency(int[] nums, int k) {
        // Sort the array as we need to group the same elements to apply sliding window
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        int len = nums.length;
        long sum = 0;
        int max_window_len = 0;
        while (right < len) {
            sum += nums[right];

            while (left < len && (nums[right] * (right - left + 1)) > (sum + k)) {
                sum -= nums[left];
                left++;
            }
            max_window_len = Math.max(max_window_len, right - left + 1);
            right++;
        }
        return max_window_len;
    }

}