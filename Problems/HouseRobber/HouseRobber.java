/*
Class Name  : HouseRobber
Description : This class consists of the solution for HouseRobber.
Created Date: Dec 31, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/house-robber/description/

Modification Log: 
Date					Name                                            Description
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class HouseRobber 
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added robRecursion 
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added robRecursionHelper 
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added robTopDownMemoization 
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added robTopDownMemoizationHelper 
Dec 31, 2022			Chandra Sekhar Reddy Muthumula					Added robOptimized 
--------------------------------------------------------------------------------------------------
198. House Robber
Medium
16.4K
324
Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
-------------------------------------------------------------------------------------------
*/
package Problems.HouseRobber;
import java.util.*;
public class HouseRobber {
    public int robRecursion(int[] nums) {
        /* 
         * TC : O(N ^2)
         * SC : O(1)
        */
        int len = nums.length;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return robRecursionHelper(nums, len - 1, dp);
    }
    public int robRecursionHelper(int[] nums, int n, int[] dp) {
        if(n < 0) return 0;
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[1], nums[0]);
        if(dp[n] != -1) return dp[n];
        dp[n] = Math.max(nums[n] +  robRecursionHelper(nums, n-2 ,dp),robRecursionHelper(nums, n - 1, dp) );
        return dp[n];
    }

    public int robTopDownMemoization(int[] nums) {
        /* 
         * TC : O(N ^ 2)
         * SC : O(N)
        */
        int len = nums.length;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        return robTopDownMemoizationHelper(nums, len - 1, dp);
    }
    public int robTopDownMemoizationHelper(int[] nums, int n, int[] dp) {
        if(n < 0) return 0;
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[1], nums[0]);
        if(dp[n] != -1) return dp[n];
        dp[n] = Math.max(nums[n] +  robTopDownMemoizationHelper(nums, n-2 ,dp),robTopDownMemoizationHelper(nums, n - 1, dp) );
        return dp[n];
    }
    

    public int robOptimized(int[] nums) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int rob1 = 0, rob2 = 0;
        for(int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}