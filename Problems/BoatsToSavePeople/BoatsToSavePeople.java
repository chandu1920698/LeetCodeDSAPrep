/*
Class Name  : BoatsToSavePeople
Description : This class consists of the solution for BoatsToSavePeople.
Created Date: Feb 25, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/boats-to-save-people/description/
Modification Log: 
Date					    Name                                            Description
Feb 25, 2022			    Chandra Sekhar Reddy Muthumula					Added Class BoatsToSavePeople 
Feb 25, 2022			    Chandra Sekhar Reddy Muthumula					Added numRescueBoats
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

package Problems.BoatsToSavePeople;
import java.util.*;
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        /* 
         * TC : O(NLogN) + O(N)
         * SC : O(1)
        */
        int n = people.length;
        if(n == 0) {
            return 0;
        }
        Arrays.sort(people); 
        // System.out.println(Arrays.toString(people)); 
        int boatsRequired = 0;
        int start = 0;
        int end = n - 1; 
        while(start < end) {
            if(people[end] == limit) {
                boatsRequired++;
                end--;
            } else {
                boatsRequired++;
                if(people[end] + people[start] <= limit) {
                    end--;
                    start++;
                } else {
                    end--;
                }
            }
        }
        if(start == end) {
            boatsRequired++;
        }
        return boatsRequired;
    }
}