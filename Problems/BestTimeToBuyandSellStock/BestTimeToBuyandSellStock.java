
/*
Class Name  : BestTimeToBuyandSellStock
Description : This class consists of the solution for BestTimeToBuyandSellStock.
Created Date: Sep 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
Modification Log: 
Date					Name                                            Description
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class BestTimeToBuyandSellStock 
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added maxProfit
Dec 26, 2022			Chandra Sekhar Reddy Muthumula					Added maxProfitStackApproach
Dec 26, 2022			Chandra Sekhar Reddy Muthumula					Added maxProfitBestApproach
--------------------------------------------------------------------------------------------------
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 10^5
0 <= prices[i] <= 104
------------------------------------------------------------------------------------------------------
*/
import java.util.*;

class BestTimeToBuyandSellStock {
    public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int overAllProfit = 0;
        // int todayProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyingPrice) {
                buyingPrice = prices[i];
            }
            overAllProfit = overAllProfit > prices[i] - buyingPrice ? overAllProfit : prices[i] - buyingPrice;
        }
        return overAllProfit;
    }

    public int maxProfitStackApproach(int[] prices) {
        /*
         * TC : O(N) + O(N)
         * SC : O(N) + O(N)
         */
        int len = prices.length;
        Stack<Integer> maxStack = new Stack<>();
        int[] profitArray = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!maxStack.isEmpty() && maxStack.peek() <= prices[i]) {
                maxStack.pop();
            }

            if (maxStack.isEmpty()) {
                profitArray[i] = -1;
            } else {
                profitArray[i] = maxStack.peek();
            }

            if (maxStack.isEmpty() || !maxStack.isEmpty() && maxStack.peek() < prices[i]) {
                maxStack.push(prices[i]);
            }
        }
        int maxGain = 0;
        for (int i = 0; i < len; i++) {
            if (profitArray[i] > 0) {
                maxGain = Math.max(maxGain, profitArray[i] - prices[i]);
            }
        }
        return maxGain;
    }
    public int maxProfitBestApproach(int[] prices) {
        int len = prices.length;
        int buyingPrice = Integer.MAX_VALUE;
        int maxGain = 0;
        for (int i = 0; i < len; i++) {
            // Buying price has to be minimum
            buyingPrice = Math.min(buyingPrice, prices[i]);
            // Selling price is todays price
            int sellingPrice = prices[i];
            maxGain = Math.max(maxGain, sellingPrice - buyingPrice);
        }
        return maxGain;
    }
}