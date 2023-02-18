/*
Class Name  : NumberOfProvinces
Description : This class consists of the solution for NumberOfProvinces.
Created Date: Feb 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/number-of-provinces/description/
Modification Log: 
Date					    Name                                            Description
Feb 18, 2022			    Chandra Sekhar Reddy Muthumula					Added Class NumberOfProvinces 
Feb 18, 2022			    Chandra Sekhar Reddy Muthumula					Added dfsOfGraph
--------------------------------------------------------------------------------------------------
547. Number of Provinces
Medium
7.1K
282
Companies
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
------------------------------------------------------------------------------------------------------
*/

package Problems.NumberOfProvinces;
import java.util.*;
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        /* 
         * TC : O(N) + O(N + 2E)
         * SC : O(N) + O(N)
        */
        int len = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }                
            }
        }
        // for(List<Integer> list : adjList) {
        //     System.out.println(Arrays.toString(list.toArray()));
        // }

        int[] visited = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(visited[i] == 0) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }

    private static void dfs(int node, List<List<Integer>> adjList, int[] visited) {
        visited[node] = 1;
        for(Integer num : adjList.get(node)) {
            if(visited[num] == 0) {
                dfs(num, adjList, visited);
            }
        }
    }
}