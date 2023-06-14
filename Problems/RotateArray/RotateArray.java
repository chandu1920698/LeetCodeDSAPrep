/*
Class Name  : RotateArray
Description : This class consists of the solution for RotateArray.
Date        : Sep 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/rotate-array/submissions/

Modification Log: 
Date					Name                                            Description
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class RotateArray 
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added rotate 
Jun 15, 2023			Chandra Sekhar Reddy Muthumula					Added rotateSwap
Jun 15, 2023			Chandra Sekhar Reddy Muthumula					Added swap 
--------------------------------------------------------------------------------------------------
189. Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 1^05
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
-------------------------------------------------------------------------------------------
*/

class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        
        // Method 1: Brute Force
        /*
        TC : O(N*K)
        SC : O(1)
        */
        // System.out.println("len : " + len + " k : " + k );
        // while(k > 0) {
        //     int lastElement = nums[len-1];
        //     for (int i=len-1; i>0; i--) {
        //         nums[i] = nums[i-1];
        //     }
        //     nums[0] = lastElement;
        //     k--;
        // }
        if (len != 1) {
            // Method 2 : Normal approach
            /*
            TC : O(N + K)
            SC : O(K%N)
            */
            k = k % len; 
            // int[] lastElementsStoring = new int[k];
            // int index = 0;
            // for (int i=len-k; i<len; i++) {
            //     lastElementsStoring[index] = nums[i];
            //     index++;
            // }
            // for (int i=len-1-k; i>=0; i--) {
            //     nums[i+k] = nums[i];
            // }
            // for (int i=0; i<k; i++) {
            //     nums[i] = lastElementsStoring[i];
            // }
            
            
            // Method 3 : Reverse Array approach
            /*
            TC : O(N)
            SC : O(1)
            */
            
            for (int i=0; i<len/2; i++) {
                int temp = nums[i];
                nums[i] = nums[len-1-i];
                nums[len-1-i] = temp;
            }
            // System.out.println("Reversed Array : " + Arrays.toString(nums));
            for (int i=0; i<k/2; i++) {
                int temp = nums[i];
                nums[i] = nums[k-1-i];
                nums[k-1-i] = temp;
            }
            // System.out.println("Reversed first K : " + Arrays.toString(nums));
            for (int i=k; i<(len+k)/2; i++) {
                int temp = nums[i];
                nums[i] = nums[len-1-i+k];
                nums[len-1-i+k] = temp;
            }
            // System.out.println("Reversed last Len - k : " + Arrays.toString(nums));
        } 
    }
    public void rotateSwap(int[] nums, int k) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int len = nums.length;
        k %= len;
        if(k == 0) {
            return;
        } 
        swap(nums, 0, len - 1, len);
        swap(nums, 0, k - 1, k);
        swap(nums, k, len - 1, len - k);
    }

    private void swap(int[] nums, int start, int end, int k) {
        /* 
         * TC : O(End - Start) = O(N)
         * SC : O(1)
        */
        while(start < end && k > 0) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            // int temp = nums[start];
            // nums[start] = nums[end];
            // nums[end] = temp;
            // System.out.println("Swap : " + Arrays.toString(nums));
            start++; end--;
            k--;
        }
    }
}  