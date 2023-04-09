/*
Class Name  : SumOfDistances
Description : This class consists of the solution for SumOfDistances.
Date        : Apr 09, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/sum-of-distances/description/

Modification Log: 
Date					Name                                            Description
Apr 09, 2023			Chandra Sekhar Reddy Muthumula					Added Class SumOfDistances 
Apr 09, 2023			Chandra Sekhar Reddy Muthumula					Added distance 
Apr 09, 2023			Chandra Sekhar Reddy Muthumula					Added distanceBruteForce
--------------------------------------------------------------------------------------------------
2615. Sum of Distances
Medium
196
46
Companies
You are given a 0-indexed integer array nums. There exists an array arr of length nums.length, where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i. If there is no such j, set arr[i] to be 0.

Return the array arr.

 

Example 1:

Input: nums = [1,3,1,1,2]
Output: [5,0,3,4,0]
Explanation: 
When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5. 
When i = 1, arr[1] = 0 because there is no other index with value 3.
When i = 2, nums[2] == nums[0] and nums[2] == nums[3]. Therefore, arr[2] = |2 - 0| + |2 - 3| = 3. 
When i = 3, nums[3] == nums[0] and nums[3] == nums[2]. Therefore, arr[3] = |3 - 0| + |3 - 2| = 4. 
When i = 4, arr[4] = 0 because there is no other index with value 2. 

Example 2:

Input: nums = [0,5,3]
Output: [0,0,0]
Explanation: Since each element in nums is distinct, arr[i] = 0 for all i.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
-------------------------------------------------------------------------------------------
*/

package Problems.SumOfDistances;

import java.util.*;

public class SumOfDistances {
    public long[] distance(int[] arr) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        long[] nums = new long[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        int len = nums.length;
        long[] result = new long[len];
        Map<Long, Long> prevIndicesSum = new HashMap<>();
        Map<Long, Long> prevFreqMap = new HashMap<>();

        Map<Long, Long> suffixIndicesSum = new HashMap<>();
        Map<Long, Long> suffixFreqMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int j = len - 1 - i;
            if (prevFreqMap.containsKey(nums[i])) {
                result[i] += i * prevFreqMap.get(nums[i]);
            }
            prevFreqMap.put(nums[i], prevFreqMap.getOrDefault(nums[i], 0L) + 1);
            if (!prevIndicesSum.containsKey(nums[i])) {
                prevIndicesSum.put(nums[i], 0L);
            }
            result[i] -= prevIndicesSum.get(nums[i]);

            prevIndicesSum.put(nums[i], prevIndicesSum.getOrDefault(nums[i], 0L) + i);

            if (suffixFreqMap.containsKey(nums[j])) {
                result[j] -= j * suffixFreqMap.get(nums[j]);
            }
            suffixFreqMap.put(nums[j], suffixFreqMap.getOrDefault(nums[j], 0L) + 1);
            if (!suffixIndicesSum.containsKey(nums[j])) {
                suffixIndicesSum.put(nums[j], 0L);
            }
            result[j] += suffixIndicesSum.get(nums[j]);

            suffixIndicesSum.put(nums[j], suffixIndicesSum.getOrDefault(nums[j], 0L) + j);

        }
        // System.out.println(prevIndicesSum);
        // System.out.println(prevFreqMap);
        return result;
    }

    public long[] distanceBruteForce(int[] nums) {
        /*
         * Brute Force
         * TC : O(N ^ 2)
         * SC : O(1)
         */
        int len = nums.length;
        long[] result = new long[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[i] == nums[j]) {
                    result[i] += Math.abs(i - j);
                }

            }
        }
        return result;
    }
}
