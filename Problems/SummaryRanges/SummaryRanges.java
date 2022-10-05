/*
Class Name  : SummaryRanges
Description : This class consists of the solution for SummaryRanges.
Date        : Oct 4, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/summary-ranges/
Modification Log: 
Date				Name                                            Description
Oct 4, 2022			Chandra Sekhar Reddy Muthumula					Added Class SummaryRanges 
Oct 4, 2022			Chandra Sekhar Reddy Muthumula					Added summaryRanges 
--------------------------------------------------------------------------------------------------
228. Summary Ranges

You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
That is, each element of nums is covered by exactly one of the ranges, 
and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 
Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
------------------------------------------------------------------------------------------------------
*/
package Problems.SummaryRanges;
import java.util.*;;
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> resultString = new ArrayList<String>();
        
        int len = nums.length;
        for (int i=0; i<len; i++) {
            int start = nums[i];

            while(i+1 < len && nums[i]+1 == nums[i+1]) {
                i++;
            }
            if(start != nums[i]) {
                resultString.add("" + start + "->" + nums[i]);
            } else {
                resultString.add("" + start);
            }
        }
        return resultString;
    }
}