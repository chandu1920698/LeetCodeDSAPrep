/*
Class Name  : RunningSumOf1dArray
Description : This class consists of the solution for RunningSumOf1dArray.
Date        : Sep 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/running-sum-of-1d-array/

Modification Log: 
Date					Name                                            Description
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added Class RunningSumOf1dArray 
Sep 11, 2022			Chandra Sekhar Reddy Muthumula					Added runningSum 
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added findMaxMinOfArray
--------------------------------------------------------------------------------------------------

QUESTION : Running Sum of 1d Array

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

 
Example 1:
Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Example 2:
Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

Example 3:
Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
 

Constraints:
1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6
--------------------------------------------------------------------------------------------------
*/

class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
		// Solved this in two ways
        int arrayLength = nums.length;
		int [] maxMin = findMaxMinOfArray(nums);
        long minValue = Math.round((-1*Math.pow(10,6)));
        long maxValue = Math.round(Math.pow(10,6));
        if (1 <= arrayLength && arrayLength <= 1000 && maxMin[0] <= maxValue && maxMin[1] >= minValue ) {
			/*
			-> Approach 1	
			TC 			: O(N^2)
			SC 			: O(1)
			Runtime		: 1 ms, faster than 23.30% of Java online submissions for Running Sum of 1d Array.
			Memory Usage: 42.8 MB, less than 82.01% of Java online submissions for Running Sum of 1d Array.
			Recommended : NO
			*/
			
			/*
            for (int i = arrayLength-1; i>=0; i--) {
                int tempSum = 0;
                for (int j=i; j>=0; j--) {
                    if ( minValue <=  nums[j] && nums[j] <=maxValue) {
                        tempSum += nums[j];
                    }
                }
                nums[i] = tempSum;
            }
			*/
            /*
			-> Approach 2	
			TC 			: O(N)
			SC 			: O(1)
			Runtime		: 4 ms, faster than 6.06% of Java online submissions for Running Sum of 1d Array.
			Memory Usage: 43 MB, less than 77.02% of Java online submissions for Running Sum of 1d Array.
			Recommended : Yes
			*/
            int tempSum = 0;
            for (int i=0; i<arrayLength; i++) {
				   tempSum += nums[i];
				   nums[i] = tempSum;
            }
        }
        return nums;
    }
	
	public int[] findMaxMinOfArray (int [] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        return new int [] {max, min};
    }
}