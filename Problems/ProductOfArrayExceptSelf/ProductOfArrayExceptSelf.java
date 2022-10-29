/*
Class Name  : ProductOfArrayExceptSelf
Description : This class consists of the solution for ProductOfArrayExceptSelf.
Date        : Oct 29, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/product-of-array-except-self/

Modification Log: 
Date					Name                                            Description
Oct 29, 2022			Chandra Sekhar Reddy Muthumula					Added Class ProductOfArrayExceptSelf 
Oct 29, 2022			Chandra Sekhar Reddy Muthumula					Added productExceptSelfBruteForce
Oct 29, 2022			Chandra Sekhar Reddy Muthumula					Added productExceptSelfEfficientMethod
--------------------------------------------------------------------------------------------------
238. Product of Array Except Self

Given an integer array nums, return an array answer 
such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity?
 (The output array does not count as extra space for space complexity analysis.)
-------------------------------------------------------------------------------------------
*/
package Problems.ProductOfArrayExceptSelf;

public interface ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        
    }

    public static int[] productExceptSelfBruteForce(int[] nums) {
        int len = nums.length;
        // This a brute force method
        // TC : O(2 * N)
        // SC : O(2 * N)
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        int left = 1;
        int right = 1;
        
        prefix[0] = left;
        suffix[len - 1] = right;
        
        for (int i = 1; i < len; i++) {
            left *= nums[i - 1];
            prefix[i] = left;
            
            right *= nums[len - 1 - i + 1];
            suffix[len - 1 - i] = right;
        }
        
        int[] result = new int[len];
        
        for (int i = 0; i < len; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }

    public static int[] productExceptSelfEfficientMethod(int[] nums) {
        int len = nums.length;
        // This a brute force method
        // TC : O(2 * N)
        // SC : O(1)
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        int left = 1;
        int right = 1;
        
        prefix[0] = left;
        suffix[len - 1] = right;
        
        int[] result = new int[len];
        result[0] = 1;
        
        for (int i = 1; i < len; i++) {
            left *= nums[i - 1];
            result[i] = left;
        }
        for (int j = len - 2; j >= 0; j--) {
            right *= nums[j + 1];
            result[j] *= right;
        }
        return result;
    }
}