/*
Class Name  : RectangleArea
Description : This class consists of the solution for RectangleArea.
Date        : Oct 1, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/rectangle-area/

Modification Log: 
Date					Name                                            Description
Oct 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class RectangleArea 
Oct 1, 2022			Chandra Sekhar Reddy Muthumula					Added computeArea 
--------------------------------------------------------------------------------------------------
223. Rectangle Area

Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

Example 1:
Rectangle Area
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45

Example 2:
Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
Output: 16

Constraints:
-104 <= ax1 <= ax2 <= 104
-104 <= ay1 <= ay2 <= 104
-104 <= bx1 <= bx2 <= 104
-104 <= by1 <= by2 <= 104
*/
package Problems.RectangleArea;

public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // // if (ax1 > bx1) computeArea(bx1, by1, bx2, by2, ax1, ay1, ax2, ay2);
        // if ((((bx1 < ax1 && ax1 < bx2) && (bx1 < ax2 && ax2 < bx2) ) && ((by1 < ay1 && ay1 < by2) && (by1 < ay2 && ay2 < by2)))) { // B includes A completely
        //     System.out.println("Only B");
        //     return  Math.abs((bx2 - bx1) * (by2 - by1));
        // } else if((((ax1 < bx1 && bx1 < ax2) && (ax1 < bx2 && bx2 < ax2)) && ((ay1 < by1 && by1 < ay2) && (ay1 < by2 && by2 < ay2)))) { // A included B completely
        //     System.out.println("Only A");
        //     return Math.abs((ax2 - ax1) * (ay2 - ay1));
        // } else if((ax2 <= bx1 || ax1 >= bx2) || (ay2 <= by1 || ay1 >= by2)) {
        //     System.out.println("A + B");
        //     int aArea = (ax2 - ax1) * (ay2 - ay1);
        //     int bArea = (bx2 - bx1) * (by2 - by1);
        //     return Math.abs(Math.abs(aArea) + Math.abs(bArea));
        // } else {
        //     System.out.println("A + B - c");
        //     int aArea = (ax2 - ax1) * (ay2 - ay1);
        //     int bArea = (bx2 - bx1) * (by2 - by1);
        //     int commonArea = (ax2 - bx1) * (by2 - ay1);
        //     return Math.abs(Math.abs(aArea) + Math.abs(bArea) - Math.abs(commonArea ));
        // }
        
        
        int aArea = Math.abs((ax2 - ax1) * (ay2 - ay1));
        int bArea = Math.abs((bx2 - bx1) * (by2 - by1));
        
        int commonArea = 0;
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int bottom = Math.max(ay1, by1);
        int top = Math.min(ay2, by2);
        if (right > left && top > bottom) {
            commonArea = Math.abs((right - left)*(top - bottom));
        }
        return aArea + bArea - commonArea;
    }
}
