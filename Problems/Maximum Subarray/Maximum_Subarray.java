/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
//         int max = nums[0];
//         int arrayLength = nums.length;
//         if ((1 <= arrayLength) && (arrayLength <= Math.pow(10,5))) {
//             for(int i = 0; i < arrayLength; i++) {
//                 if ((-1 * Math.pow(10,4) <= nums[i]) && ( nums[i] <= Math.pow(10,4))) {
//                      int sum = 0;
//                     for (int j = i; j < arrayLength; j++) {
//                         sum = sum + nums[j];
//                         if(max < sum) {
//                             max = sum;
//                         } else if((j == arrayLength - 1) && (i + 1 < arrayLength - 1) && (max < nums[i + 1])) {
//                              max = nums[i+1];
//                         }
//                         //System.out.println("i ->" + i + " j ->" + j + " Sum ->" + sum + "   Max ->  " + max);
//                     }
//                 }
//             }
//         }
        
//         return max;
        
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);	
        }
        return maxSoFar;
    }

    // Using the prefix sum approach
    /*
     * TC : O(N)
     * SC : O(1)
    */
    int len = nums.length;
    int currentSum = 0;
    int max = Integer.MIN_VALUE;
    // Not initialized max with 0 as, we should not consider the empty subsets
    for(int i=0; i<len; i++) {
        currentSum += nums[i];
        max = Math.max(max, currentSum);
        if(currentSum < 0) currentSum = 0; 
    }
    return max;
}