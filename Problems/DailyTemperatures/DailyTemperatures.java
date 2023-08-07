/*
Class Name  : DailyTemperatures
Description : This class consists of the solution for DailyTemperatures.
Date        : Nov 26, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/daily-temperatures/description/

Modification Log: 
Date				    Name                                            Description
Nov 26, 2022			Chandra Sekhar Reddy Muthumula					Added Class DailyTemperatures
Nov 26, 2022			Chandra Sekhar Reddy Muthumula					Added dailyTemperatures
Nov 26, 2022			Chandra Sekhar Reddy Muthumula					Added dailyTemperaturesBruteForce
Aug 07, 2023			Chandra Sekhar Reddy Muthumula					Added dailyTemperatures2
--------------------------------------------------------------------------------------------------
739. Daily Temperatures
Medium
8.7K
201
Companies
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
1 ≤ Ai ≤ 1018
-------------------------------------------------------------------------------------------
*/
package Problems.DailyTemperatures;

import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();

            }
            if (stack.isEmpty() == true) {
                result[i] = 0;
                stack.push(i);
            } else {

                result[i] = stack.peek() - i;
                stack.push(i);
            }

        }
        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        /*
         * This is using stack data structure TC : O(N) SC : O(N)
         */
        int len = temperatures.length;
        if (len == 1)
            return new int[] { 0 };
        int[] result = new int[len];
        Stack<Integer> indexStack = new Stack<>();
        for (int currentDay = 0; currentDay < len; currentDay++) {
            while (!indexStack.isEmpty() && temperatures[currentDay] > temperatures[indexStack.peek()]) {
                int prevDay = indexStack.pop();
                result[prevDay] = currentDay - prevDay;
            }
            indexStack.push(currentDay);
        }
        return result;
    }

    public int[] dailyTemperaturesBruteForce(int[] temperatures) {
        /*
         * TC : O(N ^ 2) SC : O(1)
         */
        int len = temperatures.length;
        int[] result = new int[len];
        // Brute Force
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                }
            }

        }
        return result;
    }

}