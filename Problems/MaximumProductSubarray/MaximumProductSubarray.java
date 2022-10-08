/*
Class Name  : MaximumProductSubarray
Description : This class consists of the solution for MaximumProductSubarray.
Date        : Oct 8, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/maximum-product-subarray/

Modification Log: 
Date				Name                                            Description
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class MaximumProductSubarray 
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added maxProduct
--------------------------------------------------------------------------------------------------
152. Maximum Product Subarray

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, 
and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.


Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
-------------------------------------------------------------------------------------------
*/
package Problems.MaximumProductSubarray;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        // This is simple PrefixProduct Method
        /*
         * TC : O(N) + O(N)
         * SC : O(1)
        */
        int len = nums.length;
        
        int currProd = 1;
        int maxProd = Integer.MIN_VALUE;
        
        for(int i=0; i<len; i++) {
            currProd *= nums[i];
            maxProd = Math.max(maxProd, currProd);
            if(currProd == 0) currProd = 1;
            // System.out.println("Current : " +currProd + " Max : " + maxProd);
        }
        currProd = 1;
        for(int i=len-1; i>0; i--) {
            currProd *= nums[i];
            maxProd = Math.max(maxProd, currProd);
            if(currProd == 0) currProd = 1;
            // System.out.println("Current : " +currProd + " Max : " + maxProd);
        }
        
        return maxProd;
    }

    public int maxProduct(int[] nums) {

        // This is simple PrefixProduct Method
        /*
         * TC : O(N)
         * SC : O(1)
        */
        int len = nums.length;
        
        int currProd1 = 1;
        int currProd2 = 1;
        int maxProd1 = Integer.MIN_VALUE;
        int maxProd2 = Integer.MIN_VALUE;
        
        for(int i=0; i<len; i++) {
            currProd1 *= nums[i];
            currProd2 *= nums[len-1-i];
            maxProd1 = Math.max(maxProd1, currProd1);
            maxProd2 = Math.max(maxProd2, currProd2);
            if(currProd1 == 0) currProd1 = 1;
            if(currProd2 == 0) currProd2 = 1;
            // System.out.println("Current : " +currProd + " Max : " + maxProd);
        }
        
        return (int)Math.max(maxProd1, maxProd2);
    }
}