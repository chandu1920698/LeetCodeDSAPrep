/*
Class Name  : CourseSchedule2
Description : This class consists of the solution for CourseSchedule2.
Created Date: Feb 24, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/course-schedule-ii/description/
Modification Log: 
Date					    Name                                            Description
Feb 24, 2022			    Chandra Sekhar Reddy Muthumula					Added Class CourseSchedule2 
Feb 24, 2022			    Chandra Sekhar Reddy Muthumula					Added findOrder
Feb 24, 2022			    Chandra Sekhar Reddy Muthumula					Added fillOcean
--------------------------------------------------------------------------------------------------
210. Course Schedule II
Medium
8.7K
289
Companies
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
------------------------------------------------------------------------------------------------------
*/

package Problems.CourseSchedule2;
import java.util.*;
public class CourseSchedule2 {
    /* 
     * TC : O(V + E)
     * SC : O(V + E)
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // for(List<Integer> l : adjList) {
        //     System.out.println(Arrays.toString(l.toArray()));
        // }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int num : adjList.get(i)) {
                indegree[num]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offerFirst(i);
            }
        }
        // System.out.println(Arrays.toString(queue.toArray()));
        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.pollLast();
            topo.add(node);
            for(int num : adjList.get(node)) {
                indegree[num]--;
                if(indegree[num] == 0) {
                    queue.offerFirst(num);
                }
            }
        }
        int[] result = new int[numCourses];
        if(topo.size() == numCourses) {
            int index = 0;
            for(int num : topo) {
                result[index++] = num;
            }
            return result;
        }
        return new int[] {};
    }
}