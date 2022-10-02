/*
Class Name  : WiggleSort
Description : This class consists of the solution for WiggleSort.
Date        : Oct 2, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.lintcode.com/problem/508/description
Modification Log: 
Date					Name                                            Description
Oct 2, 2022			Chandra Sekhar Reddy Muthumula					Added Class WiggleSort 
Oct 2, 2022			Chandra Sekhar Reddy Muthumula					Added wiggleSort 
--------------------------------------------------------------------------------------------------
508 · Wiggle Sort
Given an unsorted array nums, reorder it in-place such that

nums[0] <= nums[1] >= nums[2] <= nums[3]....
Contact me on wechat to get Amazon、Google requent Interview questions . (wechat id : jiuzhang0607)
Please sort the array in place and do not define additional arrays.

Example
Example 1:
Input: [3, 5, 2, 1, 6, 4]
Output: [1, 6, 2, 5, 3, 4]
Explanation: This question may have multiple answers, and [2, 6, 1, 5, 3, 4] is also ok.

Example 2:
Input: [1, 2, 3, 4]
Output: [1, 4, 2, 3]0
------------------------------------------------------------------------------------------------------
*/
package Problems.WiggleSort;
import java.util.*;
public class WiggleSort {
    /**
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        int len = nums.length;

        // With sorting
        /*
        * TC : O(N/2) + O(LogN)
        * SC : O(1)
        */
        // Arrays.sort(nums);
        // for (int i = 1; i < len-1; i += 2) {
        //     if(nums[i] < nums[i+1]) {
        //         int temp = nums[i];
        //         nums[i] = nums[i+1];
        //         nums[i+1] = temp;
        //     }
        // }

        // With out sorting
        /*
        * TC : O(N)
        * SC : O(1)
        */
        for (int i = 1; i < len-1; i++) {
            if( i%2 == 0 && nums[i] > nums[i-1]) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            } else if (i%2 == 1 && nums[i] < nums[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
    }
}


