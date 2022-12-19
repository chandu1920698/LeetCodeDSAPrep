/*
Class Name  : CheckIfItIsAStraightLine
Description : This class consists of the solution for CheckIfItIsAStraightLine.
Created Date: Dec 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
Modification Log: 
Date					Name                                            Description
Dec 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class CheckIfItIsAStraightLine 
Dec 19, 2022			Chandra Sekhar Reddy Muthumula					Added checkStraightLine
--------------------------------------------------------------------------------------------------
1232. Check If It Is a Straight Line
Easy
1.2K
170
Companies
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
------------------------------------------------------------------------------------------------------
*/
package Problems.CheckIfItIsAStraightLine;

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int noOfCordinates = coordinates.length;
        //  Minimum 2 cordinates are needed to form a straight line;
        if (noOfCordinates < 2) return false;
        // Make the line equation
        int x1 = coordinates[0][0], y1 = coordinates[0][1], x2 = coordinates[1][0], y2 = coordinates[1][1];
        for (int i = 2; i < noOfCordinates; i++) {
            if ((coordinates[i][1] - y1) * (x2 - x1) != (y2 - y1) * (coordinates[i][0] - x1)) {
                return false;
            }
        }
        return true;
    }
}