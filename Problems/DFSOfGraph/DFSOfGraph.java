/*
Class Name  : DFSOfGraph
Description : This class consists of the solution for DFSOfGraph.
Created Date: Feb 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
Modification Log: 
Date					    Name                                            Description
Feb 14, 2022			    Chandra Sekhar Reddy Muthumula					Added Class DFSOfGraph 
Feb 14, 2022			    Chandra Sekhar Reddy Muthumula					Added dfsOfGraph
--------------------------------------------------------------------------------------------------
DFS of Graph
EasyAccuracy: 63.07%Submissions: 147K+Points: 2
Lamp
Don't Let the Fear of Missing Out Hold You Back from a Lucrative Career in Data Science. Try this course!

You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use a recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


Example 1:

Input: V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]

Output: 0 2 4 3 1
Explanation: 
0 is connected to 2, 3, 1.
1 is connected to 0.
2 is connected to 0 and 4.
3 is connected to 0.
4 is connected to 2.
so starting from 0, it will go to 2 then 4,
and then 3 and 1.
Thus dfs will be 0 2 4 3 1.
Example 2:

Input: V = 4, adj = [[1,3], [2,0], [1], [0]]

Output: 0 1 2 3
Explanation:
0 is connected to 1 , 3.
1 is connected to 0, 2. 
2 is connected to 1.
3 is connected to 0. 
so starting from 0, it will go to 1 then 2
then back to 0 then 0 to 3
thus dfs will be 0 1 2 3. 

Your task:
You don't need to read input or print anything. Your task is to complete the function dfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a list containing the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
------------------------------------------------------------------------------------------------------
*/

package Problems.DFSOfGraph;
import java.util.*;
public class DFSOfGraph {
    /*
     * TC : O(N) + O(2 * E)
     * SC : O(N) + O(N) + O(N)
    */
    ArrayList<Integer> dfsList;
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        dfsList = new ArrayList<Integer>();
        // for(ArrayList<Integer>  neighbours : adj) {
        //     System.out.println(Arrays.toString(neighbours.toArray()));
        // }
        int[] visited = new int[V];
        visited[0]++;
        dfs(0, visited, adj);
        return dfsList;
    }
    
    private void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> neighbours = adj.get(node);
        dfsList.add(node);
        for(Integer neighbour : neighbours) {
            if(visited[neighbour] == 0) {
                visited[neighbour]++;
                dfs(neighbour, visited, adj);
            }
        }
        return;
    }
}