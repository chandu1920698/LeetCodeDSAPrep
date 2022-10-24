
/*
Class Name  : SearchSuggestionsSystem
Description : This class consists of the solution for SearchSuggestionsSystem.
Date        : Oct 24, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/search-suggestions-system/

Modification Log: 
Date					Name                                            Description
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added Class SearchSuggestionsSystem 
Oct 24, 2022			Chandra Sekhar Reddy Muthumula					Added searchRange 
--------------------------------------------------------------------------------------------------
1268. Search Suggestions System

You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. 
Suggested products should have common prefix with searchWord. 
If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.
 

Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.
-------------------------------------------------------------------------------------------
*/
package Problems.SearchSuggestionsSystem;

import java.util.*;

public class SearchSuggestionsSystem {
    public static void main(String[] args) {
        // System.out.println(suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
        System.out.println(suggestedProducts(new String[] {"code","codephone","coddle","coddles","codes"}, "coddle"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list =  new ArrayList<>();
        // Sort the list of products based on alphabetical order
        // So that the searching of products becomes easy
        Arrays.sort(products);
        // System.out.println("Prod : " + Arrays.toString(products));
        
        int searchWordLength = searchWord.length();
        for (int i = 0; i < searchWordLength; i++) {
            List<String> matchingProducts = new ArrayList<>();
            int count = 0;
            for (String product : products) {
                // Conditions:
                // 1. No of products returned should be first 3 only, so used the count variable
                // 2. Implemented the (i + 1) condoition to avoid the index out of bound exception
                // 3. Finally match the substrings of product with the searchword
                if(count < 3 &&  (i + 1) <= product.length() && (i + 1) <= searchWordLength && product.substring(0, i + 1).equals(searchWord.substring(0, i + 1))) {
                    // Add the product the temp prpduct list
                    matchingProducts.add(product);
                    count++;
                }
            }
            // Add all the products to the final result list
            list.add(matchingProducts);
        }
        
        return list;
    }


    public static List<List<String>> suggestedProductsNeedToCheckThis(String[] products, String searchWord) {
        List<List<String>> list =  new ArrayList<>();
        // Sort the list of products based on alphabetical order
        // So that the searching of products becomes easy
        Arrays.sort(products);
        // System.out.println("Prod : " + Arrays.toString(products));
        
        
        int noOfProducts = products.length;
        
        int searchWordLength = searchWord.length();
        for (int i = 0; i < searchWordLength; i++) {
            List<String> matchingProducts = new ArrayList<>();
            String sWord = searchWord.substring(0, i + 1);
            
            int start = 0;
            int end = noOfProducts - 1;
            
            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                // if((i + 1) <= products[mid].length() && (i + 1) <= searchWordLength) {
                    
                   if(sWord.compareTo(products[mid].substring(0, i + 1)) == 0) {

                        int firstIndex = mid;

                        while(firstIndex - 1 >= 0 && (i + 1) <= products[firstIndex].length() &&  products[firstIndex].substring(0, i + 1).equals(sWord) == products[firstIndex - 1].substring(0, i + 1).equals(sWord)) firstIndex--;

                        int count = 0;
                        for (count = 0; count < 3; count++) {
                            if(firstIndex < noOfProducts && (i + 1) <= products[firstIndex].length() && products[firstIndex].substring(0, i + 1).equals(sWord)) {
                                matchingProducts.add(products[firstIndex++]);
                            }
                        }
                        break;

                    } else if(sWord.compareTo(products[mid].substring(0, i + 1)) > 0) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    } 
                // } else break;
            }
            // Add all the products to the final result list
            list.add(matchingProducts);
        }
        return list;
    }
}