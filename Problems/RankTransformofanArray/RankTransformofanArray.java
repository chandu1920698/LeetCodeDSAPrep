/*
Class Name  : RankTransformofanArray
Description : This class consists of the solution for RankTransformofanArray.
Created Date: Dec 20, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/rank-transform-of-an-array/description/
Modification Log: 
Date					Name                                            Description
Dec 20, 2022			Chandra Sekhar Reddy Muthumula					Added Class RankTransformofanArray 
Dec 20, 2022			Chandra Sekhar Reddy Muthumula					Added arrayRankTransform
--------------------------------------------------------------------------------------------------
1331. Rank Transform of an Array
Easy
1.3K
62
Companies
Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.
 

Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.
Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
 

Constraints:

0 <= arr.length <= 105
-109 <= arr[i] <= 109
------------------------------------------------------------------------------------------------------
*/
package Problems.RankTransformofanArray;

import java.util.*;

public class RankTransformofanArray {

    public int[] arrayRankTransform(int[] arr) {
        /*
         * TC : O(NLogN) + O(N) + O(N)
         * SC : O(N) + O(N)
         */
        int len = arr.length;
        if (len == 1)
            return new int[] { 1 };
        Map<Integer, Integer> rankMap = new HashMap<>();
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        int rankCount = 1;
        for (int i = 0; i < len; i++) {
            if (!rankMap.containsKey(arrCopy[i])) {
                rankMap.put(arrCopy[i], rankCount++);
            }
        }

        for (int i = 0; i < len; i++) {
            arrCopy[i] = rankMap.get(arr[i]);
        }

        return arrCopy;
    }
}