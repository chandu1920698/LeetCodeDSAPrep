
/*
Class Name  : RemovingStarsFromString
Description : This class consists of the solution for RemovingStarsFromString.
Date        : Jul 13, 2023
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/removing-stars-from-a-string/description/

Modification Log: 
Date				    Name                                            Description
Jul 13, 2023			Chandra Sekhar Reddy Muthumula					Added Class RemovingStarsFromString 
Jul 13, 2023			Chandra Sekhar Reddy Muthumula					Added removeStars
--------------------------------------------------------------------------------------------------
2390. Removing Stars From a String
Medium
2.3K
147
Companies
You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.
 

Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
Example 2:

Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters and stars *.
The operation above can be performed on s.
-------------------------------------------------------------------------------------------
*/
package Problems.RemovingStarsFromString;

public class RemovingStarsFromString {
    public String removeStars(String s) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int len = s.length();
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) != '*') {
                finalString.append(s.charAt(i));
            } else if(finalString.length() > 0) {
                finalString.deleteCharAt(finalString.length() - 1);
            }
        }
        return new String(finalString);
    }
}
