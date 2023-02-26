/*
Class Name  : FindKClosestElements
Description : This class consists of the solution for FindKClosestElements.
Created Date: Feb 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-k-closest-elements/description/
Modification Log: 
Date					    Name                                            Description
Feb 26, 2022			    Chandra Sekhar Reddy Muthumula					Added Class FindKClosestElements 
Feb 26, 2022			    Chandra Sekhar Reddy Muthumula					Added numOfSubarrays
--------------------------------------------------------------------------------------------------
658. Find K Closest Elements
Medium
6.7K
540
Companies
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
------------------------------------------------------------------------------------------------------
*/
package Problems.FindKClosestElements;
import java.util.*;
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int lo = 0;
		int hi = arr.length - 1;
		while (hi - lo >= k) {
			if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
				lo++;
			} else {
				hi--;
			}
		}
		List<Integer> result = new ArrayList<>(k);
		for (int i = lo; i <= hi; i++) {
			result.add(arr[i]);
		}
		return result;
    }
}