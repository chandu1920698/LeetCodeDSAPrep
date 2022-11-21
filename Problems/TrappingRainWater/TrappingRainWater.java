/*
Class Name  : TrappingRainWater
Description : This class consists of the solution for TrappingRainWater.
Date        : Nov 21, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/trapping-rain-water/description/

Modification Log: 
Date				    Name                                            Description
Nov 21, 2022			Chandra Sekhar Reddy Muthumula					Added Class TrappingRainWater 
Nov 21, 2022			Chandra Sekhar Reddy Muthumula					Added trapAverageEfficientApproach
Nov 21, 2022			Chandra Sekhar Reddy Muthumula					Added trapMostEfficient
Nov 21, 2022			Chandra Sekhar Reddy Muthumula					Added trapLeastEfficient
--------------------------------------------------------------------------------------------------
42. Trapping Rain Water
Hard
23.9K
332
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
-------------------------------------------------------------------------------------------
*/
package Problems.TrappingRainWater;

public class TrappingRainWater {
    public int trapMostEfficient(int[] height) {
        /*
         * TC : O(N)
         * SC : O(1)
        */
        int len = height.length;
        if (len <= 2) return 0;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int waterStored = 0;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (leftMax <= rightMax) {
                left++; 
                leftMax = Math.max(height[left], leftMax);
                if (leftMax - height[left] > 0) {
                    waterStored += leftMax - height[left];
                }
                
            }  else {
                right--;
                rightMax = Math.max(height[right], rightMax);
                if (rightMax - height[right] > 0) {
                    waterStored += rightMax - height[right];
                }
                
            }
        }
        return waterStored;
    }

    public int trapAverageEfficientApproach(int[] height) {
        /*
         * TC : O(N)
         * SC : O(1)
        */
        int len = height.length;
        if (len <= 2) return 0;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int waterStored = 0;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (leftMax <= height[left]) {
                leftMax = height[left];
            }

            if (rightMax <= height[right]) {
                rightMax = height[right];
            }
            if (leftMax <= rightMax) {
                if (leftMax - height[left] > 0) {
                    waterStored += leftMax - height[left];
                }
                left++; 
            }  else {
                if (rightMax - height[right] > 0) {
                    waterStored += rightMax - height[right];
                }
                right--;
            }
        }
        return waterStored;
    }

    public int trapLeastEfficient(int[] height) {
        /*
         * TC : O(N) + O(N)
         * SC : O(N) + O(N)
        */
        int len = height.length;
        if (len <= 2) return 0;
        int[] leftMaxHeightArray = new int[len];
        int[] rightMaxHeightArray = new int[len];
        int leftMax = -1;
        int rightMax = -1;
        for (int i = 0; i < len; i++) {
            if (leftMax < height[i]) {
                leftMax = height[i];
            }

            leftMaxHeightArray[i] = leftMax;

            if (rightMax < height[len - 1 - i]) {
                rightMax = height[len - 1 - i];
                
            }
            rightMaxHeightArray[len - 1 - i] = rightMax;
        }
        // System.out.println("        HeightArray : " + Arrays.toString(height));
        // System.out.println(" leftMaxHeightArray : " + Arrays.toString(leftMaxHeightArray));
        // System.out.println("rightMaxHeightArray : " + Arrays.toString(rightMaxHeightArray));
        int waterStored = 0;
        for (int i = 0; i < len; i++) {
            if (Math.min(leftMaxHeightArray[i], rightMaxHeightArray[i]) - height[i] > 0) {
                waterStored += Math.min(leftMaxHeightArray[i], rightMaxHeightArray[i]) - height[i];
            }
        }
        return waterStored;
    }
}