/*
Class Name  : NextGreaterElement2
Description : This class consists of the solution for NextGreaterElement2.
Date        : Oct 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/next-greater-element-ii/submissions/

Modification Log: 
Date					Name                                            Description
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added Class NextGreaterElement2 
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added nextGreaterElements
--------------------------------------------------------------------------------------------------
503. Next Greater Element II

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
 return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to 
its traversing-order next in the array, which means you could search circularly to find its next greater number. 
If it doesn't exist, return -1 for this number.

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
-------------------------------------------------------------------------------------------
*/
package Problems.NextGreaterElement2;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        // This is a Brute force method
        /*
        * TC : O(N^2)
        * SC : O(1)
        */
        int len = nums.length;
        
        if (len == 1) return new int[] {-1};
        int[] result = new int[len];
        
        for (int i=0; i<len; i++) {  // Filling all the elements with Integer.MIN_VALUE
            result[i] = Integer.MIN_VALUE;
        }
        
        if (len > 1) {
            int i=0;
            for (i=0; i<len-1; i++) {
                for (int j=i+1; j<len;  j++) {
                    if ((nums[j] > nums[i])) {
                        result[i] = nums[j];
                        break;
                    }
                }
                
                if (result[i] < nums[i]) {
                    for (int k=0; k<i; k++) {
                        if((nums[k] > nums[i])) {
                            result[i] = nums[k];
                            break;
                        }
                    }
                }
                
            }
            
            for (int l=0;l<len-1;  l++) {
                if ((nums[l] > nums[i])) {
                    result[i] = nums[l];
                    break;
                }
            }
        }
        
        for (int i=0; i<len; i++) {  // Replacing Integer.MIN_VALUE with -1
            if (result[i] == Integer.MIN_VALUE) result[i] = -1;
        }
        return result;
    }

    public int[] nextGreaterElements(int[] nums) {
        // This is a Stack method
        /*
        * TC : O(2* N)
        * SC : O(N)
        */
        int len = nums.length;
        
        if (len == 1) return new int[] {-1};
        int[] result = new int[len];        
        
        if (len > 1) {
            Stack<Integer> stack = new Stack<Integer>();
            
            for (int i=len-1; i>=0; i--) { // Filling elements into stack
                stack.push(nums[i]);
            }
            
            for (int i=len-1; i>=0; i--) {
                while(!stack.empty() && nums[i] >= stack.peek()) {
                    stack.pop();
                }
                
                if(stack.empty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
                
                stack.push(nums[i]);
            }
            
        }
        return result;
    }
}