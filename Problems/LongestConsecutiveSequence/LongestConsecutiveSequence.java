/*
Class Name  : LongestConsecutiveSequence
Description : This class consists of the solution for LongestConsecutiveSequence.
Date        : Oct 29, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/longest-consecutive-sequence/

Modification Log: 
Date					Name                                            Description
Oct 29, 2022			Chandra Sekhar Reddy Muthumula					Added Class LongestConsecutiveSequence 
Oct 29, 2022			Chandra Sekhar Reddy Muthumula					Added longestConsecutiveEfficient
Oct 29, 2022			Chandra Sekhar Reddy Muthumula					Added longestConsecutiveVeryEfficient
--------------------------------------------------------------------------------------------------
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, 
return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
-------------------------------------------------------------------------------------------
*/
package Problems.LongestConsecutiveSequence;

import java.util.*;

public class LongestConsecutiveSequence {
    
    public static void main(String[] args) {
        
    }

    public int longestConsecutiveEfficient(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if (nums.length == 0) return 0;
        // if (nums.length == 1) return 1;
        for (Integer num : nums) {
            set.add(num);
        }
        int count = 1;
        int maxCount = 1;
        for (Integer item : set) {
            if(!set.contains(item - 1)) {
                while (set.contains(item + 1)) {
                    count++;
                    maxCount = Math.max(maxCount, count);
                    item++;
                }
                count = 1;
            }
            
        }
        return  maxCount;
    }

    
    public int longestConsecutiveVeryEfficient(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if (nums.length == 0) return 0;
        for (Integer num : nums) {
            set.add(num);
        }
        int count = 1;
        for (int item : nums) {
            
            int max = 1, preVal = item - 1, nextVal = item + 1;
            
            while(set.contains(preVal)) {
                max++;
                set.remove(preVal--);
            }
            while(set.contains(nextVal)) {
                max++;
                set.remove(nextVal++);
            }
            count = Math.max(count, max);            
        }
        return  count;
    }
}