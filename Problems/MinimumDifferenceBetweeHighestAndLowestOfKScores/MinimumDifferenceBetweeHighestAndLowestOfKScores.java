/*
Class Name  : MinimumDifferenceBetweeHighestAndLowestOfKScores
Description : This class consists of the solution for MinimumDifferenceBetweeHighestAndLowestOfKScores.
Created Date: Feb 25, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
Modification Log: 
Date					    Name                                            Description
Feb 25, 2022			    Chandra Sekhar Reddy Muthumula					Added Class MinimumDifferenceBetweeHighestAndLowestOfKScores 
Feb 25, 2022			    Chandra Sekhar Reddy Muthumula					Added minimumDifference
Jun 08, 2023			    Chandra Sekhar Reddy Muthumula					Added minimumDifferenceForLoop
--------------------------------------------------------------------------------------------------
1984. Minimum Difference Between Highest and Lowest of K Scores
Easy
672
118
Companies
You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.

Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.

Return the minimum possible difference.

 

Example 1:

Input: nums = [90], k = 1
Output: 0
Explanation: There is one way to pick score(s) of one student:
- [90]. The difference between the highest and lowest score is 90 - 90 = 0.
The minimum possible difference is 0.
Example 2:

Input: nums = [9,4,1,7], k = 2
Output: 2
Explanation: There are six ways to pick score(s) of two students:
- [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
- [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
- [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
- [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
- [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
- [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
The minimum possible difference is 2.
 

Constraints:

1 <= k <= nums.length <= 1000
0 <= nums[i] <= 105
------------------------------------------------------------------------------------------------------
*/

package Problems.MinimumDifferenceBetweeHighestAndLowestOfKScores;
import java.util.*;
public class MinimumDifferenceBetweeHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        /* 
         * TC : O(NlogN)
         * SC : O(1)
        */
        int start = 0;
        int end = k - 1;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        while(end < nums.length) {
            result = Math.min(result, nums[end] - nums[start]);
            start++;
            end++;
        }
        return result;
    }

    public int minimumDifferenceForLoop(int[] nums, int k) {
        /* 
         * TC : O(NlogN)
         * SC : O(1)
        */
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - k + 1; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }
        if(minDiff == 2147483647) {
            return 0;
        }
        return minDiff;
    }
}