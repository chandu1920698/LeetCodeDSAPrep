/*
Class Name  : PascalsTriangle
Description : This class consists of the solution for PascalsTriangle and PascalsTriangle2.
Date        : Sep 19, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/pascals-triangle/
Modification Log: 
Date					Name                                            Description
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class PascalsTriangle 
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added generate
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added Class PascalsTriangle2 
Sep 19, 2022			Chandra Sekhar Reddy Muthumula					Added getRow
--------------------------------------------------------------------------------------------------
118. PascalsTriangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30
------------------------------------------------------------------------------------------------------
*/
class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTraiangle = new ArrayList<List<Integer>>();
        for (int i=0; i<numRows; i++) {
            List<Integer> tempPascal = new ArrayList<Integer>();
            int temp = 1;
            for(int k=0; k<=i; k++) {
                tempPascal.add(temp);
                temp = (i==k) ? 0 : (temp * (i-k))/(k+1);
            }
            pascalTraiangle.add(tempPascal);
        }
        return pascalTraiangle;
    }
}
-----------------------------------------------------------------------------------------------------
/*
119. PascalsTriangle2

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]

Constraints:

0 <= rowIndex <= 33
 

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
*/

class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascalTriangleRow = new ArrayList<Integer>();
        long temp = 1;
        // rowIndex--;
        for (int k=0; k<=rowIndex; k++) {
            pascalTriangleRow.add((int)temp);
            temp = (temp*(rowIndex-k))/(k+1);
        }
        return pascalTriangleRow;
    }
}