/*
Class Name  : DesignBrowserHistory
Description : This class consists of the solution for DesignBrowserHistory.
Created Date: Feb 28, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/design-browser-history/description/
Modification Log: 
Date					    Name                                            Description
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added Class DesignBrowserHistory
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added DesignBrowserHistory
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added visit
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added displayList
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added back
Feb 28, 2022			    Chandra Sekhar Reddy Muthumula					Added forward
--------------------------------------------------------------------------------------------------
1472. Design Browser History
Medium
2K
138
Companies
You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 

Example:

Input:
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
Output:
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

Explanation:
BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
 

Constraints:

1 <= homepage.length <= 20
1 <= url.length <= 20
1 <= steps <= 100
homepage and url consist of  '.' or lower case English letters.
At most 5000 calls will be made to visit, back, and forward.
------------------------------------------------------------------------------------------------------
*/
package Problems.DesignBrowserHistory;

public class DesignBrowserHistory {
    class Node {
        String url;
        Node next;
        Node prev;

        Node () {

        }
        Node(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }
    Node head;
    Node tail;
    Node tempTail;
    public DesignBrowserHistory(String homepage) {
        this.head = new Node(homepage);
        this.tail = head;
        this.tail.prev = head;
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);

        this.tail.next = newNode;
        newNode.prev = tail;
        this.tail = newNode;
        this.tempTail = this.tail;
        displayList(this.head);
    }
    
    public String back(int steps) {
        this.tempTail = this.tail;
        while(steps-- > 0 && this.tempTail.prev != null) {
            this.tempTail = this.tempTail.prev;
        }
        this.tail = this.tempTail;
        // displayList(this.head);
        return this.tempTail.url;
    }
    
    public String forward(int steps) {
        this.tempTail = this.tail;
        while(steps-- > 0 && this.tempTail.next != null) {
            this.tempTail = this.tempTail.next;
        }
        this.tail = this.tempTail;
        // displayList(this.head);
        return this.tempTail.url;
    }
    private void displayList(Node head) {
        if(head == null) {
            System.out.println("END");
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.url + " -> " );
            temp = temp.next;
        }
        System.out.println(" END");
    }
}