/*
Class Name  : JewelsAndStones
Description : This class consists of the solution for JewelsAndStones.
Date        : Sep 14, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/jewels-and-stones/

Modification Log: 
Date					Name                                            Description
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added Class JewelsAndStones 
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added numJewelsInStones 
Sep 13, 2022			Chandra Sekhar Reddy Muthumula					Added isAllCharactersOfJewelsUnique
--------------------------------------------------------------------------------------------------

771. Jewels and Stones
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
Each character in stones is a type of stone you have. 
You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".


Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0
 
Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.

*/
import java.util.*;;
class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        // int noOfJewels = jewels.length();
        // int noOfStones = stones.length();
        int finalCount = 0;
        if (1 <= jewels.length() && stones.length() <= 50 ) {
			
			/*
			TC 			: O(N^2)
			SC 			: O(1)
			Recommended : NA
			*/
		
		
            // for (int i=0; i<noOfJewels; i++) {
            //     for (int j=0; j<noOfStones; j++) {
            //         if (jewels.charAt(i) == stones.charAt(j)) {
            //             finalCount++;
            //         }
            //     }
            // }
			
			/*
			TC 			: O(J+S)
			SC 			: O(J)
			Recommended : Yes
			*/
            Set setJ = new HashSet();
            for (char j : jewels.toCharArray()) {
                setJ.add(j);
            }
            for (char s : stones.toCharArray()) {
                finalCount = setJ.contains(s) ? ++finalCount : finalCount;
            }
        }
       return finalCount; 
    }

	// I think this function is not needed. Because, the HashSet will take of this duplicity.
    public boolean isAllCharactersOfJewelsUnique(String jewels) {
        int jewelsLength = jewels.length();
        for (int i=0; i<jewelsLength; i++) {
            for (int j = i+1; j<jewelsLength-1; j++) {
                if (jewels.charAt(i) == jewels.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}