/*
Class Name  : BaseballGame
Description : This class consists of the solution for BaseballGame.
Created Date: Nov 17, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/baseball-game/description/

Modification Log: 
Date				    Name                                            Description
Nov 17, 2022			Chandra Sekhar Reddy Muthumula					Added Class BaseballGame 
Nov 17, 2022			Chandra Sekhar Reddy Muthumula					Added Constructor RandomizedSet
Nov 17, 2022			Chandra Sekhar Reddy Muthumula					Added isNumeric
Dec 20, 2022			Chandra Sekhar Reddy Muthumula					Added calPointsBestApproach
Jul 18, 2023			Chandra Sekhar Reddy Muthumula					Added calPointsSingleIteration
--------------------------------------------------------------------------------------------------
682. Baseball Game
Easy
2K
1.7K
Companies
You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

An integer x.
Record a new score of x.
'+'.
Record a new score that is the sum of the previous two scores.
'D'.
Record a new score that is the double of the previous score.
'C'.
Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.

The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.

 

Example 1:

Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.
Example 2:

Input: ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation:
"5" - Add 5 to the record, record is now [5].
"-2" - Add -2 to the record, record is now [5, -2].
"4" - Add 4 to the record, record is now [5, -2, 4].
"C" - Invalidate and remove the previous score, record is now [5, -2].
"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
"9" - Add 9 to the record, record is now [5, -2, -4, 9].
"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
Example 3:

Input: ops = ["1","C"]
Output: 0
Explanation:
"1" - Add 1 to the record, record is now [1].
"C" - Invalidate and remove the previous score, record is now [].
Since the record is empty, the total sum is 0.
 

Constraints:

1 <= operations.length <= 1000
operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
For operation "+", there will always be at least two previous scores on the record.
For operations "C" and "D", there will always be at least one previous score on the record.
-------------------------------------------------------------------------------------------
*/
package Problems.BaseballGame;

import java.util.*;

public class BaseballGame {
    public static void main(String[] args) {

    }
    
    public int calPointsBestApproach(String[] operations) {
        Stack<Integer> score = new Stack<>();
        for (String opr : operations) {
            if (opr.equals("+")) {
                int head = score.pop();
                int newScore = head + score.peek();
                score.push(head);
                score.push(newScore);
            } else if (opr.equals("C")) {
                score.pop();
            } else if (opr.equals("D")) {
                score.push(2 * score.peek());
            } else {
                score.push(Integer.valueOf(opr));
            }
        }

        int scoreSum = 0;
        while(!score.isEmpty()) {
            scoreSum += score.pop();
        }
        return scoreSum;
    }

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = operations.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (isNumeric(operations[i])) {
                sum += stack.push(Integer.valueOf(operations[i]));
            } else {
                if (operations[i].equals("C")) {
                    sum -= stack.pop();
                } else if (operations[i].equals("D")) {
                    sum += stack.push(2 * stack.peek());
                } else if (operations[i].equals("+")) {
                    int popped_value = stack.pop();
                    sum += stack.push(stack.peek() + stack.push(popped_value));
                }
            }
            // System.out.println("Stack : " + stack);
        }
        return sum;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public int calPointsSingleIteration(String[] operations) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int len = operations.length;
        if(len == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int totalSum = 0;
        for(int i = 0; i < len; i++) {
            String currentOperation = operations[i];
            if(currentOperation.equals("C")) {
                if(stack.isEmpty() == false) {
                    totalSum -= stack.pop();
                }
            } else if(currentOperation.equals("D")) {
                int stackPeek = stack.peek();
                stack.push(stackPeek * 2); 
                totalSum += stack.peek();
            } else if(currentOperation.equals("+")) {
                int firstPrev = stack.pop();
                int secondPrev = stack.peek();
                stack.push(firstPrev);
                stack.push(firstPrev + secondPrev);
                totalSum += stack.peek();
            } else {
                stack.push(Integer.valueOf(currentOperation));
                totalSum += stack.peek();
            }
        }
        return totalSum;
    }
}