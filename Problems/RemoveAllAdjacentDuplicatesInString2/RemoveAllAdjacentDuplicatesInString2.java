/*
Class Name  : RemoveAllAdjacentDuplicatesInString2
Description : This class consists of the solution for RemoveAllAdjacentDuplicatesInString2.
Date        : Nov 30, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/

Modification Log: 
Date				    Name                                            Description
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added Class RemoveAllAdjacentDuplicatesInString2
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added removeDuplicatesFasterApproach
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added removeDuplicatesMediumApproach
--------------------------------------------------------------------------------------------------
1209. Remove All Adjacent Duplicates in String II
Medium
4.8K
87
Companies
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lowercase English letters.
-------------------------------------------------------------------------------------------
*/

package Problems.RemoveAllAdjacentDuplicatesInString2;
import java.util.Stack;;
public class RemoveAllAdjacentDuplicatesInString2 {
    
    public String removeDuplicatesFasterApproach(String s, int k) {
        /*
         * This is using String Builder and Stack
         * TC : O(N)
         * SC : O(N)
        */
        int len = s.length();
        if (len < k) return s;
        Stack<Integer> countStack = new Stack<>();
        StringBuilder string = new StringBuilder();
        int tempK = 0;
        for (int i = 0; i < len; i++) {
            int stringSize = string.length();
            if (stringSize == 0 || string.charAt(stringSize - 1) != s.charAt(i)) {
                string.append(s.charAt(i));
                countStack.push(tempK);
                tempK = 1;
            } else{
                string.append(s.charAt(i));
                tempK++;
            }
            
            if (tempK == k) {
                while(string.length() != 0 && tempK-- > 0) {
                    string.deleteCharAt(string.length() - 1);
                }
                if (string.length() != 0) tempK = countStack.pop();
            }
        }
        return new String (string);
    }

    public String removeDuplicatesMediumApproach(String s, int k) {
        /*
         * This is using only Stacks
         * TC : O(N)
         * SC : O(N)
        */
        int len = s.length();
        if (len < k) return s;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int tempK = 0;
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
                countStack.push(tempK);
                tempK = 1;
            } else{
                stack.push(s.charAt(i));
                tempK++;
            }
            
            if (tempK == k) {
                // System.out.println("Stack : " + stack + " -> tempK : " + tempK);
                while(!stack.isEmpty() && tempK > 0) {
                    stack.pop();
                    tempK--;
                }
                if (!stack.isEmpty()) tempK = countStack.pop();
                
            }
        }
        int charArraySize = stack.size();
        char[] charArray = new char[charArraySize];
        while(!stack.isEmpty()) {
            charArray[--charArraySize] = stack.pop();
        }
        return new String (charArray);
    }
}