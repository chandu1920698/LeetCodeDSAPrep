/*
Class Name  : LetterCombinationsPhoneNumber
Description : This class consists of the solution for LetterCombinationsPhoneNumber.
Date        : Oct 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Modification Log: 
Date					Name                                            Description
Oct 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class LetterCombinationsPhoneNumber 
Oct 19, 2022			Chandra Sekhar Reddy Muthumula					Added molibeNumberKeyPadArrayList 
--------------------------------------------------------------------------------------------------
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
-------------------------------------------------------------------------------------------
*/
package Problems.LetterCombinationsPhoneNumber;
import java.util.*;;
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        
        if(len == 0) return new ArrayList<String>();
        
        
        return molibeNumberKeyPadArrayList("", digits);
    }

    public static List<String> molibeNumberKeyPadArrayList(String p, String up) {
        List<String> list = new ArrayList<String>();
        if(up.isEmpty()) {
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        if( 2 <= digit && digit <= 6) {
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                list.addAll(molibeNumberKeyPadArrayList(p + (char) ('a' + i), up.substring(1)));
            }
        } else if(7 == digit) {
            for (int i = 15; i < 19; i++) {
                list.addAll(molibeNumberKeyPadArrayList(p + (char) ('a' + i), up.substring(1)));
            }
        } else if(8 == digit) {
            for (int i = 19; i < 22; i++) {
                list.addAll(molibeNumberKeyPadArrayList(p + (char) ('a' + i), up.substring(1)));
            }
        } else if(9 == digit) {
            for (int i = 22; i < 26; i++) {
                list.addAll(molibeNumberKeyPadArrayList(p + (char) ('a' + i), up.substring(1)));
            }
        }
        return list;
    }
}