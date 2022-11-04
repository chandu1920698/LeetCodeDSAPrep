/*
Class Name  : OnesAndZeroes
Description : This class consists of the solution for OnesAndZeroes.
Date        : Nov 4, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/ones-and-zeroes/

Modification Log: 
Date				Name                                            Description
Nov 4, 2022			Chandra Sekhar Reddy Muthumula					Added Class OnesAndZeroes 
Nov 4, 2022			Chandra Sekhar Reddy Muthumula					Added findShortestSubArray
--------------------------------------------------------------------------------------------------
474. Ones and Zeroes

You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that 
there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

 

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 

Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100
-------------------------------------------------------------------------------------------
*/
package Problems.OnesAndZeroes;

import java.util.*;

public class OnesAndZeroes {
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[] {"10","0001","111001","1","0"}, 5, 3));
    }
    /*
    * This does not pass all the test cases
    * Need to go for Dynamic Programming

    public int findMaxForm(String[] strs, int m, int n) {

        Arrays.sort(strs, Comparator.comparing(s -> s.length()));
        int strs_len = strs.length;
        for (int i = 0; i + 1 < strs_len; i++) {
            int min_index = i;
            for (int j = i + 1; j < strs_len; j++) {
                if (strs[j].length() < strs[min_index].length()) {
                    min_index = j;
                }
            }

            if (min_index != i) {
                String swap_temp = strs[min_index];
                strs[min_index] = strs[i];
                strs[i] = swap_temp;
            }
        }
        System.out.println(Arrays.toString(strs));

        int[] zero_one_count = new int[2];
        int subset_count = 0;
        for (String str : strs) {
            int str_len = str.length();
            int i = 0;
            int zero_count = 0;
            int one_count = 0;
            for (i = 0; i < str_len; i++) {
                if (str.charAt(i) == '0') {
                    if (zero_one_count[0] + 1 <= m) {
                        zero_count++;
                        zero_one_count[0]++;
                    } else {
                        zero_one_count[0] -= zero_count;
                        break;
                    }
                } else {
                    if (zero_one_count[1] + 1 <= n) {
                        one_count++;
                        zero_one_count[1]++;
                    } else {
                        zero_one_count[1] -= one_count;
                        break;
                    }
                }
                if (i == str_len - 1)
                    subset_count++;
            }
        }
        return subset_count;
    }
    */

    // static List<List<List<>>> dp_matrix = new ArrayList<List<List<>>>();
    static int[][][] dp_matrix;

    public static int findMaxForm(String[] strs, int m, int n) {
        dp_matrix = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i < strs.length + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    dp_matrix[i][j][k] = -1;
                }
            }
        }
        return findMaxFormHelper(strs, m, n, 0);
    }
    
    public static int findMaxFormHelper(String[] strs, int m, int n, int index) {
        if (index == strs.length || (m == 0 && n == 0)) {
            return 0;
        }
        if (dp_matrix[index][m][n] != -1) {
            return dp_matrix[index][m][n];
        }
        int zeros_count = 0;
        int str_len = strs[index].length();
        for (int i = 0; i < str_len; i++) {
            if (strs[index].charAt(i) == '0') {
                zeros_count++;
            }
        }
        int ones_count = str_len - zeros_count;
        if (m - zeros_count < 0 || n - ones_count < 0) {
            return findMaxFormHelper(strs, m, n, index + 1);
        }
        
        int included = 1 + findMaxFormHelper(strs, m - zeros_count, n - ones_count, index + 1);
        int excluded = findMaxFormHelper(strs, m, n, index + 1);
        dp_matrix[index][m][n] = Math.max(included, excluded);
        return dp_matrix[index][m][n];
    }

    public int findMaxFormBestMethod(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (String s: strs){
            // Step1: count zero and one.
            int[] arr = countZeroAndOne(s);

            for (int i = m; i >= arr[0]; i--){
                for (int j = n; j >= arr[1]; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - arr[0]][j - arr[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    
    private int[] countZeroAndOne(String s) {
        int zero = 0;
        int one  = 0;
        for (char c: s.toCharArray()){
            if (c == '0'){
                zero++;
            } else if (c == '1'){
                one++;
            }
        }
        return new int[]{zero, one};
    }
}