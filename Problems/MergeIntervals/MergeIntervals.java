/*
Class Name  : MergeIntervals
Description : This class consists of the solution for MergeIntervals.
Created Date: Mar 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/merge-intervals/description/
Modification Log: 
Date					    Name                                            Description
Mar  5, 2022			    Chandra Sekhar Reddy Muthumula					Added Class MergeIntervals
Mar  5, 2022			    Chandra Sekhar Reddy Muthumula					Added merge 
--------------------------------------------------------------------------------------------------
56. Merge Intervals
Medium
18.2K
622
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
------------------------------------------------------------------------------------------------------
*/
package Problems.MergeIntervals;
import java.util.*;
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] interval : intervals) {
            if(list.size() == 0) {
                list.add(interval);
            } else {
                int[] lastInterval = list.get(list.size() - 1);
                if(lastInterval[1] < interval[0]) {
                    // Not overlapping
                    list.add(interval);
                } else {
                    list.remove(list.size() - 1);
                    list.add(new int[] {Math.min(lastInterval[0], interval[0]), Math.max(lastInterval[1], interval[1])});
                }
            }
        }
        int[][] finalIntervals = new int[list.size()][];
        int index = 0;
        for(int[] interval : list) {
            finalIntervals[index++] = interval;
        }
        return finalIntervals;
    }
}