/*
Class Name  : FindTheDifferenceOfTwoArrays
Description : This class consists of the solution for FindTheDifferenceOfTwoArrays.
Date        : Oct 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/intersection-of-two-arrays/

Modification Log: 
Date					Name                                            Description
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindTheDifferenceOfTwoArrays 
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added findDifferenceBinarySearch 
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added binarySearch  
Oct 18, 2022			Chandra Sekhar Reddy Muthumula					Added findDifferenceUsingSetsOnly
--------------------------------------------------------------------------------------------------
2215. Find the Difference of Two Arrays
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
Example 2:

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
-1000 <= nums1[i], nums2[i] <= 1000
-------------------------------------------------------------------------------------------
*/

package Problems.FindTheDifferenceOfTwoArrays;
import java.util.*;
public class FindTheDifferenceOfTwoArrays {

    /*
     * TC : O(M LogM) + O(N LogN) + O(M LogN) + O(N LogM)
     * SC : O(2 * Non Intersestion of M) + O(2 * Non Intersestion of N) 
    */
    public List<List<Integer>> findDifferenceBinarySearch(int[] nums1, int[] nums2) {
        // Sort the two Arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int len1 = nums1.length;
        int len2 = nums2.length;

        // Create two sets to store the non interseting numbers
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int i=0; i<len1; i++) {
            // Target will be nums1[i]
            if(!binarySerch(nums2, nums1[i], 0 , len2 -1 )) {
                set1.add(nums1[i]);
            }
        }
        
        for(int i=0; i<len2; i++) {
            // Target will be nums2[i]
            if(!binarySerch(nums1, nums2[i], 0 , len1 -1 )) {
                set2.add(nums2[i]);
            }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(Integer item : set1) {
            list1.add(item);
        }
        list.add(list1);
        for(Integer item : set2) {
            list2.add(item);
        }
        list.add(list2);
        return list;
    }
    
    public boolean binarySerch(int[] nums2, int target, int start, int end) {
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            if(nums2[mid] == target) {
                return true;
            } else if(nums2[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public List<List<Integer>> findDifferenceUsingSetsOnly(int[] nums1, int[] nums2) {
        /*
         * TC : O(M + Non Intersection Elements of M + N + Non Intersection of N)
         * SC : O(M + Non Intersection Elements of M + N + Non Intersection of N)
        */
        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int i=0; i<len1; i++) {
            set1.add(nums1[i]);
        }
        
        for(int i=0; i<len2; i++) {
            set2.add(nums2[i]);
        }
                
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(Integer item : set1) {
            if(!set2.contains(item)) {
                list1.add(item);           
            }
        }
        list.add(list1);
        for(Integer item : set2) {
            if(!set1.contains(item)) {
                list2.add(item);           
            }
        }
        list.add(list2);
        return list;
    }
}