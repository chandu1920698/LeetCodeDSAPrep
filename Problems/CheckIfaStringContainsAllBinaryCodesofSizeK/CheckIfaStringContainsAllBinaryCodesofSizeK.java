
/*
Class Name  : CheckIfaStringContainsAllBinaryCodesofSizeK
Description : This class consists of the solution for CheckIfaStringContainsAllBinaryCodesofSizeK.
Date        : Oct 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

Modification Log: 
Date					Name                                            Description
Oct 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class CheckIfaStringContainsAllBinaryCodesofSizeK 
Oct 22, 2022			Chandra Sekhar Reddy Muthumula					Added hasAllCodes
--------------------------------------------------------------------------------------------------
1461. Check If a String Contains All Binary Codes of Size K

Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.


Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". 
They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
Example 2:

Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 
Example 3:

Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.
 

Constraints:

1 <= s.length <= 5 * 105
s[i] is either '0' or '1'.
1 <= k <= 20
-------------------------------------------------------------------------------------------
*/
package Problems.CheckIfaStringContainsAllBinaryCodesofSizeK;

import java.util.*;;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {
    public boolean hasAllCodes(String s, int k) {

        if (s.length() < k) {
            return false;
        }
        int index = 0;
        int len = s.length();
        HashSet<String> seen = new HashSet<>();
        while (index + k <= len) {
            seen.add(s.substring(index, index++ + k));
        }
        if (seen.size() == (1 << k)) {
            return true;
        }
        return false;

    }
}