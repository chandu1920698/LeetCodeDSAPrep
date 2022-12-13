/*
Class Name  : KthLargestElementInArray
Description : This class consists of the solution for KthLargestElementInArray.
Created Date: Dec 13, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/kth-largest-element-in-an-array/description/

Modification Log: 
Date					Name                                            Description
Dec 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class KthLargestElementInArray 
Dec 13, 2022			Chandra Sekhar Reddy Muthumula					Added findKthLargestPriorityQueue
Dec 13, 2022			Chandra Sekhar Reddy Muthumula					Added findKthLargestListApproach
Dec 13, 2022			Chandra Sekhar Reddy Muthumula					Added findKthLargestStackApproach
--------------------------------------------------------------------------------------------------
215. Kth Largest Element in an Array
Medium
12.7K
639
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
-------------------------------------------------------------------------------------------
*/
package Problems.KthLargestElementInArray;
import java.util.*;
public class KthLargestElementInArray {
    
    public int findKthLargestPriorityQueue(int[] nums, int k) {
        /* 
         * Best TC : O(N);
         * Worst TC : O(K)
         * Avg TC : O(N)
         * SC : O(N)
        */
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargestListApproach(int[] nums, int k) {
        /* 
         * Best TC : O(N) + O(NLogN)
         * Worst TC : O(N) + O(NLogN)
         * Avg TC : O(N) + O(NLogN)
         * SC : O(N)
        */
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            // if(!list.contains(num)) list.add(num);
            list.add(num);
        }

        Collections.sort(list);

        return list.get(list.size() - k);
    }

    public int findKthLargestStackApproach(int[] nums, int k) {
        /* 
         * Best TC : O(N) + O(NLogN)
         * Worst TC : O(N) + O(NLogN)
         * Avg TC : O(N) + O(NLogN)
         * SC : O(N)
        */
        Arrays.sort(nums);

        int len = nums.length;
        Stack<Integer> stack = new Stack<Integer>();
        for (int  i = len - 1; i >= 0; i--) {
            if(stack.isEmpty()) stack.push(nums[i]);
            else {
                if(stack.size() < k ) {
                    stack.push(nums[i]);
                }
                //  else if (stack.size() < k && stack.peek() == nums[i]) {
                //     // Do nothing
                // } 
                else if (stack.size() == k) {
                    break;
                }
            }
        }
        // System.out.println("Stack : " + stack);
        return stack.pop();
    }
}