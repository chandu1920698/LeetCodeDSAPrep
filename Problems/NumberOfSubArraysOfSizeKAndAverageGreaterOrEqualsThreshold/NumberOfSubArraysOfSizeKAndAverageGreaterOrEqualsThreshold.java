/*
Class Name  : NumberOfSubArraysOfSizeKAndAverageGreaterOrEqualsThreshold
Description : This class consists of the solution for NumberOfSubArraysOfSizeKAndAverageGreaterOrEqualsThreshold.
Created Date: Feb 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
Modification Log: 
Date					    Name                                            Description
Feb 26, 2022			    Chandra Sekhar Reddy Muthumula					Added Class NumberOfSubArraysOfSizeKAndAverageGreaterOrEqualsThreshold 
Feb 26, 2022			    Chandra Sekhar Reddy Muthumula					Added numOfSubarrays
--------------------------------------------------------------------------------------------------
1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
Medium
1K
77
Companies
Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.

 

Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
Example 2:

Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 

Constraints:

1 <= arr.length <= 105
1 <= arr[i] <= 104
1 <= k <= arr.length
0 <= threshold <= 104
------------------------------------------------------------------------------------------------------
*/
package Problems.NumberOfSubArraysOfSizeKAndAverageGreaterOrEqualsThreshold;

public class NumberOfSubArraysOfSizeKAndAverageGreaterOrEqualsThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int subArrayCount = 0;
        int len = arr.length;
        int start = 0;
        int end = k - 1;
        double totalSum = 0.0;
        for(int i = 0; i < k; i++) {
            totalSum += arr[i];
        }
        while(end < len) {
            
            if(totalSum >= threshold * k) {
                subArrayCount++;
            }
            end++;
            
            if(end < len) {
                totalSum -= arr[start];
                totalSum += arr[end];
                
            }
            start++;
            
        }
        return subArrayCount;
    }
}