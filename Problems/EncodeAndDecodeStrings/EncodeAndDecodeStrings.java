/*
Class Name  : IntersectionOfTwoArrays
Description : This class consists of the solution for IntersectionOfTwoArrays.
Date        : Oct 5, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/intersection-of-two-arrays/

Modification Log: 
Date					Name                                            Description
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added Class IntersectionOfTwoArrays 
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added intersection 
Oct 5, 2022			Chandra Sekhar Reddy Muthumula					Added binarySearch 
--------------------------------------------------------------------------------------------------
659 · Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. 
The encoded string is then sent over the network and is decoded back to the original list of strings.

Example:

Example1
Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"


Example2
Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes
-------------------------------------------------------------------------------------------
*/package Problems.EncodeAndDecodeStrings;

public class EncodeAndDecodeStrings {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        int len = strs.size();
        String encoded = "";
        for (int i = 0; i < len - 1; i++) {
            encoded += (strs.get(i) + ":;");
        }
        encoded += strs.get(strs.size() - 1);
        // System.out.print("Encoded : " + encoded);
        return encoded;
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        String[] decoded = str.split(":;");
        int len = decoded.length;
        for (int i = 0; i < len; i++) {
            if(decoded[i] == "::") {
                decoded[i] = ":";
            }
        }
        return Arrays.asList(decoded);
    }
}