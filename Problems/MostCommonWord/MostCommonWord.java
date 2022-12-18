/*
Class Name  : MostCommonWord
Description : This class consists of the solution for MostCommonWord.
Created Date: Dec 18, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/most-common-word/description/
Modification Log: 
Date					Name                                            Description
Dec 18, 2022			Chandra Sekhar Reddy Muthumula					Added Class MostCommonWord 
Dec 18, 2022			Chandra Sekhar Reddy Muthumula					Added mostCommonWord
--------------------------------------------------------------------------------------------------
819. Most Common Word
Easy
1.4K
2.8K
Companies
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

 

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"
 

Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
------------------------------------------------------------------------------------------------------
*/
package Problems.MostCommonWord;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        /*
         * TC : O(N) + O(N) + O(N) + O(N)
         * SC : O(N) + O(N) + O(N)
         */
        Map<String, Integer> count = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s);
        }
        String[] words = paragraph.toLowerCase().replaceAll("\\W+", " ").split("\\s+");
        // System.out.println(Arrays.toString(words));
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        // System.out.println("Freq :" + count);

        int maxFreq = 0;
        String maxWord = "";
        for (String key : count.keySet()) {
            if (count.get(key) > maxFreq) {
                maxFreq = count.get(key);
                maxWord = key;
            }
        }
        return maxWord;

    }
}