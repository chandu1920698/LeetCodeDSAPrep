/*
Class Name  : FindSmallestLetterGreaterThanTarget
Description : This class consists of the solution for FindSmallestLetterGreaterThanTarget.
Created Date: Dec 21, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
Modification Log: 
Date					Name                                            Description
Dec 21, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindSmallestLetterGreaterThanTarget 
Dec 21, 2022			Chandra Sekhar Reddy Muthumula					Added nextGreatestLetter
--------------------------------------------------------------------------------------------------
744. Find Smallest Letter Greater Than Target
Easy
2.5K
1.9K
Companies
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

 

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
 

Constraints:

2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
------------------------------------------------------------------------------------------------------
*/
package Problems.FindSmallestLetterGreaterThanTarget;

public record FindSmallestLetterGreaterThanTarget() {
    /* 
     * TC : O(LogN)
     * SC : O(1)
    */
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        if (len == 1) {
            return letters[0];
        }
        if (target > letters[len - 1] || letters[0] > target) {
            return letters[0];
        }
        int start = 0, end = len - 1;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;          
            }   
        }
        return letters[start % len];
    }
}