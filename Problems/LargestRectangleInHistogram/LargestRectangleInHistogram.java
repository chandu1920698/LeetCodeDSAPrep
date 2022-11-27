/*
Class Name  : LargestRectangleInHistogram
Description : This class consists of the solution for LargestRectangleInHistogram.
Date        : Nov 27, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/largest-rectangle-in-histogram/description/

Modification Log: 
Date				    Name                                            Description
Nov 27, 2022			Chandra Sekhar Reddy Muthumula					Added Class LargestRectangleInHistogram
Nov 27, 2022			Chandra Sekhar Reddy Muthumula					Added largestRectangleAreaBestApproach
Nov 27, 2022			Chandra Sekhar Reddy Muthumula					Added largestRectangleArea
--------------------------------------------------------------------------------------------------
84. Largest Rectangle in Histogram
Hard
12.7K
179
Companies
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.


Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
-------------------------------------------------------------------------------------------
*/

package Problems.LargestRectangleInHistogram;

import java.util.*;
import javafx.util.Pair;

public class LargestRectangleInHistogram {

    public int largestRectangleAreaBestApproach(int[] h) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        int n = h.length;
        int max = 0;
        int[] stack = new int[n + 1];
        int is = -1;
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : h[i];
            while (is != -1 && height < h[stack[is]]) {
                int hh = h[stack[is--]];
                int width = (is == -1) ? i : i - 1 - stack[is];
                max = Math.max(max, hh * width);
            }
            stack[++is] = i;
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        int len = heights.length;
        if (len == 1)
            return heights[0];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        long maxArea = -1;
        for (int i = 0; i < len; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
                Pair<Integer, Integer> prevValue = stack.pop();
                maxArea = Math.max(maxArea, (i - prevValue.getKey()) * prevValue.getValue());
                start = prevValue.getKey();
                ;
            }
            stack.push(new Pair(start, heights[i]));
        }
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            maxArea = Math.max(maxArea, pair.getValue() * (len - pair.getKey()));
        }
        return (int) maxArea;
    }
}

