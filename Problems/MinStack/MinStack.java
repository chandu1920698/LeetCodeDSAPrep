/*
Class Name  : MinStack
Description : This class consists of the solution for MinStack.
Date        : Nov 9, 2022
Author      : Chandra Sekhar Reddy Muthumula
Link        : https://leetcode.com/problems/min-stack/description/

Modification Log: 
Date				Name                                            Description
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added Class MinStack 
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added Class Node 
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added push 
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added pop 
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added getMin 
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added Constructor Node 
Nov 9, 2022			Chandra Sekhar Reddy Muthumula					Added Constructor MinStack 
--------------------------------------------------------------------------------------------------
155. Min Stack
Medium
10.1K
688
Companies
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
-------------------------------------------------------------------------------------------
*/
package Problems.MinStack;

public class MinStack {
    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}