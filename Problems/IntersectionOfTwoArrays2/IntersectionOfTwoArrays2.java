/*
Class Name  : IntersectionOfTwoArrays
Description : This class consists of the solution for IntersectionOfTwoArrays.
Date        : Oct 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/intersection-of-two-arrays/

Modification Log: 
Date					Name                                            Description
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added Class IntersectionOfTwoArrays 
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added intersection 
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added binarySearch 
--------------------------------------------------------------------------------------------------
349. Intersection of Two Arrays
Given two integer arrays nums1 and nums2, 
return an array of their intersection. 
Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 
Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
-------------------------------------------------------------------------------------------
*/
package Problems.IntersectionOfTwoArrays2;
import java.util.*;;
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
         for(int i : nums1){
             int freq = map.getOrDefault(i, 0);
             map.put(i, freq + 1);
         }
         ArrayList<Integer> list = new ArrayList<>();
         for(int i : nums2){
             if(map.get(i) != null && map.get(i) > 0){
                 list.add(i);
                 map.put(i, map.get(i) - 1);
             }
         }
         int[] ret = new int[list.size()]; 
         for(int i = 0; i < list.size();i++){
             ret[i] = list.get(i);
         }
         return ret;
     }
     
     public boolean binarySearch(int[] nums2, int target, int start, int end) {
         while(start <= end) {
             int mid = start + ((end - start)>>1);
             if(nums2[mid] == target) {
                 return true;
             } else if(target < nums2[mid]) {
                 end = mid - 1;
             } else {
                 start = mid + 1;
             }
         }
         return false;
     }
}