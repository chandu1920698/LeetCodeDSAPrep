/*
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

Java Script Code:

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
//     let start = 0;
//     if(s == ''){
//        return 0;
//     }
//     let stringArray = s.split('');
//     console.log(stringArray);
//     let subStringLengthArray = [];
//     let stringLength = stringArray.length;
//     console.log(stringLength);
//     if(0 <= stringLength <= 5 * Math.pow(10,4)) {
//        while (start < stringLength ) {
//         let subStringTempArray = '';
//         for (let index = start; index < stringLength; index++ ) {
//             if (subStringTempArray.indexOf(s.charAt(index)) == -1) {
//                 console.log('Char at index ' + index + '\''+s.charAt(index) + '\'');
//                 subStringTempArray = subStringTempArray + s.charAt(index);
//             } else {
//                 subStringLengthArray[start] = subStringTempArray.length;
//                 subStringTempArray = '';
//             }
//         }
//         console.log(subStringTempArray);
//         start++;
//         }
//     }
    
//     console.log(subStringLengthArray);
//     return Math.max(...subStringLengthArray);
    
    let left = 0;
    let result = 0;
    let charArray = [];
    let stringLength = s.length;
    // Here only singlr loop is used
    // Time complexity : O(n)
    // Space Complexity : O(n)
    // The method used is Sliding window approach
    for (let index = 0; index < stringLength; index++) {
        while (charArray.indexOf(s.charAt(index)) != -1) {
            charArray = charArray.slice(1);
            left++;
        }
        charArray.push(s.charAt(index));
        result = Math.max(result, index - left + 1);
        //console.log(charArray);
    }
    return result;
};