/*
Class Name  : MissingRanges
Description : This class consists of the solution for MissingRanges.
Date        : Sep 20, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://www.lintcode.com/problem/641/description

Modification Log: 
Date					Name                                            Description
Sep 20, 2022			Chandra Sekhar Reddy Muthumula					Added Class MissingRanges 
Sep 20, 2022			Chandra Sekhar Reddy Muthumula					Added findMissingRanges 
--------------------------------------------------------------------------------------------------
641 · MissingRanges

Description
Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Contact me on wechat to get Amazon、Google requent Interview questions . (wechat id : jiuzhang0607)

Example 1
Input:
nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
Output:
["2", "4->49", "51->74", "76->99"]

Explanation:
in range[0,99],the missing range includes:range[2,2],range[4,49],range[51,74] and range[76,99]

Example 2
Input:
nums = [0, 1, 2, 3, 7], lower = 0 and upper = 7
Output:
["4->6"]
Explanation:
in range[0,7],the missing range include range[4,6]
-------------------------------------------------------------------------------------------
*/
import java.util.*;;
public class MissingRanges {
    /**
     * @param nums: a sorted integer array
     * @param lowerLong: An integer
     * @param upperLong: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
		long lowerLong = lower;
        long upperLong = upper;
        List<String> result = new ArrayList<String>();
        if (nums.length < 1) {
            if (upperLong == lowerLong) {
                result.add("" + upperLong);
            } else {
                result.add( (lowerLong) + "->" + (upperLong));
            }
        } else if (nums.length == 1) {
            if ((long)nums[0] != lowerLong && (long)nums[0] == upperLong) {
                result.add((lowerLong) + "->" + (upperLong-1));
            } else if ((long)nums[0] == lowerLong && (long)nums[0] != upperLong) {
                result.add((lowerLong+1) + "->" + (upperLong));
            }
        } else if (nums.length == 2) {
            if ((long)nums[0] == lowerLong && (long)nums[1] == upperLong) {
                result.add((lowerLong+1) + "->" + (upperLong-1));
            } else if ((long)nums[0] != lowerLong && (long)nums[0] == upperLong) {
                result.add((lowerLong) + "->" + (upperLong-1));
            } else if ((long)nums[0] == lowerLong && (long)nums[0] != upperLong) {
                result.add((lowerLong+1) + "->" + (upperLong));
            } else if ((long)nums[0] != lowerLong && (long)nums[0] != upperLong) {
                result.add((lowerLong) + "->" + (upperLong));
            }
        } else {
            if ( (long)nums[0] != lowerLong) {
                if ( (long)nums[0] -  lowerLong >= 2) {
                    result.add( (lowerLong) + "->" + ((long)nums[0]-1));
                // } else if ((long)nums[0] - lowerLong  == 2) {
                //     result.add("" + (lowerLong+1));
                } else if ((long)nums[0] - lowerLong  == 1) {
                    result.add((lowerLong) + "");
                }
            }
            
            for (int i=0; i<nums.length-1; i++ ) {
                if ((long)nums[i+1]-(long)nums[i] == 2) {
                    result.add(((long)nums[i]+1) + "");
                }
                else if ((long)nums[i+1]-(long)nums[i] > 2) {
                    result.add(((long)nums[i]+1) + "->" + ((long)nums[i+1]-1));
                }
            }

            if ((long)nums[nums.length-1] != upperLong) {
                if (upperLong - (long)nums[nums.length-1] >= 2) {
                    result.add(((long)nums[nums.length-1]+1) + "->" + upperLong);
                // } else if (upperLong - (long)nums[nums.length-1] == 2) {
                //     result.add("" + (upperLong-1));
                } else if (upperLong - (long)nums[nums.length-1] == 1) {
                    result.add("" + (upperLong));
                }
            }
            
        }
        
        return result;
    }
}