/*
Class Name  : MajorityElement2
Description : This class consists of the solution for MajorityElement2.
Date        : Sep 20, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/majority-element-ii/

Modification Log: 
Date					Name                                            Description
Sep 20, 2022			Chandra Sekhar Reddy Muthumula					Added Class MajorityElement2 
Sep 20, 2022			Chandra Sekhar Reddy Muthumula					Added majorityElement 
--------------------------------------------------------------------------------------------------
229. MajorityElement2

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
 

Follow up: Could you solve the problem in linear time and in O(1) space?
-------------------------------------------------------------------------------------------
*/

class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int numsLength = nums.length;
		
		/*
		TC 			: O(N)
		SC 			: O(N)
		*/
		
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for (int i=0; i<numsLength; i++) {
        //     if (map.containsKey(nums[i])) {
        //         map.put(nums[i], map.get(nums[i])+1);
        //     } else {
        //         map.put(nums[i], 1);
        //     }
        // }
        // //System.out.println(map);
        // for (Integer key : map.keySet()) {
        //     if (map.get(key) > (numsLength/3) ) list.add(key);
        // }
        
//         if (numsLength == 2) {
//             if ((nums[0] ^ nums[1]) == 0) list.add(nums[0]);
//             else {
//                 list.add(nums[0]);
//                 list.add(nums[1]);
//             }
//         } else if (numsLength == 1) {
//             list.add(nums[0]);
//         } else if (numsLength > 2) {
//             int num1 = nums[0];
//             int count1 = 1;
//             int num2 = Integer.MIN_VALUE;
//             int count2 = 0;
//             int num3 = Integer.MIN_VALUE;
//             int count3 = 0;
//             boolean num2FirstAssignment = true;
//             boolean num3FirstAssignment = true;
//             for (int i=1; i<numsLength; i++) {
//                 if (nums[i] == num1) {
//                     count1++;
//                 } else {
//                     if (num2FirstAssignment) {
//                         num2 = nums[i];
//                         count2++;
//                         num2FirstAssignment = false;
//                     } else if (num3FirstAssignment && nums[i] != num2 ) {
//                         num3 = nums[i];
//                         count3++;
//                         num3FirstAssignment = false;
//                     } else {
//                         if (num2 != nums[i]) {
//                             count3++;
//                         } else {
//                             count2++;
//                         }
//                     }
                    
//                 }
//                 System.out.println("num1 : " + num1 + " num2 : " + num2 + " num3 : " +  num3);
//                 System.out.println("Count1 : " + count1 + " count2 : " + count2 + " count3 : " +  count3);
//             }
            
//             System.out.println("Count1 : " + count1 + " count2 : " + count2 + " count3 : " +  count3);
            
//             if (count1 > (numsLength/3)) {
//                 list.add(num1);
//             }
//             if (count2 > (numsLength/3)) {
//                 list.add(num2);
//             }
//             if (count3 > (numsLength/3)) {
//                 list.add(num3);
//             }
//         } 
        
		/*
		TC 			: O(N) + O(N)
		SC 			: O(1)
		*/
        int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0;
        for (int i=0; i<numsLength; i++ ) {
            if (nums[i] == num1) {
                count1++;
            } else if(num2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] == num1)
                count1++;
            else if (nums[i] == num2)
                count2++;
        }
        
        if (count1 > numsLength / 3)
            list.add(num1);
        if (count2 > numsLength / 3)
            list.add(num2);
        return list;
    }
    
}