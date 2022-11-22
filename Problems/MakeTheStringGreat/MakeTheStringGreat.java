/*
Class Name  : MakeTheStringGreat
Description : This class consists of the solution for MakeTheStringGreat.
Date        : Nov 22, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/make-the-string-great/description/

Modification Log: 
Date				    Name                                            Description
Nov 22, 2022			Chandra Sekhar Reddy Muthumula					Added Class MakeTheStringGreat
Nov 22, 2022			Chandra Sekhar Reddy Muthumula					Added makeGoodStringBuilder
Nov 22, 2022			Chandra Sekhar Reddy Muthumula					Added makeGoodUsingStack
--------------------------------------------------------------------------------------------------
1544. Make The String Great
Easy
2.1K
91
Companies
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.

 

Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "s"
Output: "s"
 

Constraints:

1 <= s.length <= 100
s contains only lower and upper case English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.MakeTheStringGreat;

import java.util.*;

public class MakeTheStringGreat {

    public String makeGoodUsingStack(String s) {
        /*
         * TC : O(N) + O(N)
         * SC : O(N) + O(N)
         */
        int stringLen = s.length();
        if (stringLen <= 1)
            return s;

        Stack<Character> charStack = new Stack<Character>();
        for (int i = 0; i < stringLen; i++) {
            if (!charStack.isEmpty() && ((char) (charStack.peek() + 32) == s.charAt(i)
                    || (char) (charStack.peek() - 32) == s.charAt(i))) {
                charStack.pop();
            } else {
                charStack.push(s.charAt(i));
            }
        }

        char[] charArray = new char[charStack.size()];
        int index = charStack.size();
        while (!charStack.isEmpty()) {
            charArray[--index] = charStack.pop();
        }
        return new String(charArray);
    }

    public String makeGoodStringBuilder(String s) {
        /*
         * TC : O(N)
         * SC : O(N)
         */
        int stringLen = s.length();
        if (stringLen <= 1)
            return s;
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < stringLen; i++) {
            int stringBuilderSize = resultString.length();
            char currentCharacter = s.charAt(i);
            if (stringBuilderSize > 0 && ((char) (resultString.charAt(stringBuilderSize - 1) + 32) == currentCharacter
                    || (char) (resultString.charAt(stringBuilderSize - 1) - 32) == currentCharacter)) {
                resultString.deleteCharAt(stringBuilderSize - 1);
            } else {
                resultString.append(s.charAt(i));
            }
        }
        return new String(resultString);
    }
}