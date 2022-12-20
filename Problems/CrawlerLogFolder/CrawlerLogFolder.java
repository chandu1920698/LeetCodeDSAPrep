/*
Class Name  : CrawlerLogFolder
Description : This class consists of the solution for CrawlerLogFolder.
Created Date: Dec 20, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/crawler-log-folder/description/
Modification Log: 
Date					Name                                            Description
Dec 20, 2022			Chandra Sekhar Reddy Muthumula					Added Class CrawlerLogFolder 
Dec 20, 2022			Chandra Sekhar Reddy Muthumula					Added minOperations
--------------------------------------------------------------------------------------------------
1598. Crawler Log Folder
Easy
680
50
Companies
The Leetcode file system keeps a log each time some user performs a change folder operation.

The operations are described below:

"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
"./" : Remain in the same folder.
"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

The file system starts in the main folder, then the operations in logs are performed.

Return the minimum number of operations needed to go back to the main folder after the change folder operations.

 

Example 1:



Input: logs = ["d1/","d2/","../","d21/","./"]
Output: 2
Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
Example 2:



Input: logs = ["d1/","d2/","./","d3/","../","d31/"]
Output: 3
Example 3:

Input: logs = ["d1/","../","../","../"]
Output: 0
 

Constraints:

1 <= logs.length <= 103
2 <= logs[i].length <= 10
logs[i] contains lowercase English letters, digits, '.', and '/'.
logs[i] follows the format described in the statement.
Folder names consist of lowercase English letters and digits.
------------------------------------------------------------------------------------------------------
*/
package Problems.CrawlerLogFolder;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        /* 
         * TC : O(N)
         * SC : O(1)
        */
        int folders = 0;

        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            } else if (log.equals("../")) {
                if (folders > 0) {
                    folders--;
                }
            } else {
                folders++;
            }
        }

        return folders;
    }
}