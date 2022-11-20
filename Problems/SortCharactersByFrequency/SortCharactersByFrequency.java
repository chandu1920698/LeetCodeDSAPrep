/*
Class Name  : SortCharactersByFrequency
Description : This class consists of the solution for SortCharactersByFrequency.
Date        : Nov 20, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/sort-characters-by-frequency/description/

Modification Log: 
Date				    Name                                            Description
Nov 20, 2022			Chandra Sekhar Reddy Muthumula					Added Class SortCharactersByFrequency 
Nov 20, 2022			Chandra Sekhar Reddy Muthumula					Added frequencySort
Nov 20, 2022			Chandra Sekhar Reddy Muthumula					Added sortByValue
--------------------------------------------------------------------------------------------------
451. Sort Characters By Frequency
Medium
5.2K
201
Companies
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
-------------------------------------------------------------------------------------------
*/
package Problems.SortCharactersByFrequency;
import java.util.*;
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int string_len = s.length();
        if (string_len == 1) return s;
        /*
        * TC : O(N) + O(N) + O(NLogN) = O(NLogN)
        * SC : O(N) + O(1) = O(N)
        */
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < string_len; i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        freqMap = sortByValue(freqMap); // Sorted based ob values

        StringBuilder result_string = new StringBuilder();
        for (Character key : freqMap.keySet()) {
            int charFreq = freqMap.get(key);
            for (int  i = 0; i < charFreq; i++) {
                result_string.append(key);
            }
        }
        return new String(result_string);
    }

    public HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
               new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}