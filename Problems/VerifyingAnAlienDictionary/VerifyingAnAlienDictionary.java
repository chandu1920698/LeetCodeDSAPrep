/*
Class Name  : VerifyingAnAlienDictionary
Description : This class consists of the solution for VerifyingAnAlienDictionary.
Created Date: Feb 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/verifying-an-alien-dictionary/description//
Modification Log: 
Date					Name                                            Description
Feb 5, 2022			    Chandra Sekhar Reddy Muthumula					Added Class VerifyingAnAlienDictionary 
Feb 5, 2022			    Chandra Sekhar Reddy Muthumula					Added findTheDifference
Feb 5, 2022			    Chandra Sekhar Reddy Muthumula					Added findTheDifferenceXORApproach
--------------------------------------------------------------------------------------------------
953. Verifying an Alien Dictionary
Easy
4.4K
1.4K
Companies
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
------------------------------------------------------------------------------------------------------
*/
package Problems.VerifyingAnAlienDictionary;
import java.util.*;
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        /* 
         * TC : O(N * M)
         * SC : o(M)
        */
        int len = words.length;
        if(len == 0) {
            return false;
        }

        if(len == 1) {
            return true;
        }
        int orderLen = order.length();
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < orderLen; i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < len - 1; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];
            int index = 0;
            while(index < firstWord.length() && index < secondWord.length()) {
                if (firstWord.charAt(index) == secondWord.charAt(index)) {
                    index++;
                    continue;
                } else if(orderMap.get(firstWord.charAt(index)) < orderMap.get(secondWord.charAt(index))) {
                    break;
                } else if(orderMap.get(firstWord.charAt(index)) > orderMap.get(secondWord.charAt(index))) {
                    return false;
                }
                index++;
            }
            if(firstWord.length() > secondWord.length() && (index == firstWord.length() || index == secondWord.length())) {
                return false;
            }
        }
        return true;
    }
}