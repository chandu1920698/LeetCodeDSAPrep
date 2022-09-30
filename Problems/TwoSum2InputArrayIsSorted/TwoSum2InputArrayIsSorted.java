import java.util.HashMap;

/*
Class Name  : TwoSumII-InputArrayIsSorted
Description : This class consists of the solution for TwoSum2InputArrayIsSorted.
Date        : Sep 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Modification Log: 
Date					Name                                            Description
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class TwoSum2InputArrayIsSorted 
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added twoSum
--------------------------------------------------------------------------------------------------
167. Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 find two numbers such that they add up to a specific target number. 
 Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 
Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
------------------------------------------------------------------------------------------------------
*/
class TwoSum2InputArrayIsSorted 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        if (numbers.length < 1) {
            return new int [] {-1,-1};
        }
		// Hash Map Method 
		/*
		TC 			: O(N)
		SC 			: O(N)
		*/
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[] {map.get(numbers[i]), i+1};
            } else {
                map.put(target-numbers[i], i+1);
            }
        }
		
		// Binary Search Method
		/*
		TC 			: O(NLogN)
		SC 			: O(1)
		*/
       int numbersLength = numbers.length;
        for (int i=0; i<numbersLength; i++) {
            int findNumber = target - numbers[i];
            // Binary Search Approach
            if (findNumber == numbers[i]) { // Condition for checking if the numbers are same, if so return the positions 
                return new int[] {i+1, i+2};
            }
            int start = i;
            int end = numbersLength -1;
            while (start <= end)  {
                int mid = (start + end ) / 2;
                if (numbers[mid] < findNumber) {
                    start = mid + 1;
                } else if (numbers[mid] > findNumber) {
                    end = mid - 1;
                } else {
                    return new int [] {i+1, mid+1};
                }
            }
        }
        return new int[] {-1,-1};
    }
}