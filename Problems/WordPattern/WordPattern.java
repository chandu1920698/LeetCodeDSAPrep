/*
Class Name  : ValidSudoku
Description : This class consists of the solution for ValidSudoku.
Date        : Sep 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/valid-sudoku/

Modification Log: 
Date					Name                                            Description
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class ValidSudoku 
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added isValidSudoku 
--------------------------------------------------------------------------------------------------
290. Word Pattern
Easy

4145

470

Add to List

Share
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
package Problems.WordPattern;
import java.util.*;;
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        int patternLength = pattern.length();
        // Split the given String s based on the spaces
        String[] words = s.split(" ");
        
        int wordsLength = words.length;
        
        // Edge condition : The number of words in String s should be equal to the pattern length
        // If not return false
        
        if(patternLength != wordsLength) return false; 
        
        HashMap<Character, String> map = new HashMap<>();
        
        // Here we are mapping the charcter in the pattern with the word in String s
        for (int i = 0; i < patternLength; i++) {
            // Checking
            // 1. If the character is aalready mapped  with the word in String s
            // 2. If the word is aleady mapped to the charcter in the patttern
            if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(words[i])) {
                map.put(pattern.charAt(i), words[i]);
            } 
        }
        System.out.println(map);
        // Here we are building the word string with the help of the map
        for (int i = 0; i < patternLength; i++) {
            // Checking
            // 1. If the character is present the map
            if (map.containsKey(pattern.charAt(i)) ) {
                if(words[i].equals(map.get(pattern.charAt(i)))) {
                    continue;
                } else return false;
            } else {
                return false;
            }
        }
        
        // if(s.equals(String.join(" ", words))) {
        //     return true;
        // }
        return true;
    }
}