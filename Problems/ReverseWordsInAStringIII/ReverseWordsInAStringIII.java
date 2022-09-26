/*
Class Name  : ReverseWordsInAStringIII
Description : This class consists of the solution for ReverseWordsInAStringIII.
Date        : Sep 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/

Modification Log: 
Date					Name                                            Description
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class ReverseWordsInAStringIII 
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added reverseString 
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added reverseChars
Sep 26, 2022			Chandra Sekhar Reddy Muthumula					Added reverseWords 
--------------------------------------------------------------------------------------------------
557. Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"

Constraints:

1 <= s.length <= 5 * 10^4
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
-------------------------------------------------------------------------------------------
*/

class ReverseWordsInAStringIII {
    // public String reverseWords(String s) {
    //     String[] splittedStrings = s.split(" ");
    //     int noOfStrings = splittedStrings.length;
    //     String finalString = "";
    //     for (int i=0; i<noOfStrings-1; i++) {
    //         finalString  += (reverseString(splittedStrings[i]) + " ");
    //     }
    //     finalString += reverseString(splittedStrings[noOfStrings-1]);
    //     return finalString;
    // }
    
    public String reverseString(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] charArray = s.toCharArray();
        while(start <= end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++; end--;
        }
        return new String(charArray);
        
        // return new String((new StringBuffer(s)).reverse());
    }
    
    public String reverseWords(String s) {

        // This is the most efficient way
        /*
        TC : O(N)
        SC : O(1)
        */
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int start = 0;
        int end = 0;
        for (int i=0; i<len; i++) {
            if (charArray[i] == ' ') {
                end = i-1;
                reverseChars(charArray,  start,  end );
                start = i+1;
            } else {
                end++;
            }
            
        }
        reverseChars(charArray,  start,  len-1);
        return new String(charArray);
    }
    
    public void reverseChars(char[] charArray, int start, int end ) {
        while(start <= end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++; end--;
        }
    }
}