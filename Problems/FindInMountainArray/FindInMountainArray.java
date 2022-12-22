/*
Class Name  : FindInMountainArray
Description : This class consists of the solution for FindInMountainArray.
Created Date: Dec 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-in-mountain-array/description/

Modification Log: 
Date					Name                                            Description
Dec 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindInMountainArray 
Dec 22, 2022			Chandra Sekhar Reddy Muthumula					Added findInMountainArray 
Dec 22, 2022			Chandra Sekhar Reddy Muthumula					Added binarySearchOrderAgnoistic 
--------------------------------------------------------------------------------------------------
1095. Find in Mountain Array
Hard
1.7K
68
Companies
(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 

Constraints:

3 <= mountain_arr.length() <= 104
0 <= target <= 109
0 <= mountain_arr.get(index) <= 109
-------------------------------------------------------------------------------------------
*/
package Problems.FindInMountainArray;

/* 
 * Consider this class only in leetcode
*/
class MountainArray {
    public int get(int index) {
        return index;
    }

    public int length() {
        return 1;
    }
}

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int start = 0, end = len - 1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int midElement = mountainArr.get(mid);
            if (midElement < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else if (midElement > mountainArr.get(mid + 1)) {
                end = mid;
            }
            if (start == mid) {
                break;
            }
        }
        int resultIndex = binarySearchOrderAgnoistic(mountainArr, 0, start, target);
        if (resultIndex == -1) {
            return binarySearchOrderAgnoistic(mountainArr, start + 1, len - 1, target);
        }
        return resultIndex;
    }

    public int binarySearchOrderAgnoistic(MountainArray mountainArr, int start, int end, int target) {
        boolean isAscending = mountainArr.get(start) < mountainArr.get(end);
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                return mid;
            }
            if (isAscending) {
                if (midElement < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (midElement < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}