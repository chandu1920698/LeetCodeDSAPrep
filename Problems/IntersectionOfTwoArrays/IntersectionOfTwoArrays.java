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
package Problems.IntersectionOfTwoArrays;
import java.util.*;;
public class IntersectionOfTwoArrays {
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     ArrayList<Integer> list = new ArrayList<Integer>();
        
    //     int len1 = nums1.length;
    //     int len2 = nums2.length;
        
    //     This method uses 2 HashSet
    //     /*
    //     * TC : O(N+M)
    //     * SC : O(N+M) - WORST
    //     */
    //     Set<Integer> set1 = new HashSet<Integer>();
    //     Set<Integer> set2 = new HashSet<Integer>();
    //     for(int i=0; i<len1; i++) {
    //         set1.add(nums1[i]);
    //     }
    //     // System.out.println("Set : " + set1);
        
    //     for(int i=0; i<len2; i++) {
    //         if(set1.contains(nums2[i])) {
    //             set2.add(nums2[i]);
    //         }
    //     }
    //     // System.out.println("Set2 : " + set2);
    //     int length = set2.size();
    //     int[] result = new int[length];
        
    //     Iterator iterator = set2.iterator();
    //     int i=0;
    //     while(iterator.hasNext()) {
    //         result[i++] = (int)iterator.next();
    //     }
    //     return result;
        
    // }
    
    // public int[] intersection(int[] nums1, int[] nums2) {
        
    //     // This method uses Binary Search and Set data structure
    //     /*
    //     * TC : O()
    //     * SC : O() - WORST
    //     */
    //     if(nums1.length > nums2.length) {
    //         intersection(nums2, nums1);
    //     }
    //     ArrayList<Integer> list = new ArrayList<Integer>();
        
    //     int len1 = nums1.length;
    //     int len2 = nums2.length;
        
    //     HashSet<Integer> set = new HashSet<Integer>();
    //     Arrays.sort(nums2);
    //     for(int i=0; i<len1; i++) {
    //         if(binarySearch(nums2, nums1[i], 0, len2 - 1)) {
    //             set.add(nums1[i]);
    //         }
    //     }
    //     // System.out.println("Set : " + set);
    //     int length = set.size();
    //     int[] result = new int[length];
        
    //     Iterator iterator = set.iterator();
    //     int i=0;
    //     while(iterator.hasNext()) {
    //         result[i++] = (int)iterator.next();
    //     }
    //     return result;
    // }
        
    public int[] intersection(int[] nums1, int[] nums2) {
        // Sort the two arrays and use the two pointer method
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
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