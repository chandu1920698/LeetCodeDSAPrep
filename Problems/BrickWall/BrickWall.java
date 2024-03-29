/*
Class Name  : BrickWall
Description : This class consists of the solution for BrickWall.
Created Date: Mar 9, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/brick-wall/description/
Modification Log: 
Date					    Name                                            Description
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added Class BrickWall
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added leastBricks 
Mar  9, 2022			    Chandra Sekhar Reddy Muthumula					Added leastBricks2
--------------------------------------------------------------------------------------------------
554. Brick Wall
Medium
2.1K
122
Companies
There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.

Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.

 

Example 1:


Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
Output: 2
Example 2:

Input: wall = [[1],[1],[1]]
Output: 3
 

Constraints:

n == wall.length
1 <= n <= 104
1 <= wall[i].length <= 104
1 <= sum(wall[i].length) <= 2 * 104
sum(wall[i]) is the same for each row i.
1 <= wall[i][j] <= 231 - 1
------------------------------------------------------------------------------------------------------
*/
package Problems.BrickWall;

import java.util.*;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        /* 
         * TC : O(N * N)
         * SC : O(N)
        */
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int brickSum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                brickSum += row.get(i);
                map.put(brickSum, map.getOrDefault(brickSum, 0) + 1);
            }
        }

        int maxfreq = 0;

        for (Integer key : map.keySet()) {
            maxfreq = Math.max(maxfreq, map.get(key));
        }
        return wall.size() - maxfreq;
    }

    public int leastBricks2(List<List<Integer>> wall) {
        int maxfreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall) {
            int brickSum = 0;
            for(int i = 0; i < row.size() - 1; i++) {
                brickSum += row.get(i);
                int tempMax = map.getOrDefault(brickSum, 0) + 1;
                map.put(brickSum, tempMax);
                maxfreq = Math.max(maxfreq, tempMax);
            }
        }
        return wall.size() - maxfreq;
    }
}