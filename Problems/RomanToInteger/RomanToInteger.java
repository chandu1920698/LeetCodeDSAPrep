/*
Class Name  : RomanToInteger
Description : This class consists of the solution for RomanToInteger.
Date        : Oct 31, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/roman-to-integer/

Modification Log: 
Date					Name                                            Description
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class RomanToInteger 
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added romanToInt
--------------------------------------------------------------------------------------------------
13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, 
the numeral for four is not IIII. Instead, the number four is written as IV. 
Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. 
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
-------------------------------------------------------------------------------------------
*/
package Problems.RomanToInteger;
import java.util.*;;
public class RomanToInteger {
    public static void main(String[] args) {
        
    }

    public int romanToInt(String s) {

        /*
         * TC : O(N)
         * SC : O(1)
        */
        // XI - 11
        // XII - 12
        // IX - 9
        
        // use modifiers Static and Final
        // Work on Pseudo code before starting 
        HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        romanMap.put('C', 100);
        
        int len = s.length();
        
        //  If the len pf the input string is 1 then get the value from the,map
        if (len == 1) {
            return romanMap.get(s.charAt(0));
        }
        
        int result = 0;
        /*
         * Traversing from left to right
        */
        for (int i = 0; i < len - 1; i++) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }
        return result + romanMap.get(s.charAt(len - 1));

        /*
        * Traversing from right to left

        for (int i = len - 1; i >= 0; i--) {
            if (i == 0 ) {
                result += romanMap.get(s.charAt(i));
                return result;
            }
            if (romanMap.get(s.charAt(i)) <= romanMap.get(s.charAt(i - 1))) {
                result += romanMap.get(s.charAt(i));
            } else  {
                
                result += romanMap.get(s.charAt(i)) - romanMap.get(s.charAt(i - 1));
                i--;
            }
        }
        
        return result;    
        */
    }
}