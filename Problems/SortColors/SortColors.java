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

class SortColors {
    // public void sortColors(int[] nums) {
    //     int len = nums.length;
    //     HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    //     // map.put(0,0);
    //     map.put(1,0);
    //     map.put(2,0);
    //     for (int i=0; i<len; i++) {
    //         if (nums[i] != 0) map.put(nums[i], (int)map.get(nums[i])+1);
    //     }
    //     int noOfTwos = map.get(2);
    //     int noOfOnes = map.get(1);
    //     // System.out.println(map);
    //     for (int i=len-1; i>=0 && noOfTwos>0;i--) {
    //         nums[i] = 2;
    //         noOfTwos--;
    //     }
    //     // System.out.println("nums : " + Arrays.toString(nums));
    //     for (int i=len-1-map.get(2); i>=0 && noOfOnes>0;i--) {
    //         nums[i] = 1;noOfOnes--;
    //     }
    //     // System.out.println("nums : " + Arrays.toString(nums));
    //     for (int i=len-1-map.get(2)-map.get(1); i>=0;i--) {
    //         nums[i] = 0;
    //     }
    //     // System.out.println("nums : " + Arrays.toString(nums));
    // }
        
    public void sortColors(int[] nums) {
        int zeroIndex = 0, twoIndex = nums.length - 1, i = 0;
        while( i <= twoIndex ) {
            if( nums[i] == 0 ) 
                swap(nums, zeroIndex++, i++);
            else if( nums[i] == 2)
                swap(nums, twoIndex--, i);    
            else
                i++;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}