/*
Class Name  : MinimumMovesToEqualArrayElements
Description : This class consists of the solution for MinimumMovesToEqualArrayElements.
Date        : Nov 1, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/submissions/

Modification Log: 
Date				Name                                            Description
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinimumMovesToEqualArrayElements 
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added minMovesEfficient
Nov 1, 2022			Chandra Sekhar Reddy Muthumula					Added minMovesBruteForce
--------------------------------------------------------------------------------------------------
453. Minimum Moves to Equal Array Elements

Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment n - 1 elements of the array by 1.


Example 1:

Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
Example 2:

Input: nums = [1,1,1]
Output: 0
 

Constraints:

n == nums.length
1 <= nums.length <= 105
-109 <= nums[i] <= 109
The answer is guaranteed to fit in a 32-bit integer.
-------------------------------------------------------------------------------------------
*/
package Problems.MinimumMovesToEqualArrayElements;

import java.util.*;;

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {

    }

    // This is an efficient solution
	/*
	* TC : O(N)
	* SC : O(1)
	*/
    public int minMovesEfficient(int[] nums) {
        int len = nums.length;
        int sum = 0;
		/*
		* Explanation : 
		* Consider nums[] = {-1, 0, 2}
		* Since we are incrementing n-1 elements to at a time we have to count the steps that are needed to make the current element to the next element of the array
		* The no of steps to make -1 to 2 is    2 - (-1) = 3
		* The no of steps to make 0 to -1 is    0 - (-1) = 1
		* The no of steps to make -1 to -1 is  -1 - (-1) = 0
		* When we see the above equations we can observe that left operands are the elements of the array and the right operand is the min value of the array;
		* So we need to find the sum of all the elements of the array and subtract the min value N times from the sum.
		*/
        int min = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (min > nums[i]) {
                min = nums[i];
            }
            sum += nums[i];
        }
        return sum - len * min;
    }



    // This is a brute force solution
    // TC : O(N Log N)
    // SC : O(N)
    // This will give TLE
    public int minMovesBruteForce(int[] nums) {
        int len = nums.length;
        // Initially check if all the elements are same
        if (isAllEqual(nums))
            return 0;
        int count = 0;
        while (!isAllEqual(nums)) {
            // If all the elemets are not equal then increment n - 1 elements
            for (int i = 0; i < len - 1; i++) {
                nums[i]++;
            }
            // Increment count
            count++;
            Arrays.sort(nums);
        }
        return count;
    }

    /*
     * Method Name : isAllEqual
     * Description : This method checks if all the nums are same
     * Input Paramenters : int [] nums
     * Output : boolean
     */
    public boolean isAllEqual(int[] nums) {
        int firstNum = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (firstNum != nums[i]) {
                return false;
            }
        }
        return true;
    }
}