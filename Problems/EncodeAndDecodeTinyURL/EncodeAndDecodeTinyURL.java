/*
Class Name  : EncodeAndDecodeTinyURL
Description : This class consists of the solution for EncodeAndDecodeTinyURL.
Date        : Oct 20, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/encode-and-decode-tinyurl/

Modification Log: 
Date					Name                                            Description
Oct 20, 2022			Chandra Sekhar Reddy Muthumula					Added Class EncodeAndDecodeTinyURL 
Oct 20, 2022			Chandra Sekhar Reddy Muthumula					Added lengthOfLastWord
--------------------------------------------------------------------------------------------------
535. Encode and Decode TinyURL

Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL 
such as https://leetcode.com/problems/design-tinyurl and it returns a short URL 
such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

Implement the Solution class:

Solution() Initializes the object of the system.
String encode(String longUrl) Returns a tiny URL for the given longUrl.
String decode(String shortUrl) Returns the original long URL for the given shortUrl. 
It is guaranteed that the given shortUrl was encoded by the same object.
 

Example 1:

Input: url = "https://leetcode.com/problems/design-tinyurl"
Output: "https://leetcode.com/problems/design-tinyurl"

Explanation:
Solution obj = new Solution();
string tiny = obj.encode(url); // returns the encoded tiny url.
string ans = obj.decode(tiny); // returns the original url after deconding it.
 

Constraints:

1 <= url.length <= 104
url is guranteed to be a valid URL.
-------------------------------------------------------------------------------------------
*/
package Problems.EncodeAndDecodeTinyURL;
import java.util.*;;
public class EncodeAndDecodeTinyURL {
    HashMap<String, String> map = new HashMap<String, String>();
    int urlCount = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = "http://tinyurl.com/" + (++urlCount);
        this.map.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.map.get(shortUrl);
    }
}