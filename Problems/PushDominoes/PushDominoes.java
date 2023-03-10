/*
Class Name  : PushDominoes
Description : This class consists of the solution for PushDominoes.
Created Date: Mar 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/push-dominoes/description/
Modification Log: 
Date					    Name                                            Description
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added Class PushDominoes
Mar 10, 2022			    Chandra Sekhar Reddy Muthumula					Added pushDominoes 
--------------------------------------------------------------------------------------------------
838. Push Dominoes
Medium
3.1K
192
Companies
There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

 

Example 1:

Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Example 2:


Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 

Constraints:

n == dominoes.length
1 <= n <= 105
dominoes[i] is either 'L', 'R', or '.'.
------------------------------------------------------------------------------------------------------
*/
package Problems.PushDominoes;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        int len = dominoes.length();
        if (len == 1) return dominoes;
        char[] rightFallDominos = dominoes.toCharArray();
        char[] leftFallDominos = dominoes.toCharArray();
        for(int i = 1; i < len; i++) {
            if(rightFallDominos[i] == '.' && rightFallDominos[i - 1] == 'R') {
                rightFallDominos[i] = 'R';
            }
            if(leftFallDominos[len - 1 - i] == '.' && leftFallDominos[len - i] == 'L') {
                leftFallDominos[len - 1 - i] = 'L';
            }
        }
        // System.out.println(new String(rightFallDominos));
        // System.out.println(new String(leftFallDominos));
        char[] finalDominos = new char[len];
        for(int i = 0; i < len; i++) {
            if(rightFallDominos[i] == '.') {
                finalDominos[i] = leftFallDominos[i];
            } else if(leftFallDominos[i] == '.' || rightFallDominos[i] == leftFallDominos[i]) {
                finalDominos[i] = rightFallDominos[i];
            } else {
                int start = i;
                int end = i;
                while(rightFallDominos[end] != leftFallDominos[end]) {
                    end++;
                }
                end--;
                i += (end - start);
                // System.out.println("Start : " + start + " end : " + end + " i : " + i);
                while(start <= end) {
                    if(start == end) {
                        finalDominos[start] = '.';
                        break;
                    }
                    finalDominos[start] = 'R';
                    finalDominos[end] = 'L';
                    start++;
                    end--;
                }
            }
        }
        return new String(finalDominos);
    }
}