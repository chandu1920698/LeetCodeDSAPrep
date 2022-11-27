/*
Class Name  : AsteroidCollision
Description : This class consists of the solution for AsteroidCollision.
Date        : Nov 27, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/asteroid-collision/description/

Modification Log: 
Date				    Name                                            Description
Nov 27, 2022			Chandra Sekhar Reddy Muthumula					Added Class AsteroidCollision
Nov 27, 2022			Chandra Sekhar Reddy Muthumula					Added asteroidCollision
--------------------------------------------------------------------------------------------------
735. Asteroid Collision
Medium
4.4K
373
Companies
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
-------------------------------------------------------------------------------------------
*/

package Problems.AsteroidCollision;

import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (true) {
                    int peek = stack.peek();
                    if (peek < 0) {
                        stack.push(asteroids[i]);
                        break;
                    } else if (peek == -asteroids[i]) {
                        stack.pop();
                        break;
                    } else if (peek > -asteroids[i]) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int index = stack.size();
        int[] outPutArray = new int[index];
        while (!stack.isEmpty()) {
            outPutArray[--index] = stack.pop();
        }
        return outPutArray;
    }
}