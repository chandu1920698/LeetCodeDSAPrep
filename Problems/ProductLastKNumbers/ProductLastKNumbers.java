/*
Class Name  : ProductLastKNumbers
Description : This class consists of the solution for ProductLastKNumbers.
Date        : Nov 30, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/product-of-the-last-k-numbers/description/

Modification Log: 
Date				    Name                                            Description
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added Class ProductLastKNumbers
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added Constructor ProductLastKNumbers
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added add
Nov 30, 2022			Chandra Sekhar Reddy Muthumula					Added getProduct
--------------------------------------------------------------------------------------------------
1352. Product of the Last K Numbers
Medium
1.2K
59
Companies
Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

Implement the ProductOfNumbers class:

ProductOfNumbers() Initializes the object with an empty stream.
void add(int num) Appends the integer num to the stream.
int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.
The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.

 

Example:

Input
["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

Output
[null,null,null,null,null,null,20,40,0,null,32]

Explanation
ProductOfNumbers productOfNumbers = new ProductOfNumbers();
productOfNumbers.add(3);        // [3]
productOfNumbers.add(0);        // [3,0]
productOfNumbers.add(2);        // [3,0,2]
productOfNumbers.add(5);        // [3,0,2,5]
productOfNumbers.add(4);        // [3,0,2,5,4]
productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
productOfNumbers.add(8);        // [3,0,2,5,4,8]
productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32 
 

Constraints:

0 <= num <= 100
1 <= k <= 4 * 104
At most 4 * 104 calls will be made to add and getProduct.
The product of the stream at any point in time will fit in a 32-bit integer.
-------------------------------------------------------------------------------------------
*/

package Problems.ProductLastKNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProductLastKNumbers {
    // This is the Brute force method
    /*
    * TC : O(N ^2)
    * SC : O(N ^2)
    */
    /*
    
    Stack<Integer> stack;
    public ProductLastKNumbers() {
        stack = new Stack<Integer>();
    }
    
    public void add(int num) {
        stack.push(num);
    }
    
    public int getProduct(int k) {
        int[] arr = new int[k];
        long product = 1;
        while (!stack.isEmpty() && k > 0) {
            arr[--k] = stack.pop();
            product *= arr[k];
        }
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        return (int)product;
    }

    */

    // This is the Best Approach
    /*
    * TC : O(N)
    * SC : O(N)
    */
    static List<Integer> productList;
    static int product;
    public ProductLastKNumbers() {
       productList = new ArrayList<Integer>();
       product = 1;
    }
    
    public void add(int num) {
        if (num == 0) {
            productList = new ArrayList<Integer>();
            product = 1;
            return;
        }
        product *= num;
        productList.add(product);
    }
    
    public int getProduct(int k) {
        int productListSize = productList.size();
        if (productListSize < k) return 0;
        int ans = productList.get(productListSize -  1);
        if(productListSize == k) return ans;
        return ans/productList.get(productListSize - 1 - k);
    }
}