/*
Class Name  : IntToRoman
Description : This class consists of the solution for IntToRoman.
Date        : Nov 11, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/integer-to-roman/description/

Modification Log: 
Date				    Name                                            Description
Nov 11, 2022			Chandra Sekhar Reddy Muthumula					Added Class IntToRoman 
Nov 11, 2022			Chandra Sekhar Reddy Muthumula					Added Class intToRomanBestApproach 
Nov 11, 2022			Chandra Sekhar Reddy Muthumula					Added Class intToRomanBetterApproach
Nov 11, 2022			Chandra Sekhar Reddy Muthumula					Added Class intToRomanBruteForce 
--------------------------------------------------------------------------------------------------
12. Integer to Roman
Medium
4.8K
4.8K
Companies
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= num <= 3999
-------------------------------------------------------------------------------------------
*/
package Problems.IntToRoman;

import java.util.*;

public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(intToRomanBruteForce(20));
    }

    public String intToRomanBestApproach(int num) {
        String M[] = { "", "M", "MM", "MMM" };
        String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    public String intToRomanBetterApproach(int num) {
        HashMap<String, Integer> roman_to_integer_map = new LinkedHashMap<>();
        roman_to_integer_map.put("M", 1000);
        roman_to_integer_map.put("CM", 900);
        roman_to_integer_map.put("D", 500);
        roman_to_integer_map.put("CD", 400);
        roman_to_integer_map.put("C", 100);
        roman_to_integer_map.put("XC", 90);
        roman_to_integer_map.put("L", 50);
        roman_to_integer_map.put("XL", 40);
        roman_to_integer_map.put("X", 10);
        roman_to_integer_map.put("IX", 9);
        roman_to_integer_map.put("V", 5);
        roman_to_integer_map.put("IV", 4);
        roman_to_integer_map.put("I", 1);
        String roman_string = "";
        for (String roman : roman_to_integer_map.keySet()) {
            // System.out.println("roman_string : " + roman_string + " num : " + num);
            int count = num / roman_to_integer_map.get(roman);
            while (count > 0) {
                roman_string += roman;
                count--;
            }
            // System.out.println("roman_string : " + roman_string);
            num %= roman_to_integer_map.get(roman);
            if (num == 0)
                break;
        }
        return roman_string;
    }

    public static String intToRomanBruteForce(int num) {
        HashMap<Character, Integer> roman_to_integer_map = new LinkedHashMap<>();
        roman_to_integer_map.put('I', 1);
        roman_to_integer_map.put('V', 5);
        roman_to_integer_map.put('X', 10);
        roman_to_integer_map.put('L', 50);
        roman_to_integer_map.put('C', 100);
        roman_to_integer_map.put('D', 500);
        roman_to_integer_map.put('M', 1000);
        // System.out.println("Map : " + roman_to_integer_map);
        String roman_string = "";
        int place_value = 1;
        while (num > 0) {
            int face_value = num % 10;
            if (face_value == 0) {
                place_value *= 10;
                num /= 10;
                continue;
            }
            int value = face_value * place_value;
            System.out.println("Value : " + value + " face_value : " + face_value);

            String value_string = "";
            if ((face_value >= 5 && face_value <= 8) || (face_value >= 1 && face_value <= 3)) {
                while (value > 0) {
                    // System.out.println("Value : " + value);
                    char prev_roman_value = 'I';
                    for (Character roman : roman_to_integer_map.keySet()) {
                        if (roman_to_integer_map.get(roman) > value) {
                            value_string += prev_roman_value;
                            value -= roman_to_integer_map.get(prev_roman_value);
                            break;
                        } else if (roman_to_integer_map.get(roman) == 1000) {
                            value_string += roman;
                            value -= roman_to_integer_map.get(roman);
                            break;
                        } else {
                            prev_roman_value = roman;
                        }

                    }
                    // System.out.println("value_string : " + value_string);
                }
            } else {
                // System.out.println("Value : " + value);
                char prev_roman_value = 'I';
                for (Character roman : roman_to_integer_map.keySet()) {
                    if (roman_to_integer_map.get(roman) > value) {
                        value_string += roman;
                        value = (roman_to_integer_map.get(roman) - value);
                        break;
                    } else {
                        prev_roman_value = roman;
                    }
                }
                // System.out.println("value_string : " + value_string);
                // System.out.println("Value : " + value);
                prev_roman_value = 'I';
                for (Character roman : roman_to_integer_map.keySet()) {
                    if (roman_to_integer_map.get(roman) > value) {
                        value_string = prev_roman_value + value_string;
                        value = (roman_to_integer_map.get(prev_roman_value) - value);
                        break;
                    } else {
                        prev_roman_value = roman;
                    }

                }
                // System.out.println("value_string : " + value_string);
            }

            num /= 10;
            place_value *= 10;
            roman_string = value_string + roman_string;
            System.out.println("roman_string : " + roman_string);
        }
        return roman_string;
    }
}