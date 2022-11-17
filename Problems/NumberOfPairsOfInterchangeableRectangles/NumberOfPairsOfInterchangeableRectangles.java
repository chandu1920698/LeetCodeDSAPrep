/*
Class Name  : NumberOfPairsOfInterchangeableRectangles
Description : This class consists of the solution for NumberOfPairsOfInterchangeableRectangles.
Date        : Nov 17, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/description/

Modification Log: 
Date				    Name                                            Description
Nov 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class NumberOfPairsOfInterchangeableRectangles 
Nov 17, 2022			Chandra Sekhar Reddy Muthumula					Added interchangeableRectangles
--------------------------------------------------------------------------------------------------
2001. Number of Pairs of Interchangeable Rectangles
Medium
296
26
Companies
You are given n rectangles represented by a 0-indexed 2D integer array rectangles, where rectangles[i] = [widthi, heighti] denotes the width and height of the ith rectangle.

Two rectangles i and j (i < j) are considered interchangeable if they have the same width-to-height ratio. More formally, two rectangles are interchangeable if widthi/heighti == widthj/heightj (using decimal division, not integer division).

Return the number of pairs of interchangeable rectangles in rectangles.

 

Example 1:

Input: rectangles = [[4,8],[3,6],[10,20],[15,30]]
Output: 6
Explanation: The following are the interchangeable pairs of rectangles by index (0-indexed):
- Rectangle 0 with rectangle 1: 4/8 == 3/6.
- Rectangle 0 with rectangle 2: 4/8 == 10/20.
- Rectangle 0 with rectangle 3: 4/8 == 15/30.
- Rectangle 1 with rectangle 2: 3/6 == 10/20.
- Rectangle 1 with rectangle 3: 3/6 == 15/30.
- Rectangle 2 with rectangle 3: 10/20 == 15/30.
Example 2:

Input: rectangles = [[4,5],[7,8]]
Output: 0
Explanation: There are no interchangeable pairs of rectangles.
 

Constraints:

n == rectangles.length
1 <= n <= 105
rectangles[i].length == 2
1 <= widthi, heighti <= 105
-------------------------------------------------------------------------------------------
*/
package Problems.NumberOfPairsOfInterchangeableRectangles;
import java.util.*;
public class NumberOfPairsOfInterchangeableRectangles {
    
    public long interchangeableRectangles(int[][] rectangles) {
        /*
         * TC : O(N)
         * SC : O(N)
        */
        int ratio_len = rectangles.length;
        HashMap<Double, Integer> ratio_map = new HashMap<Double, Integer>();
        for (int i = 0; i < ratio_len; i++) {
            double ratio = (double)rectangles[i][0]/rectangles[i][1];
            ratio_map.put(ratio, ratio_map.getOrDefault(ratio, 0) + 1);
        }
        // System.out.println("Array : " + Arrays.toString(ratio_array));
        long count = 0;
        for (Double ratio_item : ratio_map.keySet()) {
            long freq = ratio_map.get(ratio_item);
            count += (freq * (freq - 1))/2;
        }
        return count;
    }
}