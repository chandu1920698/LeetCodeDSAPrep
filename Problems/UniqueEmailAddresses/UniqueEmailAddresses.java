/*
Class Name  : UniqueEmailAddresses
Description : This class consists of the solution for UniqueEmailAddresses.
Date        : Oct 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/unique-email-addresses/

Modification Log: 
Date					Name                                            Description
Oct 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class UniqueEmailAddresses 
Oct 19, 2022			Chandra Sekhar Reddy Muthumula					Added numUniqueEmails 
--------------------------------------------------------------------------------------------------
929. Unique Email Addresses

Every valid email consists of a local name and a domain name, separated by the '@' sign. 
Besides lowercase letters, the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address, 
mail sent there will be forwarded to the same address without dots in the local name. 
Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
If you add a plus '+' in the local name, everything after the first plus sign will be ignored. 
This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".
It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each emails[i], 
return the number of different addresses that actually receive mails.

 

Example 1:

Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
Example 2:

Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
Output: 3

Constraints:

1 <= emails.length <= 100
1 <= emails[i].length <= 100
emails[i] consist of lowercase English letters, '+', '.' and '@'.
Each emails[i] contains exactly one '@' character.
All local and domain names are non-empty.
Local names do not start with a '+' character.
Domain names end with the ".com" suffix.
-------------------------------------------------------------------------------------------
*/
package Problems.UniqueEmailAddresses;
import java.util.*;;
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>();
        for (String email : emails) {
            if (!email.split("@")[1].endsWith(".com")) continue;
            // names[0] => Local Name
            // names[1] => Domain Name
            String[] names = email.split("@");
            if(names[0].startsWith("+")) continue;
            
            // Remove all the periods from local name
            normalized.add(names[0].split("\\+")[0].replace(".", "") + "@" + names[1]);    
            
        }
        return normalized.size();
    }
}