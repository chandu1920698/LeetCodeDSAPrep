/*
Class Name  : NextGreaterElement1
Description : This class consists of the solution for NextGreaterElement1.
Date        : Oct 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/next-greater-element-i/

Modification Log: 
Date					Name                                            Description
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added Class NextGreaterElement1 
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added nextGreaterElement
--------------------------------------------------------------------------------------------------
496. Next Greater Element I

The next greater element of some element x in an array is the
 first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, 
where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j 
such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. 
If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 

Constraints:

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.
 
-------------------------------------------------------------------------------------------
*/
package Problems.NextGreaterElement1;
import java.util.*;;
public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1];
        
        for (int i=0; i<len1; i++) {
            result[i] = -1;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<len2; i++) {
            map.put(nums2[i], i);
        }
        for (int i=0; i<len1; i++) {
            if (map.containsKey(nums1[i])) {
                for(int j=map.get(nums1[i])+1; j<len2; j++) {
                    if(nums2[j] > nums1[i]) {
                        result[i] = nums2[j];
                        break;
                    }
                } 
            }
        }
        return result;
    }
}