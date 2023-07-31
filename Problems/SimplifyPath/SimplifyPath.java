/*
Class Name  : SimplifyPath
Description : This class consists of the solution for SimplifyPath.
Created Date: Feb 27, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/simplify-path/description/
Modification Log: 
Date					    Name                                            Description
Feb 27, 2022			    Chandra Sekhar Reddy Muthumula					Added Class SimplifyPath 
Feb 27, 2022			    Chandra Sekhar Reddy Muthumula					Added SimplifyPath
Jul 31, 2023			    Chandra Sekhar Reddy Muthumula					Added simplifyPathUsingStacks
--------------------------------------------------------------------------------------------------
71. Simplify Path
Medium
3.2K
646
Companies
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

 

Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 

Constraints:

1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.
------------------------------------------------------------------------------------------------------
*/
package Problems.SimplifyPath;
import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        /* 
         * TC : O(N)
         * SC : O(N)
        */
        LinkedList<String> stack = new LinkedList<>();
        for(String folder : path.split("/")) {
            if(folder.equals(".") || folder.equals("")) {
                continue;
            } else if(folder.equals("..")) {
                if(!stack.isEmpty()) {
                   stack.pollFirst(); 
                }
            } else {
                stack.offerFirst(folder);
            }
        }
        
        StringBuilder finalPath = new StringBuilder("/");
        while(!stack.isEmpty()) {
            finalPath.append(stack.pollLast() + "/");
        }
        if(finalPath.length() != 1) {
            finalPath.deleteCharAt(finalPath.length() - 1);
        }
        return new String(finalPath);
    }

    public String simplifyPathUsingStacks(String path) {
        /* 
         * TC : O(N) + O(N)
         * SC : O(N)
        */
        Stack<String> stack = new Stack<>();
        for(String s : path.split("/")) {
          System.out.println("Current Path : " + s);
          if(s.equals(".") || s.equals("")) {
            continue;
          } else if(s.equals("..")) {
            if(stack.isEmpty() == false) {
              stack.pop();
            }
          }else {
            stack.push(s);
          }
        }

        String finalPath = "";

        while(stack.isEmpty() == false) {
          finalPath = stack.pop() + "/"+ finalPath;
        }
        finalPath = "/" + finalPath;
        if(finalPath.equals("") || finalPath.equals("/")) {
          return "/";
        }
        if(finalPath.substring(finalPath.length() - 1, finalPath.length()).equals("/")) {
            finalPath = finalPath.substring(0, finalPath.length() - 1);
        }

        return finalPath;
    }
}
