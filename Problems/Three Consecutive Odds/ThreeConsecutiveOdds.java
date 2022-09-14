/*
Class Name  : ThreeConsecutiveOdds
Description : This class consists of the solution for ThreeConsecutiveOdds.
Date        : Sep 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/three-consecutive-odds/

Modification Log: 
Date					Name                                            Description
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class ThreeConsecutiveOdds 
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added threeConsecutiveOdds 
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added findMaxMinOfArray
--------------------------------------------------------------------------------------------------
1550. Three Consecutive Odds

Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 
Example 1:
Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.

Example 2:
Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.
 

Constraints:
1 <= arr.length <= 1000
1 <= arr[i] <= 1000

*/

class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int[] maxMin = findMaxMinOfArray(arr);
		/*
		TC 			: O(N) // O(N) + O(N) -> if findMaxMinOfArray is also included
		SC 			: O(1)
		Recommended : YES
		*/
        if (arr.length <= 1000 && 1 <= arr.length && maxMin[0] <= 1000 && maxMin[1] >= 1) {
            int arrayLength = arr.length;
            for (int i=1; i<arrayLength-1; i++) {
                if (arr[i-1]%2 + arr[i]%2 + arr[i+1]%2 == 3 ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[] findMaxMinOfArray (int [] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        return new int [] {max, min};
    }
}