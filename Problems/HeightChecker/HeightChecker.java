/*
Class Name  : HeightChecker
Description : This class consists of the solution for HeightChecker.
Created Date: Dec 20, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/height-checker/description/
Modification Log: 
Date					Name                                            Description
Dec 20, 2022			Chandra Sekhar Reddy Muthumula					Added Class HeightChecker 
Dec 20, 2022			Chandra Sekhar Reddy Muthumula					Added heightChecker
--------------------------------------------------------------------------------------------------
1051. Height Checker
Easy
743
62
Companies
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

 

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
Example 2:

Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
Example 3:

Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
 

Constraints:

1 <= heights.length <= 100
1 <= heights[i] <= 100
------------------------------------------------------------------------------------------------------
*/
package Problems.HeightChecker;

import java.util.*;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        /*
         * TC : O(NLogN) + O(N)
         * SC : O(N)
         */
        int len = heights.length;
        if (len == 0 || len == 1)
            return 0;

        int[] newHeights = Arrays.copyOfRange(heights, 0, len);
        Arrays.sort(newHeights);
        int unmatchedHeights = 0;
        for (int i = 0; i < len; i++) {
            if (heights[i] != newHeights[i]) {
                unmatchedHeights++;
            }
        }
        return unmatchedHeights;
    }
}
