/*
Class Name  : GroupAnagrams
Description : This class consists of the solution for GroupAnagrams.
Date        : Sep 23, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/group-anagrams/

Modification Log: 
Date					Name                                            Description
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added Class GroupAnagrams 
Sep 23, 2022			Chandra Sekhar Reddy Muthumula					Added groupAnagrams 
--------------------------------------------------------------------------------------------------
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3
Input: strs = ["a"]
Output: [["a"]]
 

Constraints:
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
-------------------------------------------------------------------------------------------
*/

class GroupAnagrams {
    
     public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i=0; i<len; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sortedString = new String(temp);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            } 
            map.get(sortedString).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}