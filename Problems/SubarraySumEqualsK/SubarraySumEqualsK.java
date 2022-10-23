/*
Class Name  : SubarraySumEqualsK
Description : This class consists of the solution for SubarraySumEqualsK.
Date        : Oct 8, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/subarray-sum-equals-k/

Modification Log: 
Date				Name                                            Description
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class SubarraySumEqualsK 
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added subarraySum
--------------------------------------------------------------------------------------------------
560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.


Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
-------------------------------------------------------------------------------------------
*/
package Problems.SubarraySumEqualsK;
import java.util.*;;
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // Lets try Brute force
        // This is throwing the time limit exceed error
        // int len = nums.length;
        // int count = 0;
        // for(int i=0; i<len; i++) {
        //     int sum = 0;
        //     for (int j=i; j<len; j++) {
        //         sum += nums[j];
        //         if(sum == k) count++;
        //     }
        // }
        // return count;
        
        int n = nums.length,ct=0;
        int[] prefixSum = new int[n+1];
        HashMap<Integer,Integer> sum = new HashMap<>();
        prefixSum[0]=0;sum.put(0,1);
        for(int i=1;i<=n;i++){
            prefixSum[i] =  prefixSum[i-1]+nums[i-1];
        }
        for(int i=1;i<=n;i++){
            if(sum.containsKey(prefixSum[i]-k)) ct+=sum.get(prefixSum[i]-k);
            sum.put(prefixSum[i],sum.getOrDefault(prefixSum[i],0)+1);
            // System.out.println("Map : " + sum);
            // System.out.println("ct : " + ct);
        }
        return ct;
        
    }
}