/*
Class Name  : OnlineStockSpan
Description : This class consists of the solution for OnlineStockSpan.
Created Date: Feb 28, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/online-stock-span/description/
Modification Log: 
Date					    Name                                            Description
Feb 28, 2023			    Chandra Sekhar Reddy Muthumula					Added Class OnlineStockSpan
Feb 28, 2023			    Chandra Sekhar Reddy Muthumula					Added StockSpanner 
Feb 28, 2023			    Chandra Sekhar Reddy Muthumula					Added next 
Aug 02, 2023			    Chandra Sekhar Reddy Muthumula					Added Class OnlineStockSpan2
Aug 02, 2023			    Chandra Sekhar Reddy Muthumula					Added StockSpanner2
Aug 02, 2023			    Chandra Sekhar Reddy Muthumula					Added next2 
--------------------------------------------------------------------------------------------------
901. Online Stock Span
Medium
5K
314
Companies
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 

Constraints:

1 <= price <= 105
At most 104 calls will be made to next.
------------------------------------------------------------------------------------------------------
*/
package Problems.OnlineStockSpan;
import java.util.*;
public class OnlineStockSpan {
    class StockSpanner {
        Stack<int[]> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }
        
        public int next(int price) {
            /* 
             * TC : O(N)
             * SC : O(N)
            */
            
            int span = 1;
            while(!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }
            stack.push(new int[] {price, span});
            return span;
        }
    }

    class StockSpanner2 {
        List<Integer> array;
        public StockSpanner2() {
            array = new ArrayList<>();
        }
        
        public int next2(int price) {
            /* 
             * TC : O(N * N)
             * SC : O(N)
            */
            int span = 1;
            for(int i = array.size() - 1; i >=0; i--) {
                if(array.get(i) > price) {
                    break;
                } else {
                    span++;
                }
            }
            array.add(price);
            return span;
        }
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */