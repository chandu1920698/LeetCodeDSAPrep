/*
Class Name  : SortColors
Description : This class consists of the solution for SortColors.
Date        : Sep 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/sort-colors/

Modification Log: 
Date					Name                                            Description
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class SortColors 
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added sortColors 
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added swap
--------------------------------------------------------------------------------------------------
75. Sort Colors

Given an array nums with n objects colored red, white, 
or blue, sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 
Follow up: Could you come up with a one-pass algorithm using only constant extra space?
-------------------------------------------------------------------------------------------
*/

class MedianOfTwoSortedArrays {

    /*
    This is a brute force approach
    TC : O(M+N)
    SC : O(M+N)
    */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int m = nums1.length;
    //     int n = nums2.length;
        
    //     if ((m+n) == 1) {
    //         if (m != 0) return (double)nums1[0];
    //         else if (n != 0) return (double)nums2[0];
    //     } else {
    //         int[] mergedArray = new int[m+n];
    //         int index1=0, index2=0;
    //         int i = 0;
    //         for (i=0; i<m+n && index1<m && index2<n; i++) {
    //             if (nums1[index1] < nums2[index2]) {
    //                 mergedArray[i] = nums1[index1++];
    //             } else if (nums1[index1] > nums2[index2]) {
    //                 mergedArray[i] = nums2[index2++];
    //             } else {
    //                 mergedArray[i++] = nums1[index1++];
    //                 mergedArray[i] = nums2[index2++];
    //             }
    //         }
    //         // System.out.println("mergedArray : " + Arrays.toString(mergedArray));
    //         while(index1<m && i < m+n){
    //              mergedArray[i++] = nums1[index1++];
    //         };
    //         // System.out.println("mergedArray : " + Arrays.toString(mergedArray));
    //         while(index2<n && i < m+n){
    //              mergedArray[i++] = nums2[index2++];
    //         };
    //         // System.out.println("mergedArray : " + Arrays.toString(mergedArray));
    //         if ((m+n)%2 == 0) {
    //             // System.out.println("(mergedArray[(int)((m+n)/2)] : " + (mergedArray[(int)((m+n)/2)]));
    //             // System.out.println("mergedArray[(int)((m+n)/2 + 1)] : " + mergedArray[(int)((m+n)/2 + 1)]);
    //             return (double)(mergedArray[(int)((m+n)/2-1)] + mergedArray[(int)((m+n)/2)])/2;
    //         } else {
    //             return (double)(mergedArray[(int)((m+n)/2)]);
    //         }
            
    //     }
    //     return 0.0;
    // }


    /*
    This is a best possible approach
    TC : O(Log(Min(M,N)))
    SC : O(1)
    */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // if (nums2.length < nums1.length)  findMedianSortedArrays(nums2, nums1);
        if (nums2.length < nums1.length) {
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        // System.out.println("m : " + m + " n : " + n);
        
        if ((m+n) == 1) {
            if (m != 0) return nums1[0]/1.0;
            else if (n != 0) return nums2[0]/1.0;
        } else {
            int left = 0;
            int right = m;
            
            while(left <= right) {
                int cut1 = (left+right) >> 1;
                int cut2 = (m+n+1)/2 - cut1;
                // System.out.println("Cut1 : " + cut1 + " Cut2 : " + cut2);
                int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
                int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
                
                int right1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
                int right2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];
                
                if (left1 <= right2 && left2 <= right1) {
                    if((m+n)%2 == 0) {
                        return (Math.max(left1, left2)+Math.min(right1,right2))/2.0;
                    } else {
                        return Math.max(left1, left2);
                    }
                } else if (left1 > right2) {
                    right = cut1 - 1;
                } else {
                    left = cut1 + 1;
                }
            }
        }
        return 0.0;
    }
}