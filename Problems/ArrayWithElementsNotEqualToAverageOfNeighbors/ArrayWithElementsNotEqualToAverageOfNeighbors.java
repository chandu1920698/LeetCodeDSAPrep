/*
Class Name  : ArrayWithElementsNotEqualToAverageOfNeighbors
Description : This class consists of the solution for ArrayWithElementsNotEqualToAverageOfNeighbors.
Created Date: Feb 25, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/description/
Modification Log: 
Date					    Name                                            Description
Feb 25, 2022			    Chandra Sekhar Reddy Muthumula					Added Class ArrayWithElementsNotEqualToAverageOfNeighbors 
Feb 25, 2022			    Chandra Sekhar Reddy Muthumula					Added rearrangeArray
--------------------------------------------------------------------------------------------------
881. Boats to Save People
Medium
3.6K
98
Companies
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
------------------------------------------------------------------------------------------------------
*/

package Problems.ArrayWithElementsNotEqualToAverageOfNeighbors;
import java.util.*;
public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    public int[] rearrangeArray(int[] nums) {
        /* 
         * TC : O(NLogN)
         * SC : O(1)
        */
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 1; i += 2) {
           int temp = nums[i];
           nums[i] = nums[i + 1];
           nums[i + 1] = temp;
        }
        return nums;
    }
}