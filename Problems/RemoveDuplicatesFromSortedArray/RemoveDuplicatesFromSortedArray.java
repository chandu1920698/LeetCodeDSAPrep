/*
Class Name  : WordPattern
Description : This class consists of the solution for WordPattern.
Date        : Oct 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/word-pattern/submissions/

Modification Log: 
Date					Name                                            Description
Oct 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class WordPattern 
Oct 23, 2022			Chandra Sekhar Reddy Muthumula					Added wordPattern 
--------------------------------------------------------------------------------------------------
290. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
-------------------------------------------------------------------------------------------
*/
package Problems.RemoveDuplicatesFromSortedArray;
import java.util.*;
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        
        int index = 0;
        for (int num : nums) {
            set.add(num);
        }
        index = 0;
        for (Integer num : set) {
            nums[index++] = num;
        }
        return set.size();
    }

    public int removeDuplicatesEfficient(int[] nums) {
        int len = nums.length;
        int left  = 1;
        int right = 1;
        
        for (int i = 1; i < len; i++) {
            if(nums[i] != nums[i - 1] ) {
                
                nums[left] = nums[i];
                left += 1;
            }
        }
        return left;
    }
}