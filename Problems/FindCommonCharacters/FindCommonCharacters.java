/*
Class Name  : FindCommonCharacters
Description : This class consists of the solution for FindCommonCharacters.
Date        : Oct 31, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/find-common-characters/

Modification Log: 
Date					Name                                            Description
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added Class FindCommonCharacters 
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added commonChars
Oct 31, 2022			Chandra Sekhar Reddy Muthumula					Added commonCharsWithIntArrayDictionary
--------------------------------------------------------------------------------------------------
1002. Find Common Characters

Given a string array words, return an array of all characters that show up in all strings 
within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.FindCommonCharacters;
import java.util.*;
public class FindCommonCharacters {
    public static void main(String[] args) {
        
    }

    public List<String> commonChars(String[] words) {
	    // Add the chatacters of the first word to the list
		// Bec all the common characters must be a part of the first word also
        ArrayList<String> commonCharsList = new ArrayList<String>();
        
        int firstWordLength = words[0].length();
        
        for (int i = 0; i < firstWordLength; i++ ) {
            commonCharsList.add("" +words[0].charAt(i));
        }
		
		// Compare the remaining strings with the list of all the charcters in the Array list
        int noOfStrings = words.length;
        for (int i = 1; i < noOfStrings; i++) {
			// Create a dictionary for thr charcters
            int[] charMap = new int[26];
            int len = words[i].length();
			// Add the charcters to the dictionary
            for (int j = 0; j < len; j++) {
                charMap[words[i].charAt(j) - 'a']++;
            }
			// Iterate the Arraylist using the iterator 
            Iterator<String> commonCharsListItr = commonCharsList.iterator();
            
            while (commonCharsListItr.hasNext()) {
				// Fiind the index of the charcter in the below manner
                int chIndex = commonCharsListItr.next().charAt(0) - 'a';
				// If the count of the character is greater than 0 then decrement the count value
                if (charMap[chIndex] > 0) {
                    charMap[chIndex]--;
                } else { // If the count value is 0 that means that character is not common in all the strings so remove it from the ArrayList
                    commonCharsListItr.remove();
                }
            }
        }
        return commonCharsList;
    }


    public List<String> commonCharsWithIntArrayDictionary(String[] words) {
        int[] commonCharsDictionary = new int[26];
        
        int firstWordLength = words[0].length();
        
        for (int i = 0; i < firstWordLength; i++ ) {
            commonCharsDictionary[words[0].charAt(i) - 'a']++;
        }
        
        int noOfStrings = words.length;
        for (int i = 1; i < noOfStrings; i++) {
            int[] charMap = new int[26];
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                charMap[words[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (commonCharsDictionary[j] > charMap[j]) {
                    commonCharsDictionary[j] = charMap[j];
                }
            }
        }
        System.out.println("commonCharsDictionary : " + Arrays.toString(commonCharsDictionary));
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            if (commonCharsDictionary[i] != 0) {
                while(commonCharsDictionary[i]-- > 0) {
                    result.add("" + (char)(i + 'a'));
                }
                
            }
            
        }
        return result;
    }
}