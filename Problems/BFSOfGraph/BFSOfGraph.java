/*
Class Name  : BFSOfGraph
Description : This class consists of the solution for BFSOfGraph.
Created Date: Feb 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
Modification Log: 
Date					    Name                                            Description
Feb 14, 2022			    Chandra Sekhar Reddy Muthumula					Added Class BFSOfGraph 
Feb 14, 2022			    Chandra Sekhar Reddy Muthumula					Added bfsOfGraph
--------------------------------------------------------------------------------------------------
BFS of graph
EasyAccuracy: 44.09%
Submissions: 227K+
Points: 2
Lamp
Don't Let the Fear of Missing Out Hold You Back from a Lucrative Career in Data Science. Try this course!

Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.


Example 1:

Input:

Output: 0 1 2 3 4
Explanation: 
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3.After this 2 to 4, thus bfs will be
0 1 2 3 4.
Example 2:

Input:

Output: 0 1 2
Explanation:
0 is connected to 1 , 2.
so starting from 0, it will go to 1 then 2,
thus bfs will be 0 1 2. 

Your task:
You dont need to read input or print anything. Your task is to complete the function bfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns  a list containing the BFS traversal of the graph starting from the 0th vertex from left to right.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
------------------------------------------------------------------------------------------------------
*/

package Problems.BFSOfGraph;
import java.util.*;
public class BFSOfGraph {

    /* 
     * TC : O(N) + O(2 * E)
     * SC : O(N)
    */
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsList = new ArrayList<Integer>();
        // for(ArrayList<Integer> neighbours : adj) {
        //     System.out.println(Arrays.toString(neighbours.toArray()));
        // }
        // Zero based array
        int[] visited = new int[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offerFirst(0);
        visited[0]++;
        while(!queue.isEmpty()) {
            Integer node = queue.pollLast();
            List<Integer> neighbours = adj.get(node);
            bfsList.add(node);
            // neighbours => {1, 2, 3}
            for(Integer nodeVal : neighbours) {
                if(visited[nodeVal] != 1) {
                    visited[nodeVal]++;
                    queue.offerFirst(nodeVal);
                }
            }
        }
        return bfsList;
    }
}