/*
Class Name  : QueriesOnNumberOfPointsInsideCircle
Description : This class consists of the solution for QueriesOnNumberOfPointsInsideCircle.
Created Date: Feb 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/description/
Modification Log: 
Date					    Name                                            Description
Feb 22, 2022			    Chandra Sekhar Reddy Muthumula					Added Class QueriesOnNumberOfPointsInsideCircle 
Feb 22, 2022			    Chandra Sekhar Reddy Muthumula					Added countPoints
Feb 22, 2022			    Chandra Sekhar Reddy Muthumula					Added countPointsBinarySearch
Feb 22, 2022			    Chandra Sekhar Reddy Muthumula					Added binarySearch
Feb 22, 2022			    Chandra Sekhar Reddy Muthumula					Added sortPointsXAxis
--------------------------------------------------------------------------------------------------
1828. Queries on Number of Points Inside a Circle
Medium
903
71
Companies
You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.

You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

Return an array answer, where answer[j] is the answer to the jth query.

 

Example 1:


Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
Output: [3,2,2]
Explanation: The points and circles are shown above.
queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.
Example 2:


Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
Output: [2,3,2,4]
Explanation: The points and circles are shown above.
queries[0] is green, queries[1] is red, queries[2] is blue, and queries[3] is purple.
 

Constraints:

1 <= points.length <= 500
points[i].length == 2
0 <= x​​​​​​i, y​​​​​​i <= 500
1 <= queries.length <= 500
queries[j].length == 3
0 <= xj, yj <= 500
1 <= rj <= 500
All coordinates are integers.
 

Follow up: Could you find the answer for each query in better complexity than O(n)?


------------------------------------------------------------------------------------------------------
*/

package Problems.QueriesOnNumberOfPointsInsideCircle;
import java.util.*;
public class QueriesOnNumberOfPointsInsideCircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        /* 
         * Brute Force
         * TC : O(N * M)
         * SC : O(1)
        */
        int n = queries.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < points.length; j++) {
                if((queries[i][0] - points[j][0]) * (queries[i][0] - points[j][0]) + (queries[i][1] - points[j][1]) * (queries[i][1] - points[j][1]) <= queries[i][2] * queries[i][2]) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    public int[] countPointsBinarySearch(int[][] points, int[][] queries) {
        /* 
         * Binary Search Approach
         * TC : O(NLogN) -> Sorting Points + O(M * (LogN + N))
         * SC : O(1)
        */
        int n = queries.length;
        int[] result = new int[n];
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++) {
            int xCenter = queries[i][0];
            int yCenter = queries[i][1];
            int radius = queries[i][2];
            int startPoint = binarySearch(points, xCenter, yCenter, radius);
            
            for(int j = startPoint; j >= 0 && xCenter - radius <= points[j][0]; j--) {
                int x = points[j][0];
                int y = points[j][1];
                // System.out.println(j);
                if((xCenter - x) * (xCenter - x) + (yCenter - y) * (yCenter - y) <= radius * radius) {
                    result[i]++;
                }
            }
            // System.out.println("---------------------");
        }
        return result;
    }

    private int binarySearch(int[][] points, int x, int y, int r) {
        int start = 0;
        int end = points.length - 1;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            if(x + r >= points[mid][0]) {
                start = mid + 1;
            } else {
                end = mid - 1; 
            }
        }
        return end;
    }

    private void sortPointsXAxis(int[][] points) {
        int n = points.length;
        for(int i = 0; i < n; i++) {
            int minIndex = i;
            int minXCordinate = points[i][0];
            for(int j = i + 1; j < n; j++) {
                if(minXCordinate > points[j][0]) {
                    minXCordinate = points[j][0];
                    minIndex = j;
                }
            }
            int[] tempCordinates = points[i];
            points[i] = points[minIndex];
            points[minIndex] = tempCordinates; 
        }
    }
}