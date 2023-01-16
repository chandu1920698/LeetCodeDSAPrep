/*
Class Name  : DesignLinkedList
Description : This class consists of the solution for DesignLinkedList.
Created Date: Jan 16, 2023
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/design-linked-list/description/

Modification Log: 
Date				    Name                                            Description
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added Class DesignLinkedList
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added DesignLinkedList
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added get
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added addAtHead
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added addAtTail
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added addAtIndex
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added deleteAtIndex
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added deleteHead
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added deleteTail
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added printList
Jan 16, 2022			Chandra Sekhar Reddy Muthumula					Added getNodeAtIndex
--------------------------------------------------------------------------------------------------
707. Design Linked List
Medium
2K
1.4K
Companies
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, 
and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. 
Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. 
After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. 
If index equals the length of the linked list, the node will be appended to the end of the linked list. 
If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 

Constraints:

0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
-------------------------------------------------------------------------------------------
*/

package Problems.DesignLinkedList;

public class DesignLinkedList {
    Node head;
    Node tail;
    int size;

    public DesignLinkedList() {
        this.size = 0;
    }

    public int get(int index) {
        if (index > this.size - 1) {
            return -1;
        } else {
            Node tempHead = this.head;
            while (index > 0) {
                tempHead = tempHead.next;
                index--;
            }
            return tempHead.val;
        }
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            head = node;
        }
        this.size++;
        // System.out.println("addAtHead: size -> " + this.size + " Head : " +
        // this.head.val + "Tail : " + this.tail.val);
        // printList(this.head);
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (this.tail == null) {
            this.tail = node;
            this.head = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
        // System.out.println("addAtTail : size -> " + this.size + " Head : " +
        // this.head.val + "Tail : " + this.tail.val);
        // printList(this.head);
    }

    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= this.size) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == this.size) {
                addAtTail(val);
            } else {
                Node prevNode = getNodeAtIndex(index - 1);
                Node node = new Node(val);
                node.next = prevNode.next;
                prevNode.next = node;

                this.size++;
                // System.out.println("addAtIndex: size -> " + this.size+ " Head : " +
                // this.head.val + "Tail : " + this.tail.val);
                // printList(this.head);
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < this.size) {
            if (index == 0) {
                deleteHead();
            } else if (index == this.size - 1) {
                deleteTail();
            } else {
                Node prevNode = getNodeAtIndex(index - 1);
                prevNode.next = prevNode.next.next;
                this.size--;
                // System.out.println("deleteAtIndex : size -> " + this.size+ " Head : " +
                // this.head.val + "Tail : " + this.tail.val);
                // printList(this.head);
            }
        }

    }

    private void deleteHead() {
        if (this.head == null) {
            return;
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            head = head.next;
        }
        this.size--;
        // System.out.println("deleteHead : size -> " + this.size+ " Head : " +
        // this.head.val + "Tail : " + this.tail.val);
        // printList(this.head);
    }

    private void deleteTail() {
        if (this.size == 1) {
            deleteHead();
        }
        Node secondLastNode = getNodeAtIndex(this.size - 2);
        secondLastNode.next = null;
        this.tail = secondLastNode;
        this.size--;
        // System.out.println("deleteTail : size -> " + this.size+ " Head : " +
        // this.head.val + "Tail : " + this.tail.val);
        // printList(this.head);
    }

    public void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("END");

    }

    public Node getNodeAtIndex(int index) {
        Node node = head;
        // Traverse nodes till the given index, considering the list as 0 based list
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}

class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }
}