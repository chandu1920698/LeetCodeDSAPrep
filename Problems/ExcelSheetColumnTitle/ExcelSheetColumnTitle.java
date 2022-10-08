/*
Class Name  : ExcelSheetColumnTitle
Description : This class consists of the solution for ExcelSheetColumnTitle.
Date        : Oct 8, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/excel-sheet-column-title/

Modification Log: 
Date				Name                                            Description
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added Class ExcelSheetColumnTitle 
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added convertToTitle
Oct 8, 2022			Chandra Sekhar Reddy Muthumula					Added chooseAlphabet
--------------------------------------------------------------------------------------------------
168. Excel Sheet Column Title

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
 

Constraints:

1 <= columnNumber <= 231 - 1
-------------------------------------------------------------------------------------------
*/
package Problems.ExcelSheetColumnTitle;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        int len = (int) ((Math.log(columnNumber)/Math.log(26))+1);
        char[] string = new char[len];
        int index = len - 1;
        while(columnNumber>0 && index >= 0){
            string[index--] = chooseAlphabet(columnNumber % 26);
            columnNumber--;
            columnNumber /= 26;
        }
        System.out.println("String : " + Arrays.toString(string));
        return (new String(string)).trim();
    }
    
    public char chooseAlphabet(int n) {
        switch (n) {
            case 1 : return 'A';

            case 2 : return 'B';

            case 3 : return 'C';

            case 4 : return 'D';

            case 5 : return 'E';

            case 6 : return 'F';

            case 7 : return 'G';

            case 8 : return 'H';

            case 9 : return 'I';

            case 10 : return 'J';

            case 11 : return 'K';

            case 12 : return 'L';

            case 13 : return 'M';

            case 14 : return 'N';

            case 15 : return 'O';

            case 16 : return 'P';

            case 17 : return 'Q';

            case 18 : return 'R';

            case 19 : return 'S';

            case 20 : return 'T';

            case 21 : return 'U';

            case 22 : return 'V';

            case 23 : return 'W';

            case 24 : return 'X';

            case 25 : return 'Y';

            default : return 'Z';
                        
        }
    }
}