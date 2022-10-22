/*
Class Name  : FindAllNumbersDisappearedInArray
Description : This class consists of the solution for FindAllNumbersDisappearedInArray.
Date        : Oct 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Modification Log: 
Date					Name                                            Description
Oct 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindAllNumbersDisappearedInArray 
Oct 22, 2022			Chandra Sekhar Reddy Muthumula					Added findDisappearedNumbers
Oct 22, 2022			Chandra Sekhar Reddy Muthumula					Added findDisappearedNumbersEfficient
--------------------------------------------------------------------------------------------------
448. Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
-------------------------------------------------------------------------------------------
*/
package Problems.FindAllNumbersDisappearedInArray;

import java.util.*;;

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
         * TC : O(N) + O(N)
         * SC : O(N)
        */
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbersEfficient(int[] nums) {
        List<Integer> result = new ArrayList<>();
        /*
         * TC : O(N) + O(N)
         * SC : O(1)
        */
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                result.add(i + 1);
        return result;
    }
}