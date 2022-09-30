/*
Class Name  : MinimumAbsoluteDifference
Description : This class consists of the solution for MinimumAbsoluteDifference.
Date        : Sep 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/minimum-absolute-difference/

Modification Log: 
Date					Name                                            Description
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinimumAbsoluteDifference 
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added minimumAbsDifference 
--------------------------------------------------------------------------------------------------
1200. Minimum Absolute Difference

Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 

Example 1:
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

Example 2:
Input: arr = [1,3,6,10,15]
Output: [[1,3]]

Example 3:
Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
 

Constraints:

2 <= arr.length <= 105
-106 <= arr[i] <= 106
*/
import java.util.*;;
class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int arrayLength = arr.length;
		/*
		TC 			: O(N)
		SC 			: O(1)
		Recommended : YES
		*/
		
        if (2 <= arrayLength && arrayLength <= 100000 && arr[arrayLength-1] <= 1000000 && arr[0] >= -1000000) {
            int minimumAbsoluteDifference = Integer.MAX_VALUE;
            for (int i=0; i < arrayLength-1; i++) {
                if (minimumAbsoluteDifference > arr[i+1]-arr[i]) {
                    minimumAbsoluteDifference = arr[i+1]-arr[i];
                     resultList.clear();
                    resultList.add(Arrays.asList(arr[i], arr[i+1]));
                } else if (minimumAbsoluteDifference == arr[i+1]-arr[i]) {
                    resultList.add(Arrays.asList(arr[i], arr[i+1]));
                }
            }
        }
        return resultList;
    }
}